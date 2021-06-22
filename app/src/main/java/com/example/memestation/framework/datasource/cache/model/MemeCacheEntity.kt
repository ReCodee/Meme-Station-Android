package com.example.memestation.framework.datasource.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MemeData")
data class MemeCacheEntity(

/*
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "primary_key")
    var pk : Int,
*/

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id : String,

    @ColumnInfo(name = "name")
    var name : String,

    @ColumnInfo(name = "url")
    var url : String,

    @ColumnInfo(name = "width")
    var width : Int,

    @ColumnInfo(name = "height")
    var height : Int,

    @ColumnInfo(name = "box_count")
    var box_count : Int
)
