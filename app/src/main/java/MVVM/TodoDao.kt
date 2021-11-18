package MVVM

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDao  {

    @Query("SELECT * FROM Todo")
    fun getAll(): LiveData<List<Todo>>  //데이터를 얻어올때 라이브데이터로 감싸네

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(todo: Todo)

    @Delete
    fun delete(todo: Todo)
}