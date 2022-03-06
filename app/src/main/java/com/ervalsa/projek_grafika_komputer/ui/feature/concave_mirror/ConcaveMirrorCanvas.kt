package com.ervalsa.projek_grafika_komputer.ui.feature.concave_mirror

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb

@Composable
fun ConcaveMirrorCanvas(
    modifier: Modifier,
    objectSize: Float,
    objectDistance: Float,
    shadowDistance: Float,
    shadowSize: Float,
    focalPoint: Float
) {
    Canvas(modifier = modifier) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        // Object
        drawLine(
            color = Color.Blue,
            start = Offset(canvasWidth / 2 - objectDistance, canvasHeight / 2),
            end = Offset(canvasWidth / 2 - objectDistance, canvasHeight / 2 - objectSize),
            strokeWidth = Stroke.DefaultMiter
        )

        // Reflect
        drawLine(
            color = Color.Yellow,
            start = Offset(canvasWidth / 2 - shadowDistance, canvasHeight / 2),
            end = Offset(canvasWidth / 2 - shadowDistance, canvasHeight / 2 + shadowSize),
            strokeWidth = Stroke.DefaultMiter
        )

        // Light Come
        drawLine(
            color = Color.Red,
            start = Offset(canvasWidth / 2, canvasHeight / 2 - objectSize),
            end = Offset(canvasWidth / 2 - shadowDistance, canvasHeight / 2 + shadowSize),
            strokeWidth = Stroke.DefaultMiter
        )

        drawLine(
            color = Color.Red,
            start = Offset(canvasWidth / 2, canvasHeight / 2 + shadowSize),
            end = Offset(canvasWidth / 2 - objectDistance, canvasHeight / 2 - objectSize),
            strokeWidth = Stroke.DefaultMiter
        )

        // Light Past
        drawLine(
            color = Color.Magenta,
            start = Offset(canvasWidth / 2, canvasHeight / 2 + shadowSize),
            end = Offset(canvasWidth / 2 - shadowDistance, canvasHeight / 2 + shadowSize),
            strokeWidth = Stroke.DefaultMiter
        )

        drawLine(
            color = Color.Magenta,
            start = Offset(canvasWidth / 2, canvasHeight - objectSize),
            end = Offset(canvasWidth / 2 - shadowDistance, canvasHeight / 2 + shadowSize),
            strokeWidth = Stroke.DefaultMiter
        )

        // Text F and R
        val textPaint = Paint()
        textPaint.textAlign = Paint.Align.CENTER
        textPaint.textSize = 45f
        textPaint.color = Color(0xFF000000).toArgb()

        drawIntoCanvas {
            it.nativeCanvas.drawText(
                "r",
                canvasWidth / 2 - focalPoint * 2,
                canvasHeight / 2,
                textPaint
            )

            it.nativeCanvas.drawText(
                "f",
                canvasWidth / 2 - focalPoint,
                canvasHeight / 2,
                textPaint
            )
        }

        // Horizontal Line
        drawLine(
            color = Color.Gray,
            start = Offset(0f, canvasHeight / 2),
            end = Offset(canvasWidth, canvasHeight / 2),
            strokeWidth = Stroke.DefaultMiter
        )

        // Vertical Line
        drawLine(
            color = Color.Gray,
            start = Offset(canvasWidth / 2, 0f),
            end = Offset(canvasWidth / 2, canvasHeight),
            strokeWidth = Stroke.DefaultMiter
        )
    }
}