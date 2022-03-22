package com.ervalsa.projek_grafika_komputer.ui.feature.concave_mirror

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.isSpecified
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import java.lang.ArithmeticException

@Composable
fun ConcaveMirrorCanvas(
    modifier: Modifier,
    objectSize: Float,
    objectDistance: Float,
    focalPoint: Float,
    concaveMirrorState: ConcaveMirrorState
) {
    Canvas(modifier = modifier) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        // Rumus Ajaib
        var shadowDistance = 0f
        try {
            shadowDistance = objectDistance * focalPoint / (objectDistance - focalPoint)
        } catch (e: ArithmeticException) {
            print(e.stackTrace)
        }
        concaveMirrorState.shadowDistance = shadowDistance

        var shadowSize = 0f
        try {
            shadowSize = shadowDistance * objectSize / objectDistance
        } catch (e: ArithmeticException) {
            print(e.stackTrace)
        }
        concaveMirrorState.shadowSize = shadowSize

        // Pencil Object
        drawSpecifiedLine(
            color = Color.Cyan,
            start = Offset(canvasWidth / 2 - objectDistance, canvasHeight / 2),
            end = Offset(canvasWidth / 2 - objectDistance, canvasHeight / 2 - objectSize)
        )

        //
        drawSpecifiedLine(
            color = Color.Blue,
            start = Offset(canvasWidth / 2 - objectDistance - objectSize / 4, canvasHeight / 2 - objectSize / 4),
            end = Offset(canvasWidth / 2 - objectDistance - objectSize / 4, canvasHeight / 2 + objectSize / 24 - objectSize)
        )

        drawSpecifiedLine(
            color = Color.Blue,
            start = Offset(canvasWidth / 2 - objectDistance + objectSize / 4, canvasHeight / 2 - objectSize / 4),
            end = Offset(canvasWidth / 2 - objectDistance + objectSize / 4, canvasHeight / 2 + objectSize / 24 - objectSize)
        )

        //
        drawSpecifiedLine(
            color = Color.Blue,
            start = Offset(canvasWidth / 2 - objectDistance - objectSize / 12, canvasHeight / 2 - objectSize / 3),
            end = Offset(canvasWidth / 2 - objectDistance - objectSize / 12, canvasHeight / 2 - objectSize)
        )

        drawSpecifiedLine(
            color = Color.Blue,
            start = Offset(canvasWidth / 2 - objectDistance + objectSize / 12, canvasHeight / 2 - objectSize / 3),
            end = Offset(canvasWidth / 2 - objectDistance + objectSize / 12, canvasHeight / 2 - objectSize)
        )

        //
        drawSpecifiedLine(
            color = Color.Blue,
            start = Offset(canvasWidth / 2 - objectDistance, canvasHeight / 2),
            end = Offset(canvasWidth / 2 - objectDistance - objectSize / 4, canvasHeight / 2 - objectSize / 4)
        )

        drawSpecifiedLine(
            color = Color.Blue,
            start = Offset(canvasWidth / 2 - objectDistance, canvasHeight / 2),
            end = Offset(canvasWidth / 2 - objectDistance + objectSize / 4, canvasHeight / 2 - objectSize / 4)
        )

        //
        drawSpecifiedLine(
            color = Color.Blue,
            start = Offset(canvasWidth / 2 - objectDistance - objectSize / 12, canvasHeight / 2 - objectSize / 3),
            end = Offset(canvasWidth / 2 - objectDistance - objectSize / 4, canvasHeight / 2 - objectSize / 4)
        )

        drawSpecifiedLine(
            color = Color.Blue,
            start = Offset(canvasWidth / 2 - objectDistance + objectSize / 12, canvasHeight / 2 - objectSize / 3),
            end = Offset(canvasWidth / 2 - objectDistance + objectSize / 4, canvasHeight / 2 - objectSize / 4)
        )

        //
        drawSpecifiedLine(
            color = Color.Blue,
            start = Offset(canvasWidth / 2 - objectDistance - objectSize / 12, canvasHeight / 2 - objectSize),
            end = Offset(canvasWidth / 2 - objectDistance - objectSize / 4, canvasHeight / 2 + objectSize / 24 - objectSize)
        )

        drawSpecifiedLine(
            color = Color.Blue,
            start = Offset(canvasWidth / 2 - objectDistance + objectSize / 12, canvasHeight / 2 - objectSize),
            end = Offset(canvasWidth / 2 - objectDistance + objectSize / 4, canvasHeight / 2 + objectSize / 24 - objectSize)
        )

        //
        drawSpecifiedLine(
            color = Color.Blue,
            start = Offset(canvasWidth / 2 - objectDistance - objectSize / 12, canvasHeight / 2 - objectSize / 3),
            end = Offset(canvasWidth / 2 - objectDistance + objectSize / 12, canvasHeight / 2 - objectSize / 3)
        )

        drawSpecifiedLine(
            color = Color.Blue,
            start = Offset(canvasWidth / 2 - objectDistance - objectSize / 12, canvasHeight / 2 - objectSize),
            end = Offset(canvasWidth / 2 - objectDistance + objectSize / 12, canvasHeight / 2 - objectSize)
        )

        // Pencil Reflect
        drawSpecifiedLine(
            color = Color.Yellow,
            start = Offset(canvasWidth / 2 - shadowDistance, canvasHeight / 2),
            end = Offset(canvasWidth / 2 - shadowDistance, canvasHeight / 2 + shadowSize)
        )

        //
        drawSpecifiedLine(
            color = Color.DarkGray,
            start = Offset(canvasWidth / 2 - shadowDistance - shadowSize / 4, canvasHeight / 2 + shadowSize / 4),
            end = Offset(canvasWidth / 2 - shadowDistance - shadowSize / 4, canvasHeight / 2 - shadowSize / 24 + shadowSize)
        )

        drawSpecifiedLine(
            color = Color.DarkGray,
            start = Offset(canvasWidth / 2 - shadowDistance + shadowSize / 4, canvasHeight / 2 + shadowSize / 4),
            end = Offset(canvasWidth / 2 - shadowDistance + shadowSize / 4, canvasHeight / 2 - shadowSize / 24 + shadowSize)
        )

        //
        drawSpecifiedLine(
            color = Color.DarkGray,
            start = Offset(canvasWidth / 2 - shadowDistance - shadowSize / 12, canvasHeight / 2 + shadowSize / 3),
            end = Offset(canvasWidth / 2 - shadowDistance - shadowSize / 12, canvasHeight / 2 + shadowSize)
        )

        drawSpecifiedLine(
            color = Color.DarkGray,
            start = Offset(canvasWidth / 2 - shadowDistance + shadowSize / 12, canvasHeight / 2 + shadowSize / 3),
            end = Offset(canvasWidth / 2 - shadowDistance + shadowSize / 12, canvasHeight / 2 + shadowSize)
        )

        //
        drawSpecifiedLine(
            color = Color.DarkGray,
            start = Offset(canvasWidth / 2 - shadowDistance, canvasHeight / 2),
            end = Offset(canvasWidth / 2 - shadowDistance - shadowSize / 4, canvasHeight / 2 + shadowSize / 4)
        )

        drawSpecifiedLine(
            color = Color.DarkGray,
            start = Offset(canvasWidth / 2 - shadowDistance, canvasHeight / 2),
            end = Offset(canvasWidth / 2 - shadowDistance + shadowSize / 4, canvasHeight / 2 + shadowSize / 4)
        )

        //
        drawSpecifiedLine(
            color = Color.DarkGray,
            start = Offset(canvasWidth / 2 - shadowDistance - shadowSize / 12, canvasHeight / 2 + shadowSize / 3),
            end = Offset(canvasWidth / 2 - shadowDistance - shadowSize / 4, canvasHeight / 2 + shadowSize / 4)
        )

        drawSpecifiedLine(
            color = Color.DarkGray,
            start = Offset(canvasWidth / 2 - shadowDistance + shadowSize / 12, canvasHeight / 2 + shadowSize / 3),
            end = Offset(canvasWidth / 2 - shadowDistance + shadowSize / 4, canvasHeight / 2 + shadowSize / 4)
        )

        //
        drawSpecifiedLine(
            color = Color.DarkGray,
            start = Offset(canvasWidth / 2 - shadowDistance - shadowSize / 12, canvasHeight / 2 + shadowSize),
            end = Offset(canvasWidth / 2 - shadowDistance - shadowSize / 4, canvasHeight / 2 - shadowSize / 24 + shadowSize)
        )

        drawSpecifiedLine(
            color = Color.DarkGray,
            start = Offset(canvasWidth / 2 - shadowDistance + shadowSize / 12, canvasHeight / 2 + shadowSize),
            end = Offset(canvasWidth / 2 - shadowDistance + shadowSize / 4, canvasHeight / 2 - shadowSize / 24 + shadowSize)
        )

        //
        drawSpecifiedLine(
            color = Color.DarkGray,
            start = Offset(canvasWidth / 2 - shadowDistance - shadowSize / 12, canvasHeight / 2 + shadowSize / 3),
            end = Offset(canvasWidth / 2 - shadowDistance + shadowSize / 12, canvasHeight / 2 + shadowSize / 3)
        )

        drawSpecifiedLine(
            color = Color.DarkGray,
            start = Offset(canvasWidth / 2 - shadowDistance - shadowSize / 12, canvasHeight / 2 + shadowSize),
            end = Offset(canvasWidth / 2 - shadowDistance + shadowSize / 12, canvasHeight / 2 + shadowSize)
        )

        // Light Come
        drawSpecifiedLine(
            color = Color.Red,
            start = Offset(canvasWidth / 2, canvasHeight / 2 - objectSize),
            end = Offset(canvasWidth / 2 - objectDistance, canvasHeight / 2 - objectSize)
        )

        drawSpecifiedLine(
            color = Color.Red,
            start = Offset(canvasWidth / 2, canvasHeight / 2 + shadowSize),
            end = Offset(canvasWidth / 2 - objectDistance, canvasHeight / 2 - objectSize)
        )

        // Light Past
        drawSpecifiedLine(
            color = Color.Magenta,
            start = Offset(canvasWidth / 2, canvasHeight / 2 + shadowSize),
            end = Offset(canvasWidth / 2 - shadowDistance, canvasHeight / 2 + shadowSize)
        )

        drawSpecifiedLine(
            color = Color.Magenta,
            start = Offset(canvasWidth / 2, canvasHeight / 2 - objectSize),
            end = Offset(canvasWidth / 2 - shadowDistance, canvasHeight / 2 + shadowSize)
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
        drawSpecifiedLine(
            color = Color.Gray,
            start = Offset(0f, canvasHeight / 2),
            end = Offset(canvasWidth, canvasHeight / 2),
        )

        // Vertical Line
        drawSpecifiedLine(
            color = Color.Gray,
            start = Offset(canvasWidth / 2, 0f),
            end = Offset(canvasWidth / 2, canvasHeight),
        )
    }
}

fun DrawScope.drawSpecifiedLine(color: Color, start: Offset, end: Offset) {
    if (start.isSpecified && end.isSpecified) {
        drawLine(color = color, start = start, end = end, strokeWidth = Stroke.DefaultMiter)
    }
}

