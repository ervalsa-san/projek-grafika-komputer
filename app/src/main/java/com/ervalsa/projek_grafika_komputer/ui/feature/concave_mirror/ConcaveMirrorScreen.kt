package com.ervalsa.projek_grafika_komputer.ui.feature.concave_mirror

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import kotlin.math.abs

@ExperimentalMaterialApi
@Composable
fun ConcaveMirrorScreen(
    /*concaveMirrorViewModel: ConcaveMirrorViewModel*/
) {
    // Text State
    var objectSizeTextState by rememberSaveable{ (mutableStateOf(148f.toString())) }
    var objectDistanceTextState by rememberSaveable { (mutableStateOf(303f.toString())) }
    var mirrorFocalPointTextState by rememberSaveable { (mutableStateOf(154f.toString())) }

    var objectSizeFloat by remember { mutableStateOf(0f) }
    objectSizeTextState.toFloatOrNull()?.let {
        objectSizeFloat = it
    }

    var objectDistanceFloat by remember { mutableStateOf(0f) }
    objectDistanceTextState.toFloatOrNull()?.let {
        objectDistanceFloat = it
    }

    var mirrorFocalPointFloat by remember { mutableStateOf(0f) }
    mirrorFocalPointTextState.toFloatOrNull()?.let {
        mirrorFocalPointFloat = it
    }

    var size by remember { mutableStateOf(IntSize.Zero) }

    fun Float.toRange() = -(abs(this))..(abs(this))

    val rangeX = (size.width / 2f).toRange()
    val rangeY = (size.height / 2f).toRange()
    val rangeFocalpoint = 0f..(size.width / 2f)

    val state = remember { ConcaveMirrorState() }

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Canvas
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Box {
                ConcaveMirrorCanvas(
                    modifier = Modifier
                        .fillMaxSize()
                        .onSizeChanged {
                            size = it
                        },
                    objectDistance = objectDistanceFloat,
                    objectSize = objectSizeFloat,
                    focalPoint = mirrorFocalPointFloat,
                    concaveMirrorState =state
                )
            }
        }

        // Shadow Status
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            TextField(
                modifier = Modifier.weight(1f),
                value = state.shadowDistance.toString(),
                onValueChange = { },
                label = { Text(text = "Jarak Bayangan") },
                readOnly = true
            )
            Spacer(modifier = Modifier.width(16.dp))
            TextField(
                modifier = Modifier.weight(1f),
                value = state.shadowSize.toString(),
                onValueChange = {  },
                label = { Text(text = "Ukuran Bayangan") },
                readOnly = true
            )
        }

        // Main Control / Object Control
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 8.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start
        ) {
            // Object Size
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
            ) {
                Text(text = "Ukuran Benda")
                Row() {
                    Slider(
                        modifier = Modifier.weight(2f),
                        value = objectSizeFloat,
                        valueRange = rangeY,
                        onValueChange = { objectSizeTextState = it.toString() }
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    TextField(
                        modifier = Modifier.weight(1f),
                        value = objectSizeTextState,
                        onValueChange = { objectSizeTextState = it }
                    )
                }
            }

            // Object Distance
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
            ) {
                Text(text = "Jarak Benda")
                Row() {
                    Slider(
                        modifier = Modifier.weight(2f),
                        valueRange = rangeX,
                        value = objectDistanceFloat,
                        onValueChange = { objectDistanceTextState = it.toString() }
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    TextField(
                        modifier = Modifier.weight(1f),
                        value = objectDistanceTextState,
                        onValueChange = { objectDistanceTextState = it }
                    )
                }
            }

            // Mirror Focal Point
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
            ) {
                Text(text = "Titk Fokus Cermin")
                Row() {
                    Slider(
                        modifier = Modifier.weight(2f),
                        value = mirrorFocalPointFloat,
                        valueRange = rangeFocalpoint,
                        onValueChange = { mirrorFocalPointTextState = it.toString() }
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    TextField(
                        modifier = Modifier.weight(1f),
                        value = mirrorFocalPointTextState,
                        onValueChange = { mirrorFocalPointTextState = it }
                    )
                }
            }
        }
    }
}

