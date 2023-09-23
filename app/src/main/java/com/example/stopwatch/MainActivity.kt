package com.example.stopwatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stopwatch.ui.LapControllers
import com.example.stopwatch.ui.LapDetails
import com.example.stopwatch.ui.TimerClock
import com.example.stopwatch.ui.TopAppBar
import com.example.stopwatch.ui.theme.StopWatchTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StopWatchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StopWatchApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StopWatchApp() {

    var isRunning by rememberSaveable { mutableStateOf(false) }
    var startTime by rememberSaveable { mutableStateOf(0L) }
    var elapsedTime by rememberSaveable { mutableStateOf(0L) }
    var storedTime by rememberSaveable { mutableStateOf(0L) }
    var lapTime by rememberSaveable { mutableStateOf(listOf<Long>()) }
    var lapCount by rememberSaveable { mutableStateOf(listOf<Long>()) }
    var overallTime by rememberSaveable { mutableStateOf(listOf<Long>()) }


    LaunchedEffect(isRunning) {
        while (isRunning) {
            val currentTime = System.currentTimeMillis()
            elapsedTime = currentTime - startTime + storedTime
            delay(1)
        }
    }

    Scaffold(
        topBar = { TopAppBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.size(16.dp))
            TimerClock(
                circleColor = MaterialTheme.colorScheme.primaryContainer,
                textColor = MaterialTheme.colorScheme.onPrimaryContainer,
                elapsedTime = elapsedTime
            )
            Spacer(modifier = Modifier.size(20.dp))
            LapDetails(lapTime, overallTime, lapCount, Modifier.weight(1f))
            LapControllers(
                isRunning = isRunning,
                onPlayClick = {
                    isRunning = !isRunning
                    if (isRunning)
                        startTime = System.currentTimeMillis()
                    else
                        storedTime = elapsedTime
                },
                onStopClick = {
                    isRunning = false
                    startTime = 0L
                    elapsedTime = 0L
                    storedTime = 0L
                    lapTime = listOf()
                    lapCount = listOf()
                    overallTime = listOf()
                },
                onLapClick = {
                    lapTime = lapTime + listOf(elapsedTime - lapTime.sum())
                    lapCount = lapCount + listOf(lapCount.size.toLong() + 1)
                    overallTime = overallTime + listOf(elapsedTime)
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun StopWatchLightPreview() {
    StopWatchTheme {
        StopWatchApp()
    }
}

@Preview(showBackground = true)
@Composable
fun StopWatchDarkPreview() {
    StopWatchTheme(darkTheme = true) {
        StopWatchApp()
    }
}
