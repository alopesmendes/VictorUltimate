package com.ippon.victorultimate.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ippon.victorultimate.R
import com.ippon.victorultimate.domain.models.CardDetailModel
import com.ippon.victorultimate.ui.components.CardDescription
import com.ippon.victorultimate.ui.components.RowStar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardDetailScreen(
    modifier: Modifier = Modifier,
    cardDetailModel: CardDetailModel?,
    onNavigateBack: () -> Unit,
) {
    BackHandler(onBack = onNavigateBack)

    cardDetailModel?.let {
        Scaffold(
            modifier = modifier,
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text(
                        text = cardDetailModel.name,
                        style = MaterialTheme.typography.titleMedium,
                    ) },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                onNavigateBack()
                            }
                        ) {
                            Icon(
                                Icons.Filled.Close,
                                contentDescription = null
                            )
                        }
                    }
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
            ) {
                cardDetailModel.level?.let { level ->
                    RowStar(
                        level = level,
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(16.dp)
                    )
                }
                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize(),
                    model = cardDetailModel.urlImage,
                    contentDescription = "Image",
                    placeholder = painterResource(id = R.drawable.baguette2),
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    cardDetailModel.attribute?.let { attribute ->
                        Text(
                            text = attribute,
                            style = MaterialTheme.typography.headlineMedium,
                            )
                    }

                    CardDescription(
                        modifier = Modifier,
                        type = cardDetailModel.type,
                        attack = cardDetailModel.attack,
                        defense = cardDetailModel.defense,
                        description = cardDetailModel.description,
                    )
                }
            }
        }

    } ?: Text(text = "empty")

}

@Preview(name = "CardDetailScreen")
@Composable
private fun PreviewCardDetailScreen() {
    CardDetailScreen(
        cardDetailModel = CardDetailModel(
            id = 6439,
            name = "Barbra Dillard",
            urlImage = "https://www.google.com/#q=consul",
            type = "erat",
            description = "iisque",
            attack = null,
            defense = null,
            level = null,
            attribute = null
        ),
        onNavigateBack = { }
    )
}