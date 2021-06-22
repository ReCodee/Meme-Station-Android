package com.example.memestation.framework.datasource.cache.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.memestation.framework.datasource.cache.model.MemeCacheEntity

@Dao
interface MemeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
 suspend fun insert(memeCacheEntity: MemeCacheEntity) : Long

   @Query("SELECT * FROM MemeData")
   suspend fun get() : List<MemeCacheEntity>

}