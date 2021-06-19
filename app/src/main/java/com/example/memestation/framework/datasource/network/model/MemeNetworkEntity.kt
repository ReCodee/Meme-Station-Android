package com.example.memestation.framework.datasource.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MemeNetworkEntity(
    @SerializedName("meme_id")
    @Expose
    val id : String,

    @SerializedName("meme_name")
    @Expose
    val name : String,

    @SerializedName("meme_image_url")
    @Expose
    val url : String,

    @SerializedName("meme_width")
    @Expose
    val width : Int,

    @SerializedName("meme_height")
    @Expose
    val height : Int,

    @SerializedName("meme_box_count")
    @Expose
    val box_count : Int
)
