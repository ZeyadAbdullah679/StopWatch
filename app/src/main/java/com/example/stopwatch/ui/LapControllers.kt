package com.example.stopwatch.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.stopwatch.R


@Composable
fun LapControllers(
    isRunning: Boolean,
    onStopClick: () -> Unit,
    onPlayClick: () -> Unit,
    onLapClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        LapButton("Reset", R.drawable.ic_round_stop, onStopClick)
        if (isRunning)
            LapButton("Play", R.drawable.ic_round_pause, onPlayClick)
        else
            LapButton("Pause", R.drawable.ic_round_play_arrow, onPlayClick)
        LapButton("Lap", R.drawable.ic_round_lap, onLapClick)
    }
}

@Composable
fun LapButton(
    type: String,
    @DrawableRes icon: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .size(64.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primaryContainer)
    ) {
        Icon(
            painter = painterResource(
                id = icon
            ),
            contentDescription = type,
            tint = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}



