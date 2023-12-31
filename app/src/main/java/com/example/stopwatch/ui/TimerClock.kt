package com.example.stopwatch.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stopwatch.ui.theme.fontFamily

@Composable
fun TimerClock(circleColor: Color, textColor: Color, elapsedTime: Long) {
    val time = formatMilliseconds(elapsedTime)
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(275.dp)
            .shadow(8.dp, shape = CircleShape)
    ) {
        Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
            drawCircle(color = circleColor)
        })
        Row {
            DrawClockText(count = time[0], unit = "MIN", textColor = textColor)
            Text(
                text = " : ",
                style = TextStyle(
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 45.sp,
                    lineHeight = 24.sp,
                    letterSpacing = 0.5.sp
                ),
                color = textColor
            )
            DrawClockText(count = time[1], unit = " SEC", textColor = textColor)
            Text(
                text = " : ",
                style = TextStyle(
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 45.sp,
                    lineHeight = 24.sp,
                    letterSpacing = 0.5.sp
                ),
                color = textColor
            )
            DrawClockText(count = time[2], unit = " MIL", textColor = textColor)
        }
    }
}

@Composable
fun DrawClockText(count: String, unit: String, textColor: Color) {
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
            color = textColor
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
            color = textColor
        )
    }
}

fun formatMilliseconds(milliseconds: Long): List<String> {
    val minutes = (milliseconds / 60000) % 60
    val seconds = (milliseconds / 1000) % 60
    val millis = (milliseconds % 1000) / 10

    return listOf(
        String.format("%02d", minutes),
        String.format("%02d", seconds),
        String.format("%02d", millis)
    )
}


