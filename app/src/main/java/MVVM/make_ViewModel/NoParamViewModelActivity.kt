package MVVM.make_ViewModel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_study.R

class NoParamViewModelActivity : AppCompatActivity() {
    private lateinit var noParamViewModel: NoParamViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_param_view_model)

       /*  ViewModelProvider 생성자에 this 를 포함해주고, get() 메소드 내에 생성하고자 하는 뷰모델 클래스 타입을 넣어주면 됩니다.
        이때 this 는 ViewModelStoreOwner 타입이기 때문에 액티비티나 프래그먼트를 넣어주시면 됩니다
        (액티비티랑 프래그먼트는 ViewModelStoreOwner를 구현하고 있기 때문에 ViewModelStoreOwner의 타입은 viewModel을 생성하고 있는 현재 액티티비 또는 프래그먼트의 타입이됨 )*/
        noParamViewModel=ViewModelProvider(this).get(NoParamViewModel::class.java)

    }
}

