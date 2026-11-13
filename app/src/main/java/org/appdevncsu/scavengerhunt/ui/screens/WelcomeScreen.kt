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
    var name by remember { mutableStateOf(value = "") }
    var lastClicked by remember { mutableStateOf("") }
    val decks by viewModel.decklist.collectAsState()

    var isAddingDeck by remember { mutableStateOf(false) }
    var isEditingDeck by remember { mutableStateOf(false) }
    var currentAddText by remember { mutableStateOf("add") }
    var currentEditText by remember { mutableStateOf("add") }
    var currentDeck by remember { mutableStateOf("") }

    Column(modifier = modifier) {
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

                    Card(
                        modifier = Modifier.clickable { lastClicked = decks[index].name }
                    ) {
                            Text(text = decks[index].name)

                            if (isEditingDeck) {
                                currentDeck = lastClicked
                            }
                        }
                    }
                }
            }

            Row {
                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    Card(
                        modifier = Modifier.clickable {
                            if (!isAddingDeck) {
                                isAddingDeck = true
                            } else {
                                isAddingDeck = false
                                viewModel.addDeck(currentAddText)
                            }
                            currentAddText = ""
                        }
                    ) {
                        Text(text = "add deck")
                    }

                    if (isAddingDeck) {
                        Card(
                            modifier = Modifier.clickable { lastClicked = "add" }
                        ) {
                            TextField(value = currentAddText, onValueChange = { newValue ->
                                currentAddText = newValue
                            })
                        }
                    }
                }
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Card(
                        modifier = Modifier.clickable {
                            lastClicked = "edit"
                            if (!isEditingDeck) {
                                isEditingDeck = true
                            } else {
                                isEditingDeck = false
                                viewModel.editDeck(currentDeck,currentEditText)
                            }
                            currentEditText = ""
                        }
                    ) {
                        Text(text = "edit")
                    }

                    if (isEditingDeck) {
                        Card(
                            modifier = Modifier.clickable { lastClicked = "edit" }
                        ) {
                            TextField(value = currentEditText, onValueChange = { newValue ->
                                currentEditText = newValue
                            })
                        }
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
