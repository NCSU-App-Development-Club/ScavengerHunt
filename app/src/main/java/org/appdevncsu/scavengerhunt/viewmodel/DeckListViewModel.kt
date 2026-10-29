package org.appdevncsu.scavengerhunt.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.appdevncsu.scavengerhunt.data.model.Deck
import org.appdevncsu.scavengerhunt.data.model.SampleData.centennialDeck
import org.appdevncsu.scavengerhunt.data.model.SampleData.clubDeck
import org.appdevncsu.scavengerhunt.data.model.SampleData.friendsDeck
import org.appdevncsu.scavengerhunt.data.model.SampleData.umsteadDeck
import java.util.UUID

class DeckListViewModel : ViewModel () {

    private val _decklist: MutableStateFlow<List<Deck>> = MutableStateFlow(decks)
    val decklist: StateFlow<List<Deck>> = _decklist

    fun addDeck(name: String) {
        _decklist.update { previous ->
            previous + Deck(UUID.randomUUID().toString(), name)
        }
    }

    fun editDeck(oldName: String, newName: String) {
        _decklist.update { previous ->
            val list = previous.toMutableList()
            val index = previous.indexOfFirst { deck -> deck.name == oldName }
            list[index] = list[index].copy(name = newName)
            list
        }
    }
}

val decks: List<Deck> = listOf(clubDeck, friendsDeck, umsteadDeck, centennialDeck)


