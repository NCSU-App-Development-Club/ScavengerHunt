package org.appdevncsu.scavengerhunt.data.model

import org.appdevncsu.scavengerhunt.R

/**
 * Hard-coded sample data for building and previewing composables.
 */
object SampleData {

    // region Decks

    /** The deck featured across the play/results wireframes; has the 5 locations shown on-screen. */
    val clubDeck = Deck(
        id = "deck-club",
        name = "Club Deck",
        locations = listOf(
            Location(
                id = "loc-red-triangles",
                name = "Red Triangles",
                description = "Three red triangular sculptures in the courtyard.",
                photoResId = R.drawable.sample_holladay_hall,
            ),
            Location(
                id = "loc-hunt-library",
                name = "Hunt Library",
                description = "The big modern library at the end of the oval.",
                photoResId = R.drawable.sample_hunt_library,
            ),
            Location(
                id = "loc-park-triangle",
                name = "Park Triangle",
                description = "The grassy triangle by the park entrance.",
                photoResId = R.drawable.sample_umstead_trail,
            ),
            Location(
                id = "loc-talley",
                name = "Talley Student Union",
                description = "Where everyone meets for lunch.",
                photoResId = R.drawable.sample_talley_student_union,
            ),
            Location(
                id = "loc-dh-hill",
                name = "D.H. Hill Library",
                description = "The brick library next to the Brickyard.",
                photoResId = R.drawable.sample_dh_hill_library,
            ),
        ),
        settings = DeckSettings(timerEnabled = true, imagesDisabled = false),
    )

    val friendsDeck = Deck(
        id = "deck-friends",
        name = "Friends Deck",
        locations = listOf(
            Location(
                id = "loc-oval",
                name = "The Oval",
                description = "The long lawn in the middle of campus.",
                photoResId = R.drawable.sample_memorial_belltower,
            ),
            Location(
                id = "loc-free-expression-tunnel",
                name = "Free Expression Tunnel",
                description = "Painted tunnel connecting main and north campus.",
                photoResId = R.drawable.sample_free_expression_tunnel,
            ),
            Location(
                id = "loc-memorial-belltower",
                name = "Memorial Belltower",
                description = "The belltower that glows red after big wins.",
                photoResId = R.drawable.sample_memorial_belltower,
            ),
        ),
        settings = DeckSettings(timerEnabled = false, imagesDisabled = false),
    )

    val umsteadDeck = Deck(
        id = "deck-umstead",
        name = "Umstead",
        locations = listOf(
            Location(
                id = "loc-loblolly-trail",
                name = "Loblolly Trail",
                description = "The long hiking loop through the pines.",
                photoResId = R.drawable.sample_umstead_forest,
            ),
            Location(
                id = "loc-reedy-creek-lake",
                name = "Reedy Creek Lake",
                description = "The lake at the south end of the park.",
                photoResId = R.drawable.sample_umstead_pond,
            ),
            Location(
                id = "loc-bridle-trails",
                name = "Bridle Trails",
                description = "The horse trails on the west side.",
                photoResId = R.drawable.sample_umstead_trail,
            ),
        ),
        settings = DeckSettings(timerEnabled = true, imagesDisabled = true),
    )

    /** Matches the "Centennial" deck editor screen, including the "EB311" card edit. */
    val centennialDeck = Deck(
        id = "deck-centennial",
        name = "Centennial",
        locations = listOf(
            Location(
                id = "loc-eb311",
                name = "EB311",
                description = "Brick building",
                // No photo: this card is in the editor's "Remove photo" state.
                photoResId = null,
            ),
            Location(
                id = "loc-fitts-woolard",
                name = "Fitts-Woolard Hall",
                description = "The glass engineering building.",
                photoResId = R.drawable.sample_fitts_woolard_hall,
            ),
            Location(
                id = "loc-venture-building",
                name = "Venture Building",
                description = "The startup space beside the roundabout.",
                photoResId = R.drawable.sample_holladay_hall,
            ),
        ),
        settings = DeckSettings(timerEnabled = true, imagesDisabled = false),
    )

    /** Backs the "Welcome" deck list. */
    val decks: List<Deck> = listOf(clubDeck, friendsDeck, umsteadDeck, centennialDeck)

    // endregion

    // region Runs

    /**
     * Backs the play screen: on "Red Triangles" with the timer reading 00:08:25.10.
     * 8 min 25.10 s == 505_100 ms.
     */
    val inProgressRun = HuntRun(
        id = "run-club-001",
        deck = clubDeck,
        settings = clubDeck.settings,
        status = RunStatus.IN_PROGRESS,
        startedAtEpochMillis = 1_752_000_000_000,
        currentLocationIndex = 0,
        currentLocationElapsedMillis = 505_100,
    )

    /**
     * Backs the "Great Job" screen. The per-location times sum to 4_865_210 ms,
     * which reads as 01:21:05.21 on the results header.
     */
    val completedRun = HuntRun(
        id = "run-club-002",
        deck = clubDeck,
        settings = clubDeck.settings,
        status = RunStatus.COMPLETED,
        startedAtEpochMillis = 1_752_600_000_000,
        currentLocationIndex = clubDeck.locations.lastIndex,
        results = listOf(
            LocationResult(
                location = clubDeck.locations[0],
                elapsedMillis = 1_205_000,
                outcome = LocationOutcome.FOUND,
            ),
            LocationResult(
                location = clubDeck.locations[1],
                elapsedMillis = 905_210,
                outcome = LocationOutcome.FOUND,
            ),
            LocationResult(
                location = clubDeck.locations[2],
                elapsedMillis = 1_000_000,
                outcome = LocationOutcome.FOUND,
            ),
            LocationResult(
                location = clubDeck.locations[3],
                elapsedMillis = 855_000,
                outcome = LocationOutcome.FOUND,
            ),
            LocationResult(
                location = clubDeck.locations[4],
                elapsedMillis = 900_000,
                outcome = LocationOutcome.SKIPPED,
            ),
        ),
    )

    /** All runs, handy for a history screen later. */
    val runs: List<HuntRun> = listOf(inProgressRun, completedRun)

    // endregion
}
