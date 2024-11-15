package com.infinitelearning.navigation.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.infinitelearning.navigation.ui.theme.NavigationAppTheme

@Composable
fun CourseScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Ini adalah Screen Course",
            color = Color.White
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun CourseScreenPreview() {
    NavigationAppTheme {
        CourseScreen()
    }
}