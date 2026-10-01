package org.appdevncsu.scavengerhunt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import org.appdevncsu.scavengerhunt.navigation.ScavengerHuntNavHost
import org.appdevncsu.scavengerhunt.ui.theme.ScavengerHuntTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScavengerHuntTheme {
                ScavengerHuntNavHost()
            }
        }
    }
}
