package com.example.stopwatch.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stopwatch.ui.theme.fontFamily

@Composable
fun LapDetails(modifier: Modifier = Modifier) {
    Row(
        modifier.padding(start = 16.dp, end = 16.dp),
    ) {
        LapItem("LAP", Modifier.weight(1f))
        LapItem("OVERALL", Modifier.weight(1f))
        LapItem("LAP TIME", Modifier.weight(1f))
    }
}

@Composable
fun LapItem(title: String, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier
    ) {
        item {
            Text(
                text = title,
                style = TextStyle(
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    lineHeight = 24.sp,
                    letterSpacing = 0.sp
                ),
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp), // Adjust padding as needed
                textAlign = TextAlign.Center
            )
        }
    }
}
