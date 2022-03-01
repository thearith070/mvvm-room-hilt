package com.ytdownload.mvvmroom.data.room

import androidx.room.*
import com.ytdownload.mvvmroom.data.model.InputItem
import kotlinx.coroutines.flow.Flow

@Dao
interface InputDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: InputItem)

    @Query("SELECT * FROM InputItem ORDER BY id DESC")
    fun getAll(): Flow<List<InputItem>>

    @Query("DELETE FROM InputItem WHERE id =:id")
    fun delete(id: Int)

}