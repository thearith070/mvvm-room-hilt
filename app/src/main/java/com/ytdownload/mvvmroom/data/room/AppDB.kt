package com.ytdownload.mvvmroom.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ytdownload.mvvmroom.data.model.InputItem

@Database(
    entities = [InputItem::class],
    version = 1
)
abstract class AppDB : RoomDatabase() {

    abstract fun inputDao(): InputDao

}