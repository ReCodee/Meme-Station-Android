package com.example.memestation.bussiness.domain.model

import com.example.memestation.framework.datasource.network.model.MemeNetworkEntity

data class Data(
    public val meme : List<MemeNetworkEntity>
)
