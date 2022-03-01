package com.ervalsa.projek_grafika_komputer.ui.feature.concave_mirror

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp

@Composable
fun ConcaveMirrorScreen(
    objectSize: Float,
    objectDistance: Float,
    focus: Float,
    concaveMirrorViewModel: ConcaveMirrorViewModel
) {
    val objectSizeSliderValue = concaveMirrorViewModel.objectSizeSliderValue
    val onObjectSizeSliderValueChange = concaveMirrorViewModel::onObjectSizeSliderValueChanged
    val objectDistanceSliderValue = concaveMirrorViewModel.objectDistanceSliderValue
    val onObjectDistanceSliderValueChange = concaveMirrorViewModel::onObjectDistanceSliderValueChanged
    val mirrorFocalPointSliderValue = concaveMirrorViewModel.mirrorFocalPointSliderValue
    val onMirrorFocalPointSliderValueChange = concaveMirrorViewModel::mirrorFocalPointSliderValueChange

    var shadowDistanceTextValue by remember { mutableStateOf(0f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Canvas(
            modifier = Modifier
                .size(width = 500.dp, height = 500.dp)
                .padding(16.dp)
        ) {
            val canvasWidth = size.width
            val canvasHeight = size.height

            val shadowDistance by derivedStateOf {
                objectDistance * focus / (objectDistance - focus)
            }

            val shadowSize by derivedStateOf {
                shadowDistance * objectSize / objectDistance
            }

            val objectX by derivedStateOf { (canvasHeight / 2) - objectSize}
            val objectY by derivedStateOf { (canvasWidth / 2) - objectDistance}

            val shadowX by derivedStateOf { (canvasWidth / 2) - shadowDistance }
            val shadowY by derivedStateOf { (canvasHeight / 2) + shadowSize}

            println("objectX : $objectX")
            println("objectY : $objectY")
            println("shadowSize : $shadowSize")
            println("shadowDistance : $shadowDistance")
            println("shadowX : $shadowX")
            println("shadowY : $shadowY")
            println("objectSize : $objectSize")
            println("objectDistance : $objectDistance")
            println("Focus : $focus")

            val textPaint = Paint().apply {
                textAlign = Paint.Align.CENTER
                textSize  = 25f
                color = Color(0xFF000000).toArgb()
            }

            // Light P
            drawLine(
                color = Color.Magenta,
                start = Offset((canvasWidth / 2), shadowY),
                end = Offset(shadowX, shadowY)
            )

            drawLine(
                color = Color.Magenta,
                start = Offset((canvasWidth / 2), objectY),
                end = Offset(shadowX, shadowY)
            )

            // Light c
            drawLine(
                color = Color.Red,
                start = Offset((canvasWidth / 2), objectY),
                end = Offset(objectX, objectY)
            )

            drawLine(
                color = Color.Red,
                start = Offset((canvasWidth / 2), shadowY),
                end = Offset(objectX, objectY)
            )

            // Reflct
            drawLine(
                color = Color.Yellow,
                start = Offset(shadowX, (canvasHeight / 2)),
                end = Offset(shadowX, shadowY)
            )

            // Obj
            drawLine(
                color = Color.Blue,
                start = Offset(objectX, (canvasHeight / 2)),
                end = Offset(objectX, objectY)
            )

            // draw horizontal Line
            drawLine(
                color = Color.Black,
                start = Offset(0f, canvasHeight / 2),
                end = Offset(canvasWidth, canvasHeight /2)
            )

            // draw vertical Line
            drawLine(
                color = Color.Green,
                start = Offset(
                    canvasWidth / 2,
                    0f),
                end = Offset(
                    canvasWidth / 2,
                    canvasHeight)
            )

            // reflect text
            drawContext.canvas.nativeCanvas.apply {
                drawText(
                    "r",
                    canvasWidth / 2 - focus * 2,
                    canvasHeight / 2,
                    textPaint
                )
            }

            // focus f
            drawContext.canvas.nativeCanvas.apply {
                drawText(
                    "f",
                    canvasWidth / 2 - focus,
                    canvasHeight / 2,
                    textPaint
                )
            }
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
            onValueChange = onObjectSizeSliderValueChange
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
            onValueChange = onObjectDistanceSliderValueChange
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
            onValueChange = onMirrorFocalPointSliderValueChange
        )
    }
}