package com.ippon.victorultimate.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.ippon.victorultimate.R

@Composable
fun DescriptionText(
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(id = R.string.victor_ultimate_description),
        style = MaterialTheme.typography.headlineMedium,
        modifier = modifier,
        textAlign = TextAlign.Center,
        softWrap = true
    )
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewDescriptionText() {
    DescriptionText()
}