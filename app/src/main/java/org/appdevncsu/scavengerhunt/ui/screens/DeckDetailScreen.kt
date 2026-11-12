package org.appdevncsu.scavengerhunt.ui.screens

import android.widget.CheckBox
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import org.appdevncsu.scavengerhunt.data.model.SampleData
import org.appdevncsu.scavengerhunt.ui.arrow_back
import org.appdevncsu.scavengerhunt.ui.theme.ScavengerHuntTheme

@Composable
fun DeckDetailScreen(
    deckId: String,
    onBack: () -> Unit,
    onEdit: () -> Unit,
    onGo: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val deck = SampleData.decks.firstOrNull { it.id == deckId }!!

    val timerChecked = remember { mutableStateOf(true) }
    val disableImagesChecked = remember { mutableStateOf(false) }

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Row() {
            TextField(
                state = rememberTextFieldState(initialText = "5"),
                label = { Text("Number of locations:") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
        Row() {
            TextField(
                state = rememberTextFieldState(initialText = ""),
                label = { Text("Seed:") }
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = timerChecked.value,
                onCheckedChange = { timerChecked.value = it },
                )
            Text("Timer")
            Checkbox(
                checked = disableImagesChecked.value,
                onCheckedChange = { disableImagesChecked.value = it },
            )
            Text("Disable\nimages")
        }
        Row() {
            Button(onGo) { Text("Go") }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
private fun DeckDetailScreenPreview() {
    ScavengerHuntTheme {
        val deck = SampleData.decks.firstOrNull { it.id == SampleData.clubDeck.id }!!
        Scaffold(topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            contentDescription = "",
                            imageVector = arrow_back
                        )
                    }
                },
                title = {
                    Text(deck.name)
                }
            )
        }
        ) {
            innerPadding -> DeckDetailScreen(
                deckId = SampleData.clubDeck.id,
                onBack = {},
                onEdit = {},
                onGo = {},
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
