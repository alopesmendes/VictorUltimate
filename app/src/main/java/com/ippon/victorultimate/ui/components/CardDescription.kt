package com.ippon.victorultimate.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CardDescription(
    modifier: Modifier = Modifier,
    type: String,
    description: String,
    attack: Int?,
    defense: Int?,
) {
    val attackStr by remember(attack) {
        derivedStateOf {
            attack?.let { "$it" } ?: "???"
        }
    }
    val defenseStr by remember(defense) {
        derivedStateOf {
            defense?.let { "$it" } ?: "???"
        }
    }
    Column(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = type,
                fontWeight = FontWeight.ExtraBold,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize
            )
            Text(
                text = description,
                color = MaterialTheme.colorScheme.outline,
                style = MaterialTheme.typography.labelSmall
            )
        }

        Divider(
            thickness = 2.dp,
            color = Color.Black
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
        ) {
            Text(text = "ATK/${attackStr}")
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "DEF/${defenseStr}")
        }
        Divider(
            thickness = 2.dp,
            color = Color.Black
        )
    }
}

@Preview(name = "CardDescription", showSystemUi = true)
@Composable
private fun PreviewCardDescription() {
    CardDescription(
        type = "Spellcaster / Effect",
        description = "If you have x  and y and z in addition to this card in hand, you win the duel",
        attack = 1000,
        defense = 1000,
    )
}