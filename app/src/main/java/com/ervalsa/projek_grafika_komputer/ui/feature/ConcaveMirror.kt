package com.ervalsa.projek_grafika_komputer.ui.feature

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun ConcaveMirror(

) {
    var objectSizeSliderValue by remember { mutableStateOf(0f) }
    var objectDistanceSliderValue by remember { mutableStateOf(0f) }
    var mirrorFocalPointSliderValue by remember { mutableStateOf(0f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Canvas(
            modifier = Modifier
                .size(500.dp, 500.dp)
                .padding(16.dp)
        ) {
            val canvasWidth = size.width
            val canvasHeight = size.height

            // draw horizontal Line
            drawLine(
                color = Color.Black,
                start = Offset(0f, canvasHeight / 2),
                end = Offset(canvasWidth, canvasHeight /2),
                strokeWidth = 2f
            )

            // draw vertical Line
            drawLine(
                color = Color.Black,
                start = Offset(canvasWidth / 2, 0f),
                end = Offset(canvasWidth / 2, canvasHeight)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Ukuran Benda"
            )
            Spacer(Modifier.size(10.dp))
        }
        Slider(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            value = objectSizeSliderValue,
            onValueChange = { objectSizeSliderValue = it }
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Jarak Benda"
            )
            Spacer(Modifier.size(10.dp))
        }
        Slider(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            value = objectDistanceSliderValue,
            onValueChange = { objectDistanceSliderValue = it }
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Titik Fokus Cermin"
            )
            Spacer(Modifier.size(10.dp))
        }
        Slider(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            value = mirrorFocalPointSliderValue,
            onValueChange = { mirrorFocalPointSliderValue = it }
        )
    }
}