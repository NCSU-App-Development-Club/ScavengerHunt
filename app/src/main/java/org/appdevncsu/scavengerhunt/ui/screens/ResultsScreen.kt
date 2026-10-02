package org.appdevncsu.scavengerhunt.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.appdevncsu.scavengerhunt.data.model.SampleData
import org.appdevncsu.scavengerhunt.ui.theme.ScavengerHuntTheme
import androidx.compose.material3.Text
import android.widget.Button
import androidx.compose.foundation.border
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ResultsScreen(
    runId: String,
    onDone: () -> Unit,
    onUpload: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val run = SampleData.runs.firstOrNull { it.id == runId }!!
    // ...
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Great Job!!!!", fontSize = 30.sp, modifier = Modifier.padding(all = 10.dp))
        Row() {
            Text("hours:minutes:seconds", fontSize = 20.sp, modifier = Modifier.padding(all = 10.dp))
        }

        Column(horizontalAlignment = Alignment.Start) {
            Text("Locations", fontSize = 15.sp)
            for (results in run.results) {

                Row(Modifier.border(.5.dp, Color.Black)) {
                    Text(results.location.name, fontSize = 12.sp, modifier = Modifier.padding(all = 3.dp))
                    Text("" + results.elapsedMillis, fontSize = 12.sp, modifier = Modifier.padding(all = 3.dp))
                }
            }
        }

        Row() {
            Button(onClick = onDone) { Text("Done")}
            Button(onClick = onUpload) { Text("[Upload]")}
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun ResultsScreenPreview() {
    ScavengerHuntTheme {
        ResultsScreen(
            runId = SampleData.completedRun.id,
            onDone = {},
            onUpload = {},
        )
    }
}



