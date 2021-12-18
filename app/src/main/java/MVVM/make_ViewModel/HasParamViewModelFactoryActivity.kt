package MVVM.make_ViewModel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_study.R

class HasParamViewModelFactoryActivity : AppCompatActivity() {
    private lateinit var hasParamViewModel: HasParamViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_has_param_view_model_factory)

        val sampleParam = "Ready Story"
        hasParamViewModel = ViewModelProvider(this, HasParamViewModelFactory(sampleParam)).get(HasParamViewModel::class.java)
    }
}