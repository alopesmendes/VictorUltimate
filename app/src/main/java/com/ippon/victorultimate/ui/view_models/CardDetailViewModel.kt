package com.ippon.victorultimate.ui.view_models

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ippon.victorultimate.domain.models.CardDetailModel
import com.ippon.victorultimate.domain.repositories.CardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardDetailViewModel @Inject constructor(
    private val cardRepository: CardRepository,
    savedStateHandle: SavedStateHandle,
): ViewModel() {
    private val id = savedStateHandle.get<Int>("id")
    private val _cardDetailModel: MutableStateFlow<CardDetailModel?> = MutableStateFlow(null)
    val cardDetailModel = _cardDetailModel.asStateFlow()

    init {
        loadCardModel()
    }

    private fun loadCardModel() {
        viewModelScope.launch {
            val model = id?.let { cardRepository.getCardDetailModel(it) }
            _cardDetailModel.update { model }
        }
    }
}