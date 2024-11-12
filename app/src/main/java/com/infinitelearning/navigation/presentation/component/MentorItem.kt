package com.infinitelearning.navigation.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.infinitelearning.navigation.R
import com.infinitelearning.navigation.model.Mentor
import com.infinitelearning.navigation.ui.theme.NavigationAppTheme

@Composable
fun MentorItem(
    mentor: Mentor,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onItemClicked(mentor.id)
            }
    ) {
        Image(
            painter = painterResource(id = mentor.photo),
            contentDescription = mentor.name, modifier = Modifier
                .clip(CircleShape)
                .size(80.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = mentor.name,
                style = MaterialTheme.typography.titleMedium,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.width(200.dp),
                maxLines = 1
            )
            Text(
                text = mentor.role,
                color = MaterialTheme.colorScheme.primary,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.width(200.dp),
                maxLines = 1
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun MentorItemHorizontalPreview() {
    NavigationAppTheme {
        MentorItem(
            mentor = Mentor(1, "Reza Kurniawan", "Reza", "Mobile", R.drawable.reza),
            onItemClicked = { mentorId ->
                println("Mentor Id : $mentorId")
            }
        )
    }
}