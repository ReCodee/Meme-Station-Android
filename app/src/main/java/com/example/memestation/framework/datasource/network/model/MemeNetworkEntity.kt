package com.example.memestation.framework.datasource.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MemeNetworkEntity(
    @SerializedName("id")
    @Expose
    val id : String,

    @SerializedName("name")
    @Expose
    val name : String,

    @SerializedName("url")
    @Expose
    val url : String,

    @SerializedName("width")
    @Expose
    val width : Int,

    @SerializedName("height")
    @Expose
    val height : Int,

    @SerializedName("box_count")
    @Expose
    val box_count : Int
)
