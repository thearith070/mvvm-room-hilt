package com.ytdownload.mvvmroom.data.repo.main

import com.ytdownload.mvvmroom.data.model.InputItem
import com.ytdownload.mvvmroom.data.room.InputDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepoImpl @Inject constructor(
    private val inputDao: InputDao
) : MainRepo {

    override suspend fun insert(item: InputItem) {
        inputDao.insert(item)
    }

    override fun getAll(): Flow<List<InputItem>> {
        return inputDao.getAll()
    }

    override suspend fun delete(id: Int) {
        inputDao.delete(id)
    }
}