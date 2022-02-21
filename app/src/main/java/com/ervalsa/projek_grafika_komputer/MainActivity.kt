package com.ervalsa.projek_grafika_komputer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ervalsa.projek_grafika_komputer.ui.feature.ConcaveMirror
import com.ervalsa.projek_grafika_komputer.ui.theme.ProjekgrafikakomputerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjekgrafikakomputerTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ConcaveMirror()
                }
            }
        }
    }
}