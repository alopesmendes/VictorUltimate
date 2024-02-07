package com.ippon.victorultimate.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ippon.victorultimate.R
import com.ippon.victorultimate.domain.models.CardModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomCard(
    modifier: Modifier = Modifier,
    cardModel: CardModel,
    onClick: (Int) -> Unit,
) {
    ElevatedCard(
        modifier = modifier
            .padding(16.dp),
        onClick = { onClick(cardModel.id) },
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = cardModel.name,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            cardModel.level?.let {
                RowStar(
                    level = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(16.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .aspectRatio(1f)
                        .border(BorderStroke(2.dp, Color.Black)),
                    model = cardModel.urlImage,
                    contentDescription = "Image",
                    placeholder = painterResource(id = R.drawable.baguette2),
                    contentScale = ContentScale.Crop
                )

                CardDescription(
                    modifier = Modifier,
                    type = cardModel.type,
                    attack = cardModel.attack,
                    defense = cardModel.defense,
                    description = cardModel.description,
                )
            }
        }
    }
}

@Preview(name = "CustomCard", showSystemUi = false, showBackground = true, apiLevel = 30)
@Composable
private fun PreviewCustomCard() {
    CustomCard(
        cardModel = CardModel(
            name = "Curse of the Sorceress",
            urlImage = "https://blenderandbasil.files.wordpress.com/2021/05/picos-16_9-close-up.jpg",
            type = "Spellcaster / Effect",
            description = "If you have x  and y and z in addition to this card in hand, you win the duel",
            attack = 1000,
            defense = 1000,
            level = 5,
            id = 1,
        ),
        onClick = {}
    )
}