package org.appdevncsu.scavengerhunt.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.appdevncsu.scavengerhunt.data.model.Deck
import org.appdevncsu.scavengerhunt.data.model.SampleData.centennialDeck
import org.appdevncsu.scavengerhunt.data.model.SampleData.clubDeck
import org.appdevncsu.scavengerhunt.data.model.SampleData.friendsDeck
import org.appdevncsu.scavengerhunt.data.model.SampleData.umsteadDeck

class DeckListViewModel : ViewModel () {

    private val _decklist: MutableStateFlow<MutableList<Deck>> = MutableStateFlow(decks.toMutableList())
    val decklist: StateFlow<List<Deck>> = _decklist

    fun addDeck(

    ) {

    }

}

val decks: List<Deck> = listOf(clubDeck, friendsDeck, umsteadDeck, centennialDeck)


