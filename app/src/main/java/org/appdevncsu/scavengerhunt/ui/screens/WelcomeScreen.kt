package org.appdevncsu.scavengerhunt.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.appdevncsu.scavengerhunt.data.model.SampleData
import org.appdevncsu.scavengerhunt.ui.theme.ScavengerHuntTheme

@Composable
fun WelcomeScreen(
    onDeckClick: (String) -> Unit,
    onAddDeck: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val decks = SampleData.decks
    // ...
}

@Preview(showBackground = true)
@Composable
private fun WelcomeScreenPreview() {
    ScavengerHuntTheme {
        WelcomeScreen(
            onDeckClick = {},
            onAddDeck = {},
        )
    }
}
