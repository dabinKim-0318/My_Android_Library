package firebase

import Util.shortToast
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R
import com.example.kotlin_study.databinding.ActivityGoogleLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class GoogleLogin : AppCompatActivity() {
    lateinit var binding: ActivityGoogleLoginBinding


    private lateinit var auth: FirebaseAuth  //파이어베이스 인증 객체
    private lateinit var googleSignInClient: GoogleSignInClient //구글 API클라이언트 객체

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoogleLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //  Google 로그인을 앱에 통합: GoogleSignInOptions 객체를 구성할 때 requestIdToken을 호출
        //구글의 SIGNIN 버튼 눌릴떄 기본적으로 세팅되어야할 옵션
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            //클라이언트 ID를 requestIdToken 메서드에 전달
            .requestIdToken(getString(R.string.firebase_web_client_id))
            .requestEmail()
            .build()

        //구글 API클라이언트 객체를 초기화함
        googleSignInClient = GoogleSignIn.getClient(this, gso)

        //Firebase 인증객체 초기화하기
        auth = Firebase.auth

        //로그인 버튼 클릭 이벤트
        signIn()
    }


    // 활동을 초기화할 때 사용자가 현재 로그인되어 있는지 확인
    override fun onStart() {
        super.onStart()
        shortToast("FireBase 아이디 생성 완료")
        val user = auth.currentUser
        if (user != null) {
            val intent = Intent(this, FireBaseActivity::class.java).putExtra("nickname", user!!.displayName.toString())
            startActivity(intent)
        }
    }

    // 내 앱이랑 Google 로그인을 통합:onLogin으로부터 구글 사용자가 맞다는 결과값이 넘어오면
    //파이어 베이스를 넘긴다..
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // 구글 로그인 성공시 파이어베이스 연동
                val account = task.getResult(ApiException::class.java)!!
                //account라는 데이터는 구글 로그인 정보 담고있음
                //resultLogin(account)
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // 구글 로그인 실패시 UI업데이트
                Log.w(TAG, "Google sign in failed", e)
            }
        }
    }

    //아까까지는 인증이고 여기서부터는 리얼 로그인 성공됏냐 실패냐임
    // 사용자가 정상적으로 로그인하면 GoogleSignInAccount 객체에서 ID 토큰을 가져와서 Firebase 사용자 인증 정보로 교환하고 해당 정보를 사용해 Firebase에 인증
    //구글에서 파이어베이스로 넘겨지면 이 사람에 대한 정보인 idToken을 받아서 파이어베이스로 넘겨서 Autentication으로 값 넘어감
    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        //signInWithCredential에 대한 호출이 성공하면 getCurrentUser 메서드로 사용자의 계정 데이터를 가져올 수 있습니다.
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // 로그인 성공시 유아이를 유저 정보로 업데이트
                    shortToast("FireBase 아이디 생성 완료")
                    uiUpdate(auth.currentUser!!)

                } else {
                    // 로그인 실패시 유저에게 실패 메시지 띄우기
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                }
            }
    }

    // 로그인 버튼 클릭 이벤트: 버튼을 누르면 이 사람이 구글 사용자인지물어봄
    //구글 API객체로 넘어감(구글이 만든 Activity화면)
    private fun signIn() {
        binding.bvLogin.setOnClickListener {
            val signInIntent = googleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }
    }

    private fun uiUpdate(user: FirebaseUser) {
        val intent = Intent(this, FireBaseActivity::class.java).putExtra("nickname", user!!.displayName.toString())
        startActivity(intent)
    }

    companion object {
        private const val TAG = "GoogleActivity"
        private const val RC_SIGN_IN = 9001  //구글 로그인 결과 코드
    }
}