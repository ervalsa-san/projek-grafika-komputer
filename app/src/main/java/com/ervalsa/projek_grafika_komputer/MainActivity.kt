package com.ervalsa.projek_grafika_komputer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.rememberNavController
import com.ervalsa.projek_grafika_komputer.navigation.SetupNavGraph
import com.ervalsa.projek_grafika_komputer.ui.feature.concave_mirror.ConcaveMirrorScreen
import com.ervalsa.projek_grafika_komputer.ui.theme.ProjekgrafikakomputerTheme

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjekgrafikakomputerTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}