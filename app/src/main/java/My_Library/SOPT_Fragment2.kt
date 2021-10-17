package My_Library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlin_study.databinding.FragmentSopt2Binding


class SOPT_Fragment2 : Fragment() {
    private var _binding: FragmentSopt2Binding? = null  //binding 파일 이름이 Activity로 시작하지 않을 수 있네
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentSopt2Binding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}