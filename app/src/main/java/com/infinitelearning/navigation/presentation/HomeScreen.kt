package com.infinitelearning.navigation.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.infinitelearning.navigation.data.DummyData
import com.infinitelearning.navigation.model.Mentor
import com.infinitelearning.navigation.navigation.Screen
import com.infinitelearning.navigation.presentation.component.MentorItem

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    mentors: List<Mentor> = DummyData.mobileMentors,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .padding(start = 20.dp)
    ) {
        items(mentors, key = { it.id }) {
            MentorItem(mentor = it) { mentorId ->
                navController.navigate(Screen.Detail.route + "/$mentorId")
            }
        }
    }
}