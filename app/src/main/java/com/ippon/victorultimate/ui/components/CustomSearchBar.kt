package com.ippon.victorultimate.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ippon.victorultimate.domain.models.CardModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchBar(
    modifier: Modifier = Modifier,
    cardModels: List<CardModel>,
    value: String,
    onValueChange: (String) -> Unit,
    onClick: (Int) -> Unit,
) {
    var active by rememberSaveable {
        mutableStateOf(false)
    }
    val filterSearchItems by remember(value) {
        derivedStateOf {
            if (value.isNotBlank()) {
                cardModels.filter { it.name.lowercase().contains(value.lowercase()) }
            } else {
                cardModels
            }
        }
    }

    SearchBar(
        modifier = modifier,
        query = value,
        onQueryChange = onValueChange,
        onSearch = onValueChange,
        active = active,
        onActiveChange = { active = it },
        leadingIcon = {
            Icon(
                Icons.Filled.Search,
                contentDescription = null
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(filterSearchItems) {
                ListItem(
                    headlineContent = {
                        Text(text = it.name)
                    },
                    modifier = Modifier.clickable {
                        onClick(it.id)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun CustomSearchBarPreview() {
    var text by remember {
        mutableStateOf("")
    }
    CustomSearchBar(
        value = text,
        onValueChange = { text = it },
        cardModels = emptyList(),
        onClick = {}
    )
}