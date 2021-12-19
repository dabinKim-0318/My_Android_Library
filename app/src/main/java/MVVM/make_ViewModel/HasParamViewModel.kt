package MVVM.make_ViewModel

import androidx.lifecycle.ViewModel

/*ViewModelProvider.Factory 를 구현하면 파라미터를 소유하고 있는 ViewModel 객체의 인스턴스를 생성할 수 있습니다.
직접 구현한 Factory 클래스에 파라미터를 넘겨주어 create() 내에서 인스턴스를 생성할 때 활용하면 됩니다.*/
class HasParamViewModel(val param: String) : ViewModel() {

}