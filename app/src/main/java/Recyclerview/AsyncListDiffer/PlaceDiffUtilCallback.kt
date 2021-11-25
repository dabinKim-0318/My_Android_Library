package Recyclerview.AsyncListDiffer

import Recyclerview.Data
import androidx.recyclerview.widget.DiffUtil

/*DiffUtil을 더 단순하게 사용할 수 있게 해주는 클래스다.
자체적으로 멀티 쓰레드에 대한 처리가 되어있기 때문에 개발자가 직접 동기화 처리를 할 필요가 없어진다.
AsyncDifferConfig로 backgroundThreadExecutor를 따로 설정하지 않는다면
Executors.newFixedThreadPool(2)로 쓰레드 풀을 하나 만들어서 비교 연산을 처리한다.*/
class PlaceDiffUtilCallback : DiffUtil.ItemCallback<Data>() {

    override fun areItemsTheSame(oldItem: Data, newItem: Data) =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: Data, newItem: Data) =
        oldItem.name == newItem.name
}


/*
class `1_BaseDiffUtil`<T>(private val newList: List<T>, private val oldList: List<T>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    //두 아이템이 동일한 아이템인지 체크한다.
    // 예를들어 item이 자신만의 고유한 id 같은걸 가지고 있다면 그걸 기준으로 삼으면 된다.
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        newList[newItemPosition] == oldList[oldItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        newList[newItemPosition] == oldList[oldItemPosition]
}*/
