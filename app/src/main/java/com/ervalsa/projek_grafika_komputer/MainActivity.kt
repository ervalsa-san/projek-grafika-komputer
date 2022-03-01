package com.ervalsa.projek_grafika_komputer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.ervalsa.projek_grafika_komputer.ui.feature.concave_mirror.ConcaveMirrorScreen
import com.ervalsa.projek_grafika_komputer.ui.feature.concave_mirror.ConcaveMirrorViewModel
import com.ervalsa.projek_grafika_komputer.ui.theme.ProjekgrafikakomputerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjekgrafikakomputerTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ConcaveMirrorScreen(
                        objectDistance = 303f,
                        objectSize = 148f,
                        focus = 154f,
                        concaveMirrorViewModel = ConcaveMirrorViewModel()
                    )
                }
            }
        }
    }
}