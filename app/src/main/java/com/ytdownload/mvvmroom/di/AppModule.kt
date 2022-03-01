package com.ytdownload.mvvmroom.di

import android.content.Context
import androidx.room.Room
import com.ytdownload.mvvmroom.data.repo.main.MainRepo
import com.ytdownload.mvvmroom.data.repo.main.MainRepoImpl
import com.ytdownload.mvvmroom.data.room.AppDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun provideMainRepo(repo: MainRepoImpl): MainRepo {
        return repo
    }

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): AppDB = Room.databaseBuilder(
        context,
        AppDB::class.java,
        "app_db.db"
    )
        .fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .build()


    @Provides
    fun provideInputDao(
        db: AppDB
    ) = db.inputDao()

}