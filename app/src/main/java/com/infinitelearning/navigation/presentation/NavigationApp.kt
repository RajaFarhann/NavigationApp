package com.infinitelearning.navigation.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.infinitelearning.navigation.navigation.Screen
import com.infinitelearning.navigation.presentation.component.BottomBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Infinite App - Navigation") },
            )
        },
        bottomBar = {
            BottomBar(navController)
        },
        modifier = modifier
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = modifier.padding(contentPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(navController)
            }

            composable(Screen.Gallery.route) {
                GalleryScreen()
            }

            composable(Screen.Course.route) {
                CourseScreen()
            }

            composable(
                Screen.Detail.route + "/{mentorId}",
                arguments = listOf(navArgument("mentorId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                DetailMentorScreen(
                    navController = navController,
                    mentorsId = navBackStackEntry.arguments?.getInt("mentorId")
                )
            }
        }
    }
}