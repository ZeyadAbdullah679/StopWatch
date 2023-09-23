package com.example.stopwatch.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun LapDetails(
    lapTime: List<Long>,
    overallTime: List<Long>,
    lapCount: List<Long>,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        ItemTextHeader(type = "Lap", modifier = Modifier.weight(1f))
        ItemTextHeader(type = "Lap Time", modifier = Modifier.weight(1f))
        ItemTextHeader(type = "Overall", modifier = Modifier.weight(1f))
    }
    LazyColumn(
        modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp),
    ) {
        items(lapTime.size) { index ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
            ) {
                Text(
                    text = lapCount[index].toString(),
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = formatMilliseconds(lapTime[index]).toString()
                        .drop(1).dropLast(1)
                        .replace(", ", " : "),
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = formatMilliseconds(overallTime[index]).toString()
                        .drop(1).dropLast(1)
                        .replace(", ", " : "),
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun ItemTextHeader(type: String, modifier: Modifier = Modifier) {
    Text(
        text = type,
        style = MaterialTheme.typography.titleMedium,
        modifier = modifier
            .padding(8.dp),
        textAlign = TextAlign.Center
    )
}
