package com.example.memestation.framework.datasource.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RawData(
    @SerializedName("success")
    @Expose
    private val success : Boolean,

    @SerializedName("data")
    @Expose
    public val data : Data
)
