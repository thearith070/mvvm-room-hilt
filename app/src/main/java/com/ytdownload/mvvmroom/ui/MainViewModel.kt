package com.ytdownload.mvvmroom.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ytdownload.mvvmroom.data.model.InputItem
import com.ytdownload.mvvmroom.data.repo.main.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: MainRepo
) : ViewModel() {

    val data = flow {
        emitAll(repo.getAll())
    }

    fun insert(input: String) {
        viewModelScope.launch {
            repo.insert(InputItem(input = input))
        }
    }

    fun delete(id: Int) {
        viewModelScope.launch {
            repo.delete(id)
        }
    }
}