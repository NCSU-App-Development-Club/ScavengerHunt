package org.appdevncsu.scavengerhunt.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.appdevncsu.scavengerhunt.ui.screens.CardEditorScreen
import org.appdevncsu.scavengerhunt.ui.screens.DeckDetailScreen
import org.appdevncsu.scavengerhunt.ui.screens.DeckEditorScreen
import org.appdevncsu.scavengerhunt.ui.screens.PlayScreen
import org.appdevncsu.scavengerhunt.ui.screens.ResultsScreen
import org.appdevncsu.scavengerhunt.ui.screens.WelcomeScreen

@Composable
fun ScavengerHuntNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(navController = navController, startDestination = Welcome) {

        composable<Welcome> {
            WelcomeScreen(
                onDeckClick = { },
                onAddDeck = { },
            )
        }

        composable<DeckDetail> { backStackEntry ->
            val route = backStackEntry.toRoute<DeckDetail>()
            DeckDetailScreen(
                deckId = route.deckId,
                onBack = { },
                onEdit = { },
                onGo = { },
            )
        }

        composable<Play> { backStackEntry ->
            val route = backStackEntry.toRoute<Play>()
            PlayScreen(
                runId = route.runId,
                onEnd = { },
                onSkip = { },
                onNext = { },
            )
        }

        composable<Results> { backStackEntry ->
            val route = backStackEntry.toRoute<Results>()
            ResultsScreen(
                runId = route.runId,
                onDone = { },
            )
        }

        composable<DeckEditor> { backStackEntry ->
            val route = backStackEntry.toRoute<DeckEditor>()
            DeckEditorScreen(
                deckId = route.deckId,
                onBack = { },
                onNewCard = { },
                onCardClick = { },
                onSave = { },
            )
        }

        composable<CardEditor> { backStackEntry ->
            val route = backStackEntry.toRoute<CardEditor>()
            CardEditorScreen(
                deckId = route.deckId,
                locationId = route.locationId,
                onBack = { },
                onSave = { },
            )
        }
    }
}
