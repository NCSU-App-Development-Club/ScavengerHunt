package org.appdevncsu.scavengerhunt.navigation

import kotlinx.serialization.Serializable

/** Represents a navigation destination - a serializable object that defines where the user is in the app */
sealed interface Destination

/** Deck list ("Welcome" screen). Start destination. */
@Serializable
data object Welcome : Destination

/** A single deck's overview and pre-game settings ("Club Deck" screen). */
@Serializable
data class DeckDetail(val deckId: String) : Destination

/** An in-progress playthrough ("Red Triangles" screen). */
@Serializable
data class Play(val runId: String) : Destination

/** Finished playthrough summary ("Great Job" screen). */
@Serializable
data class Results(val runId: String) : Destination

/** Create or edit a deck ("Centennial" screen). [deckId] is null when creating a new deck. */
@Serializable
data class DeckEditor(val deckId: String? = null) : Destination

/** Create or edit a card ("EB311" screen). [locationId] is null when adding a new card. */
@Serializable
data class CardEditor(val deckId: String, val locationId: String? = null) : Destination
