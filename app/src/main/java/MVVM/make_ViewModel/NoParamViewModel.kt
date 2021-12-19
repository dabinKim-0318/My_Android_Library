package MVVM.make_ViewModel

import androidx.lifecycle.ViewModel

/*- ViewModel은 ViewModelStore라는 객체에서 관리한다
- ViewModelStore 클래스는 내부적으로 HashMap<String, ViewModel> 를 두어 ViewModel 을 관리합니다.
- ViewModelStore 객체는 ViewModelStoreOwner가 관리한다
=> ViewModel->ViewModelStore->ViewModelStoreOwner
public interface ViewModelStoreOwner {
    @NonNull
    ViewModelStore getViewModelStore();
}
- ViewModelStoreOwner는 인터페이스인데  FragmentActivity 의 부모격인ComponentActivity와 Fragment 클래스가 이를 구현하고있다.
- 액티비티, 프래그먼트가 ViewModelStoreOwner를 구현하고 있기 때문에 우린 ViewModel객체를 생성할떄
- 액티비티, 프래그먼트를 필요로 하고, 어떤 Owner를 통해 생성하냐에 따라 ViewModel의 범위가 결정된다.
- 하지만 액티비티, 프래그먼트만 있다고 ViewModel을 생성할수 있는게 아니다.
- ViewModel을 생성할떄는 실질적으로 ViewModel인스턴스를 생성하는 역할을 하는 팩토리가 필요하다.
- ViewModelProvider 안에 정의되어있는 Factory는 아래와 같은 인터페이스 형태다
public class ViewModelProvider {
    public interface Factory {
        @NonNull
        <T extends ViewModel> T create(@NonNull Class<T> modelClass);
    }
}*/

//1. 파라미터가 없는 ViewModel - Lifecycle Extensions
class NoParamViewModel : ViewModel() {
}