package org.appdevncsu.scavengerhunt.ui.screens

import android.R.attr.onClick
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import org.appdevncsu.scavengerhunt.data.model.SampleData
import org.appdevncsu.scavengerhunt.ui.theme.ScavengerHuntTheme
import org.appdevncsu.scavengerhunt.viewmodel.DeckListViewModel

@Composable
fun WelcomeScreen(
    onDeckClick: (String) -> Unit,
    onAddDeck: () -> Unit,
    viewModel: DeckListViewModel = viewModel(),
    modifier: Modifier = Modifier,
) {
    var name by remember { mutableStateOf(value = "")}
    var lastClicked by remember { mutableStateOf("")}
    val decks by viewModel.decklist.collectAsState()
    var currentText by remember { mutableStateOf("")}
    Column {
        Row {
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                (Text("Welcome"))
            }
            Column(
                horizontalAlignment = Alignment.End
            ) {
                (Text("filter"))
            }
        }

        val index = 0
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            repeat(decks.size) { index ->

                Row(
                    horizontalArrangement = Arrangement.Center
                ) {

                    Card() {
                        Text(text = decks[index].name)
                    }
                }
            }
        }

        Row {
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Card(
                    modifier = Modifier.clickable {lastClicked = "add deck"
                        currentText = ""
                    }
                ) {
                    Text(text = "add deck")

                }
                Card(
                    modifier = Modifier.clickable {lastClicked = "add"}
                ) {
                    currentText = "add"
                    TextField(value = currentText, onValueChange = {
                        newValue -> currentText = newValue
                    })
                }
            }
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Card(
                    modifier = Modifier.clickable {lastClicked = "edit" }
                ) {
                    Text(text = "edit")
                }
            }
        }
    }
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
