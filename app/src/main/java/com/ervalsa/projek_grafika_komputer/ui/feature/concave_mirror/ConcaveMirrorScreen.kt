package com.ervalsa.projek_grafika_komputer.ui.feature.concave_mirror

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Slider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ConcaveMirrorScreen() {

    /*val objectSizeSliderValue = concaveMirrorViewModel.objectSizeSliderValue
    val onObjectSizeSliderValueChange = concaveMirrorViewModel::onObjectSizeSliderValueChanged
    val objectDistanceSliderValue = concaveMirrorViewModel.objectDistanceSliderValue
    val onObjectDistanceSliderValueChange = concaveMirrorViewModel::onObjectDistanceSliderValueChanged
    val mirrorFocalPointSliderValue = concaveMirrorViewModel.mirrorFocalPointSliderValue
    val onMirrorFocalPointSliderValueChange = concaveMirrorViewModel::mirrorFocalPointSliderValueChange*/

    // Text State
    var objectSizeTextState by remember { (mutableStateOf(0f.toString())) }
    var objectDistanceTextState by remember { (mutableStateOf(0f.toString())) }
    var mirrorFocalPointTextState by remember { (mutableStateOf(0f.toString())) }
    var shadowSizeTextState by remember { (mutableStateOf(0f.toString())) }
    var shadowDistanceTextState by remember { (mutableStateOf(0f.toString())) }

    // Slider State
    var objectSizeSliderValue by remember { (mutableStateOf(0f)) }
    var objectDistanceSliderValue by remember { (mutableStateOf(0f)) }
    var mirrorFocalPointSliderValue by remember { (mutableStateOf(0f)) }

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Canvas
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            ConcaveMirrorCanvas(
                modifier = Modifier.fillMaxSize(),
                objectDistance = 303f,
                objectSize = 148f,
                focalPoint = 154f,
                shadowDistance = 313f,
                shadowSize = 152f
            )
        }

        // Shadow Status
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            TextField(
                modifier = Modifier.weight(1f),
                value = shadowDistanceTextState,
                onValueChange = { shadowDistanceTextState = it },
                label = { Text(text = "Jarak Bayangan") },
                readOnly = true
            )
            Spacer(modifier = Modifier.width(16.dp))
            TextField(
                modifier = Modifier.weight(1f),
                value = shadowSizeTextState,
                onValueChange = { shadowSizeTextState = it },
                label = { Text(text = "Ukuran Bayangan") },
                readOnly = true
            )
        }

        // Main Control / Object Control
        Column(
            modifier = Modifier
                .fillMaxSize(),
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
                        value = objectSizeSliderValue,
                        onValueChange = { objectSizeSliderValue = it }
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
                        value = objectDistanceSliderValue,
                        onValueChange = { objectDistanceSliderValue = it }
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
                        value = mirrorFocalPointSliderValue,
                        onValueChange = { mirrorFocalPointSliderValue = it }
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

@Preview(showBackground = true, widthDp = 300)
@Composable
fun mainControl() {
    RoundedCornerBox(
        shape = RoundedCornerShape(10.dp)
    )
}

@Composable
fun RoundedCornerBox(shape: Shape) {
    Column() {
        Box(modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .height(100.dp)
            .fillMaxWidth()
            .clip(shape)
            .background(Color.Red)
        ) {
        }
    }
}

