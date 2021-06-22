package com.example.memestation.framework.presentation

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.memestation.bussiness.domain.model.Meme
import com.example.memestation.bussiness.interactors.MemeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class MemeViewModel
@Inject
constructor(private val memeRepository: MemeRepository) : ViewModel() {

      val memeData : MutableState<List<Meme>> = mutableStateOf(listOf())
         //val memeData : LiveData<List<Meme>> get() = _memeData

    init {
        viewModelScope.launch {
            memeData.value = memeRepository.execute()
            Log.d("ApiCheck", memeData.value.toString() )
        }
    }
}