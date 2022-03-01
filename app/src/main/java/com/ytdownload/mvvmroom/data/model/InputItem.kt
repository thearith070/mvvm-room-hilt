package com.ytdownload.mvvmroom.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class InputItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val input: String
)