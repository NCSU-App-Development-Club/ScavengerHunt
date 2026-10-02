package org.appdevncsu.scavengerhunt.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.appdevncsu.scavengerhunt.R
import org.appdevncsu.scavengerhunt.data.model.SampleData
import org.appdevncsu.scavengerhunt.ui.theme.ScavengerHuntTheme

@Composable
fun PlayScreen(
    runId: String,
    onEnd: () -> Unit,
    onSkip: () -> Unit,
    onNext: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val run = SampleData.runs.firstOrNull { it.id == runId }!!
    val card = run.deck.locations.get(run.currentLocationIndex)
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row() {
            Text(card.name, fontSize = 40.sp, modifier = Modifier.padding(10.dp))
        }
        Row() {
            R.drawable.sample_holladay_hall
            Image(painter = painterResource(id = R.drawable.sample_holladay_hall), "", modifier = Modifier.padding(20.dp))
        }
        Row() {
            Text(card.description)
        }
        Row() {
            Text(getTimeString(run.totalElapsedMillis), fontSize = 20.sp, fontFamily = FontFamily.Monospace)
        }
        Row() {
            Button(onEnd) { Text("End") }
            Button(onSkip) { Text("Skip") }
            Button(onNext) { Text("Next") }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PlayScreenPreview() {
    ScavengerHuntTheme {
        PlayScreen(
            runId = SampleData.inProgressRun.id,
            onEnd = {},
            onSkip = {},
            onNext = {},
        )
    }
}

private fun getTimeString(elapsedTime: Long): String {
    val hours = ((elapsedTime / 1000) / 60 / 60).toString().padStart(2, '0')
    val minutes = ((elapsedTime / 1000) / 60 % 60).toString().padStart(2, '0')
    val seconds = ((elapsedTime / 1000) % 60).toString().padStart(2, '0')
    val millis = (elapsedTime % 1000).toString().padStart(3, '0')
    return "$hours:$minutes:$seconds.$millis"
}