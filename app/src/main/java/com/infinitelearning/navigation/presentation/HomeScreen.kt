package com.infinitelearning.navigation.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.infinitelearning.navigation.data.DummyData
import com.infinitelearning.navigation.model.Mentor
import com.infinitelearning.navigation.navigation.Screen
import com.infinitelearning.navigation.presentation.component.MentorItem

@Composable
fun HomeScreen(
    navController: NavController,
    mentors: List<Mentor> = DummyData.mobileMentors,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .padding(start = 20.dp)
        ) {
            Text(
                text = "Mobile Development Mentor",
                fontSize = 20.sp
            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(mentors, key = { it.id }) {
                    MentorItem(mentor = it) { mentorId ->
                        navController.navigate(Screen.Detail.route + "/$mentorId")
                    }
                }
            }
        }
    }
}