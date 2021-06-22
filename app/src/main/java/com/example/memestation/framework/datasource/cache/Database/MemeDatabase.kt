package com.example.memestation.framework.datasource.cache.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.memestation.framework.datasource.cache.model.MemeCacheEntity

@Database(entities = [MemeCacheEntity::class], version = 1)
abstract class MemeDatabase : RoomDatabase() {

    abstract fun memeDao() : MemeDao

    companion object {
        val DATABASE_NAME : String = "meme_db"
    }

}