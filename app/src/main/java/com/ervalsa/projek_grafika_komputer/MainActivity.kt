package com.ervalsa.projek_grafika_komputer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.ervalsa.projek_grafika_komputer.ui.feature.concave_mirror.ConcaveMirrorCanvas
import com.ervalsa.projek_grafika_komputer.ui.feature.concave_mirror.ConcaveMirrorScreen
import com.ervalsa.projek_grafika_komputer.ui.feature.concave_mirror.ConcaveMirrorState
import com.ervalsa.projek_grafika_komputer.ui.feature.concave_mirror.ConcaveMirrorViewModel
import com.ervalsa.projek_grafika_komputer.ui.theme.ProjekgrafikakomputerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjekgrafikakomputerTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    /*ConcaveMirrorCanvas(
                        modifier = Modifier.fillMaxSize(),
                        objectDistance = 303f,
                        objectSize = 148f,
                        focalPoint = 154f,
                        shadowDistance = 313f,
                        shadowSize = 152f
                    )*/
                    ConcaveMirrorScreen(
                        concaveMirrorState = ConcaveMirrorState()
                    )
                }
            }
        }
    }
}