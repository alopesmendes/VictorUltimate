package com.ippon.victorultimate.ui.view_models

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ippon.victorultimate.domain.models.CardModel
import com.ippon.victorultimate.domain.repositories.CardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardViewModel @Inject constructor(
    private val cardRepository: CardRepository
): ViewModel() {

    private val _cardModels: MutableStateFlow<List<CardModel>> = MutableStateFlow(emptyList())
    val cardModels = _cardModels.asStateFlow()

    init {
        loadCardModels()
    }

    private fun loadCardModels() {
        viewModelScope.launch {
            val models = cardRepository.getCardsModels()
            Log.d(CardViewModel::class.simpleName, "loadCardModels: $models")
            _cardModels.update { models }
        }
    }
}