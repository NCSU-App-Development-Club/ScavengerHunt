package org.appdevncsu.scavengerhunt.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.appdevncsu.scavengerhunt.data.model.SampleData
import org.appdevncsu.scavengerhunt.ui.theme.ScavengerHuntTheme

@Composable
fun CardEditorScreen(
    deckId: String,
    locationId: String?,
    onBack: () -> Unit,
    onSave: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val deck = SampleData.decks.firstOrNull { it.id == deckId }
    val location = deck?.locations?.firstOrNull { it.id == locationId }
    // ...
}

@Preview(showBackground = true)
@Composable
private fun CardEditorScreenPreview() {
    ScavengerHuntTheme {
        CardEditorScreen(
            deckId = SampleData.centennialDeck.id,
            locationId = SampleData.centennialDeck.locations.first().id,
            onBack = {},
            onSave = {},
        )
    }
}
