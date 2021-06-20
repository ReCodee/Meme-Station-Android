package com.example.memestation.framework.presentation

import android.util.Log
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

    private val _dataCheck : MutableLiveData<List<Meme>> = MutableLiveData()
    public val dataCheck : LiveData<List<Meme>> get() = _dataCheck

    fun startCheck() {
        viewModelScope.launch {
            _dataCheck.value = memeRepository.execute()
        }
    }
}