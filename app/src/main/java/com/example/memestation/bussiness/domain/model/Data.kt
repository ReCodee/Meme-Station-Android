package com.example.memestation.bussiness.domain.model

import com.example.memestation.framework.datasource.network.model.MemeNetworkEntity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("memes")
    @Expose
    public val memes : List<MemeNetworkEntity>
)
