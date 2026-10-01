package org.appdevncsu.scavengerhunt.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    val run = SampleData.runs.firstOrNull { it.id == runId }
    // ...
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
