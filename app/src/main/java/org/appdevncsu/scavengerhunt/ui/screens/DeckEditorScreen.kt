package org.appdevncsu.scavengerhunt.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.appdevncsu.scavengerhunt.data.model.SampleData
import org.appdevncsu.scavengerhunt.ui.theme.ScavengerHuntTheme

@Composable
fun DeckEditorScreen(
    deckId: String?,
    onBack: () -> Unit,
    onNewCard: () -> Unit,
    onCardClick: (String) -> Unit,
    onSave: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val deck = SampleData.decks.firstOrNull { it.id == deckId }
    // ...
}

@Preview(showBackground = true)
@Composable
private fun DeckEditorScreenPreview() {
    ScavengerHuntTheme {
        DeckEditorScreen(
            deckId = SampleData.centennialDeck.id,
            onBack = {},
            onNewCard = {},
            onCardClick = {},
            onSave = {},
        )
    }
}
