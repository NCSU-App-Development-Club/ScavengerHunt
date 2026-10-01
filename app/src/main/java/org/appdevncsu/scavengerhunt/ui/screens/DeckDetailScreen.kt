package org.appdevncsu.scavengerhunt.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.appdevncsu.scavengerhunt.data.model.SampleData
import org.appdevncsu.scavengerhunt.ui.theme.ScavengerHuntTheme

@Composable
fun DeckDetailScreen(
    deckId: String,
    onBack: () -> Unit,
    onEdit: () -> Unit,
    onGo: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val deck = SampleData.decks.firstOrNull { it.id == deckId }
    // ...
}

@Preview(showBackground = true)
@Composable
private fun DeckDetailScreenPreview() {
    ScavengerHuntTheme {
        DeckDetailScreen(
            deckId = SampleData.clubDeck.id,
            onBack = {},
            onEdit = {},
            onGo = {},
        )
    }
}
