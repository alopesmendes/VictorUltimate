package com.ippon.victorultimate.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ippon.victorultimate.R
import com.ippon.victorultimate.domain.models.CardModel
import com.ippon.victorultimate.ui.components.CardList
import com.ippon.victorultimate.ui.components.CustomSearchBar
import com.ippon.victorultimate.ui.components.DescriptionText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    cardModels: List<CardModel>,
    onClick: (Int) -> Unit,
) {
    var search by rememberSaveable {
        mutableStateOf("")
    }
    val cardModelsNames = remember {
        mutableStateListOf<String>()
    }

    LaunchedEffect(cardModels.size) {
        cardModelsNames.addAll(cardModels.map { it.name })
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = stringResource(R.string.victor_ultimate_title))
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CustomSearchBar(
                value = search,
                onValueChange = { search = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                cardModels = cardModels,
                onClick = onClick,
            )
            DescriptionText(
                modifier = Modifier.fillMaxWidth()
            )
            CardList(
                cardModels = cardModels,
                onClick = onClick,
            )
        }
    }
}

@Preview(name = "HomeScreen")
@Composable
private fun PreviewHomeScreen() {
    HomeScreen(
        cardModels = (1..10).map {
            CardModel(
                name = "card $it",
                urlImage = "https://blenderandbasil.files.wordpress.com/2021/05/picos-16_9-close-up.jpg",
                type = "Spellcaster / Effect",
                description = "If you have x  and y and z in addition to this card in hand, you win the duel",
                attack = 1000,
                defense = 1000,
                level = 5,
                id = it
            )
        },
        onClick = {}
    )
}