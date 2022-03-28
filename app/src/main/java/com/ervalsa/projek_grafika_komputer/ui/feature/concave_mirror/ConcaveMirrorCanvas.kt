package com.ervalsa.projek_grafika_komputer.ui.feature.concave_mirror

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.isSpecified
import androidx.compose.ui.geometry.isUnspecified
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import java.lang.ArithmeticException
import kotlin.math.abs
import kotlin.math.max

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

        // Rumus Formula
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

        // Point X and Y
        val pointX = canvasWidth / 2
        val pointY = canvasHeight / 2

        // Object
        val objectX = pointX - objectDistance
        val objectY = pointY - objectSize

        // Shadow
        val shadowX = pointX - shadowDistance
        val shadowY = pointY + shadowSize

        // Pencil Object
        drawSpecifiedLine(
            color = Color.Cyan,
            start = Offset(x = objectX, y = pointY),
            end = Offset(x = objectX, y = objectY)
        )

        drawSpecifiedLine(
            color = Color.Blue,
            start = Offset(pointX - objectDistance - objectSize / 4, pointY - objectSize / 4),
            end = Offset(pointX - objectDistance - objectSize / 4, pointY + objectSize / 24 - objectSize)
        )

        drawSpecifiedLine(
            color = Color.Blue,
            start = Offset(pointX - objectDistance + objectSize / 4, pointY - objectSize / 4),
            end = Offset(pointX - objectDistance + objectSize / 4, pointY + objectSize / 24 - objectSize)
        )

        drawSpecifiedLine(
            color = Color.Blue,
            start = Offset(pointX - objectDistance - objectSize / 12, pointY - objectSize / 3),
            end = Offset(pointX - objectDistance - objectSize / 12, pointY - objectSize)
        )

        drawSpecifiedLine(
            color = Color.Blue,
            start = Offset(pointX - objectDistance + objectSize / 12, pointY - objectSize / 3),
            end = Offset(pointX - objectDistance + objectSize / 12, pointY - objectSize)
        )

        drawSpecifiedLine(
            color = Color.Blue,
            start = Offset(pointX - objectDistance, pointY),
            end = Offset(pointX - objectDistance - objectSize / 4, pointY - objectSize / 4)
        )

        drawSpecifiedLine(
            color = Color.Blue,
            start = Offset(pointX - objectDistance, pointY),
            end = Offset(pointX - objectDistance + objectSize / 4, pointY - objectSize / 4)
        )

        drawSpecifiedLine(
            color = Color.Blue,
            start = Offset(pointX - objectDistance - objectSize / 12, pointY - objectSize / 3),
            end = Offset(pointX - objectDistance - objectSize / 4, pointY - objectSize / 4)
        )

        drawSpecifiedLine(
            color = Color.Blue,
            start = Offset(pointX - objectDistance + objectSize / 12, pointY - objectSize / 3),
            end = Offset(pointX - objectDistance + objectSize / 4, pointY - objectSize / 4)
        )

        drawSpecifiedLine(
            color = Color.Blue,
            start = Offset(pointX - objectDistance - objectSize / 12, pointY - objectSize),
            end = Offset(pointX - objectDistance - objectSize / 4, pointY + objectSize / 24 - objectSize)
        )

        drawSpecifiedLine(
            color = Color.Blue,
            start = Offset(pointX - objectDistance + objectSize / 12, pointY - objectSize),
            end = Offset(pointX - objectDistance + objectSize / 4, pointY + objectSize / 24 - objectSize)
        )

        drawSpecifiedLine(
            color = Color.Blue,
            start = Offset(pointX - objectDistance - objectSize / 12, pointY - objectSize / 3),
            end = Offset(pointX - objectDistance + objectSize / 12, pointY - objectSize / 3)
        )

        drawSpecifiedLine(
            color = Color.Blue,
            start = Offset(pointX - objectDistance - objectSize / 12, pointY - objectSize),
            end = Offset(pointX - objectDistance + objectSize / 12, pointY - objectSize)
        )

        // Pencil Reflect
        drawSpecifiedLine(
            color = Color.Yellow,
            start = Offset(x = shadowX, y = pointY),
            end = Offset(x = shadowX, y = shadowY)
        )

        drawSpecifiedLine(
            color = Color.DarkGray,
            start = Offset(pointX - shadowDistance - shadowSize / 4, pointY + shadowSize / 4),
            end = Offset(pointX - shadowDistance - shadowSize / 4, pointY - shadowSize / 24 + shadowSize)
        )

        drawSpecifiedLine(
            color = Color.DarkGray,
            start = Offset(pointX - shadowDistance + shadowSize / 4, pointY + shadowSize / 4),
            end = Offset(pointX - shadowDistance + shadowSize / 4, pointY - shadowSize / 24 + shadowSize)
        )

        drawSpecifiedLine(
            color = Color.DarkGray,
            start = Offset(pointX - shadowDistance - shadowSize / 12, pointY + shadowSize / 3),
            end = Offset(pointX - shadowDistance - shadowSize / 12, pointY + shadowSize)
        )

        drawSpecifiedLine(
            color = Color.DarkGray,
            start = Offset(pointX - shadowDistance + shadowSize / 12, pointY + shadowSize / 3),
            end = Offset(pointX - shadowDistance + shadowSize / 12, pointY + shadowSize)
        )

        drawSpecifiedLine(
            color = Color.DarkGray,
            start = Offset(pointX - shadowDistance, pointY),
            end = Offset(pointX - shadowDistance - shadowSize / 4, pointY + shadowSize / 4)
        )

        drawSpecifiedLine(
            color = Color.DarkGray,
            start = Offset(pointX - shadowDistance, pointY),
            end = Offset(pointX - shadowDistance + shadowSize / 4, pointY + shadowSize / 4)
        )

        drawSpecifiedLine(
            color = Color.DarkGray,
            start = Offset(pointX - shadowDistance - shadowSize / 12, pointY + shadowSize / 3),
            end = Offset(pointX - shadowDistance - shadowSize / 4, pointY + shadowSize / 4)
        )

        drawSpecifiedLine(
            color = Color.DarkGray,
            start = Offset(pointX - shadowDistance + shadowSize / 12, pointY + shadowSize / 3),
            end = Offset(pointX - shadowDistance + shadowSize / 4, pointY + shadowSize / 4)
        )

        drawSpecifiedLine(
            color = Color.DarkGray,
            start = Offset(pointX - shadowDistance - shadowSize / 12, pointY + shadowSize),
            end = Offset(pointX - shadowDistance - shadowSize / 4, pointY - shadowSize / 24 + shadowSize)
        )

        drawSpecifiedLine(
            color = Color.DarkGray,
            start = Offset(pointX - shadowDistance + shadowSize / 12, pointY + shadowSize),
            end = Offset(pointX - shadowDistance + shadowSize / 4, pointY - shadowSize / 24 + shadowSize)
        )

        drawSpecifiedLine(
            color = Color.DarkGray,
            start = Offset(pointX - shadowDistance - shadowSize / 12, pointY + shadowSize / 3),
            end = Offset(pointX - shadowDistance + shadowSize / 12, pointY + shadowSize / 3)
        )

        drawSpecifiedLine(
            color = Color.DarkGray,
            start = Offset(pointX - shadowDistance - shadowSize / 12, pointY + shadowSize),
            end = Offset(pointX - shadowDistance + shadowSize / 12, pointY + shadowSize)
        )

        // Light Come
        // Cahaya Lurus
        drawSpecifiedLine(
            color = Color.Red,
            start = Offset(pointX, pointY - objectSize),
            end = Offset(pointX - objectDistance, pointY - objectSize)
        )

        drawSpecifiedLine(
            color = Color.Red,
            start = Offset(pointX, pointY - objectSize),
            end = dda(pointX, pointY - objectSize, pointX - objectDistance, pointY - objectSize
            )
        )

        // Cahaya Miring
        drawSpecifiedLine(
            color = Color.Red,
            start = Offset(pointX, pointY + shadowSize),
            end = Offset(pointX - objectDistance, pointY - objectSize)
        )

        drawSpecifiedLine(
            color = Color.Red,
            start = Offset(pointX, pointY + shadowSize),
            end = dda(
                pointX, pointY + shadowSize,
                pointX - objectDistance, pointY - objectSize
            )
        )


        // Light Past
        // Cahaya Lurus
        drawSpecifiedLine(
            color = Color.Magenta,
            start = Offset(pointX, pointY + shadowSize),
            end = Offset(pointX - shadowDistance, pointY + shadowSize)
        )

        drawSpecifiedLine(
            color = Color.Magenta,
            start = Offset(pointX, pointY + shadowSize),
            end = dda(
                pointX, pointY + shadowSize,
                pointX - shadowDistance, pointY + shadowSize
            )
        )

        // Cahaya Miring
        drawSpecifiedLine(
            color = Color.Magenta,
            start = Offset(pointX, pointY - objectSize),
            end = Offset(pointX - shadowDistance, pointY + shadowSize)
        )

        drawSpecifiedLine(
            color = Color.Magenta,
            start = Offset(pointX, pointY - objectSize),
            end = dda(
                pointX, pointY - objectSize,
                pointX - shadowDistance, pointY + shadowSize
            )
        )

        // Text F and R
        val textPaint = Paint()
        textPaint.textAlign = Paint.Align.CENTER
        textPaint.textSize = 45f
        textPaint.color = Color(0xFF000000).toArgb()

        drawIntoCanvas {
            it.nativeCanvas.drawText(
                "r",
                pointX - focalPoint * 2,
                pointY,
                textPaint
            )

            it.nativeCanvas.drawText(
                "f",
                pointX - focalPoint,
                pointY,
                textPaint
            )
        }

        // Horizontal Line
        drawSpecifiedLine(
            color = Color.Gray,
            start = Offset(0f, pointY),
            end = Offset(canvasWidth, pointY),
        )

        // Vertical Line
        drawSpecifiedLine(
            color = Color.Gray,
            start = Offset(pointX, 0f),
            end = Offset(pointX, canvasHeight),
        )
    }
}

fun DrawScope.dda(x0: Float, y0: Float, x1: Float, y1: Float): Offset {
    // Calculate dx & dy
    val dx = x1 - x0
    val dy = y1 - y0

    // Calculate steps required for generating pixels
    val steps = max(abs(dx), abs(dy))

    // calculate increment in x & y for each steps
    val incX = dx / steps
    val incY = dy / steps

    if (Offset(incX, incY).isUnspecified) {
        return Offset(incX, incY)
    }

    var x = x0
    var y = y0

    var index = 0
    var offset = Offset(x, y)
    val rect = Rect(Offset.Zero, size)
    while (index < steps.toInt() || rect.contains(offset)) {
        x += incX
        y += incY

        offset = Offset(x, y)
        index += 1
    }
    return offset
}

fun DrawScope.drawSpecifiedLine(color: Color, start: Offset, end: Offset) {
    if (start.isSpecified && end.isSpecified) {
        drawLine(color = color, start = start, end = end, strokeWidth = Stroke.DefaultMiter)
    }
}