package kso.android.kotlincoroutines.data.local

import kso.android.kotlincoroutines.data.local.AppDatabase
import kso.android.kotlincoroutines.data.local.DatabaseHelper
import me.amitshekhar.learn.kotlin.coroutines.data.local.entity.User

class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {

    override suspend fun getUsers(): List<User> = appDatabase.userDao().getAll()

    override suspend fun insertAll(users: List<User>) = appDatabase.userDao().insertAll(users)

}