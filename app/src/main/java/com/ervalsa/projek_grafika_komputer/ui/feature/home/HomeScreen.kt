package com.ervalsa.projek_grafika_komputer.ui.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ervalsa.projek_grafika_komputer.R
import com.ervalsa.projek_grafika_komputer.navigation.Screen

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .padding(8.dp)
                    .size(width = 200.dp, height = 300.dp)
                    .clickable { navController.navigate(Screen.Concave.route) },
                painter = painterResource(
                    id = R.drawable.image_tombol_cermin_cekung
                ),
                contentDescription = "Image Concave"
            )
            Spacer(modifier = Modifier.height(5.dp))
            Image(
                modifier = Modifier
                    .padding(8.dp)
                    .size(width = 200.dp, height = 100.dp)
                    .clickable { navController.navigate(Screen.Concave.route) },
                painter = painterResource(
                    id = R.drawable.image_tentang_tugas
                ),
                contentDescription = "Image Concave"
            )
        }
    }
}