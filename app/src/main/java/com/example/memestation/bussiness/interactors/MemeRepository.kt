package com.example.memestation.bussiness.interactors

import com.example.memestation.bussiness.data.network.NetworkDataSource
import com.example.memestation.bussiness.domain.model.Meme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MemeRepository
@Inject
constructor(
    private val networkDataSource: NetworkDataSource,
) {

    suspend fun execute() : List<Meme> = networkDataSource.get()

}