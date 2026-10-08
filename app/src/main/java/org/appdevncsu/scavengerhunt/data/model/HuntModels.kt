package org.appdevncsu.scavengerhunt.data.model

import androidx.annotation.DrawableRes

/**
 * Core domain models for the Scavenger Hunt app.
 *
 * These mirror the screens sketched in the wireframes:
 *  - [Deck]        -> "Welcome" list entries and the "Club Deck" / "Centennial" editor headers.
 *  - [Location]    -> a single card inside a deck (card editor screen: name, photo, description).
 *  - [DeckSettings]-> the "Timer" / "disable images" toggles chosen before starting a hunt.
 *  - [HuntRun]     -> an in-progress or finished playthrough (play screen and "Great Job" screen).
 *  - [LocationResult] -> one row of the per-location breakdown on the "Great Job" screen.
 */
data class Deck(
    val id: String,
    val name: String,
    val locations: List<Location> = emptyList(),
    val settings: DeckSettings = DeckSettings(),
) {
    /** Displayed as "# locations" on the deck screen. */
    val locationCount: Int get() = locations.size
}

/** Pre-game options shown on the deck screen before the user taps "Go". */
data class DeckSettings(
    val timerEnabled: Boolean = true,
    val imagesDisabled: Boolean = false,
)

/** A single scavenger item ("card"). */
data class Location(
    val id: String,
    val name: String,
    /** Shown under "desc." in the card editor. */
    val description: String = "",
    /**
     * Drawable resource id of the location's photo.
     * `null` means no photo has been uploaded (the editor's "Remove photo" state).
     */
    @DrawableRes val photoResId: Int? = null,
)

enum class RunStatus {
    IN_PROGRESS,
    COMPLETED,
    ABANDONED,
}

enum class LocationOutcome {
    /** Player reached the location and tapped "next". */
    FOUND,

    /** Player tapped "skip". */
    SKIPPED,
}

/**
 * A single playthrough of a [Deck].
 */
data class HuntRun(
    val id: String,
    val deck: Deck,
    /** A copy of the settings used when the run was started. */
    val settings: DeckSettings,
    val status: RunStatus,
    val startedAtEpochMillis: Long,
    /** The index of the location currently shown on the Play screen. */
    val currentLocationIndex: Int = 0,
    /** Time spent on the current location so far, shown as the play-screen timer. */
    val currentLocationElapsedMillis: Long = 0,
    val results: List<LocationResult> = emptyList(),
) {
    /** The location currently shown on the play screen, or `null` if there is none. */
    val currentLocation: Location?
        get() = deck.locations.getOrNull(currentLocationIndex)

    /** Total time displayed at the top of the "Great Job" screen. */
    val totalElapsedMillis: Long
        get() = results.sumOf { it.elapsedMillis }

    val isComplete: Boolean get() = status == RunStatus.COMPLETED
}

/** One location's row in the "Great Job" results list. */
data class LocationResult(
    val location: Location,
    val elapsedMillis: Long,
    val outcome: LocationOutcome = LocationOutcome.FOUND,
)
