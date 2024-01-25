package kso.android.kotlincoroutines.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import kso.android.kotlincoroutines.data.local.dao.UserDao
import me.amitshekhar.learn.kotlin.coroutines.data.local.entity.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}