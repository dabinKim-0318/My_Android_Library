package MVVM.make_ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class HasParamViewModelFactory(private val param: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HasParamViewModel::class.java)) {
            HasParamViewModel(param) as T
        } else {
            throw IllegalArgumentException()
        }
    }
}