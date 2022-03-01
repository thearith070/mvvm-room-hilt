package com.ytdownload.mvvmroom.data.repo.main

import com.ytdownload.mvvmroom.data.model.InputItem
import kotlinx.coroutines.flow.Flow

interface MainRepo {

    suspend fun insert(item: InputItem)

    suspend fun delete(id: Int)

    fun getAll(): Flow<List<InputItem>>

}