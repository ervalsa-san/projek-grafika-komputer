package com.ervalsa.projek_grafika_komputer.ui.feature.concave_mirror

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ConcaveMirrorViewModel : ViewModel() {
    var objectSizeSliderValue by mutableStateOf(0f)
    var objectDistanceSliderValue by mutableStateOf(0f)
    var mirrorFocalPointSliderValue by mutableStateOf(0f)

    fun onObjectSizeSliderValueChanged(value: Float) {
        objectSizeSliderValue = value
    }

    fun onObjectDistanceSliderValueChanged(value: Float) {
        objectDistanceSliderValue = value
    }

    fun mirrorFocalPointSliderValueChange(value: Float) {
        mirrorFocalPointSliderValue = value
    }
}