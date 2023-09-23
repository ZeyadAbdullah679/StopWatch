package com.example.stopwatch.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
            .fillMaxWidth(),
    ) {
        ItemTextHeader(type = "Lap", modifier = Modifier.weight(1f))
        ItemTextHeader(type = "Lap Time", modifier = Modifier.weight(1f))
        ItemTextHeader(type = "Overall", modifier = Modifier.weight(1f))
    }
    Spacer(modifier = Modifier.height(8.dp))
    LazyColumn(
        modifier
            .fillMaxWidth()
    ) {
        items(lapTime.size) { index ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .weight(1f)
                ) {
                    val circleColor = MaterialTheme.colorScheme.primaryContainer
                    Canvas(modifier = Modifier.size(24.dp), onDraw = {
                        drawCircle(color = circleColor)
                    })
                    Text(
                        text = lapCount[index].toString(),
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier,
                        textAlign = TextAlign.Center
                    )
                }
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
