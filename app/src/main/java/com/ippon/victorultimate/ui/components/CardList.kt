package com.ippon.victorultimate.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ippon.victorultimate.domain.models.CardModel

@Composable
fun CardList(
    modifier: Modifier = Modifier,
    cardModels: List<CardModel>,
    onClick: (Int) -> Unit,
) {
    LazyColumn(
        modifier = modifier,
    ) {
        items(cardModels, key = { it.id } ) { cardModel ->
            CustomCard(
                cardModel = cardModel,
                onClick = onClick,
            )
        }
    }
}

@Preview(name = "CardList")
@Composable
private fun PreviewCardList() {
    CardList(
        cardModels = (1..5).map {
            CardModel(
                name = "name $it",
                urlImage = "https://blenderandbasil.files.wordpress.com/2021/05/picos-16_9-close-up.jpg",
                type = "Spellcaster / Effect",
                description = "If you have x and y and z in addition to this card in hand, you win the duel",
                attack = 1000,
                defense = 1000,
                level = 5,
                id = it
            )
        },
        onClick = {},
    )
}