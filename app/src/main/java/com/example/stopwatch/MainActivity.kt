package com.example.stopwatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stopwatch.ui.theme.StopWatchTheme
import com.example.stopwatch.ui.theme.fontFamily

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
            Spacer(modifier = Modifier.size(36.dp))
            TimerClock(
                circleColor = MaterialTheme.colorScheme.primaryContainer,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Stop Watch",
                style = MaterialTheme.typography.displayLarge,
            )
        },
    )
}

@Composable
fun TimerClock(circleColor: Color) {
    Box(
        contentAlignment = Alignment.Center,
    ) {
        Canvas(modifier = Modifier.size(250.dp), onDraw = {
            drawCircle(color = circleColor)
        })
        Row() {
            DrawClockText(count = "00", unit = "MIN")
            Spacer(modifier = Modifier.size(8.dp))
            DrawClockText(count = "00", unit = "SEC")
            Spacer(modifier = Modifier.size(8.dp))
            DrawClockText(count = "00", unit = "MIL")

        }

    }

}

@Composable
fun DrawClockText(count: String, unit: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = count,
            style = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 45.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp
            ),
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = unit,
            style = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 24.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.sp
            ),
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
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
