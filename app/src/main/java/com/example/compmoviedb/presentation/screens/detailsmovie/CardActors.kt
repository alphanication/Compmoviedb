package com.example.compmoviedb.presentation.screens.detailsmovie

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.compmoviedb.R
import com.example.compmoviedb.domain.models.movieactors.CastD
import com.example.compmoviedb.presentation.utils.Constants

@Composable
fun CardActors(navController: NavController, actor: CastD) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(0.dp, 350.dp)
            .padding(horizontal = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row {
            Text(
                modifier = Modifier.padding(horizontal = 2.dp),
                text = actor.character,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Text(
                modifier = Modifier.padding(horizontal = 2.dp),
                text = "(" + actor.name + ")"
            )
        }

        Spacer(modifier = Modifier.padding(top = 10.dp))

        Image(
            modifier = Modifier
                .size(300.dp)
                .clip(CutCornerShape(15.dp)),
            painter = if (actor.profile_path.isNotEmpty()) {
                rememberImagePainter(
                    Constants.Keys.MOVIEDB_BASE_IMAGE_URL + actor.profile_path
                )
            } else {
                painterResource(id = R.drawable.ic_person)
            },
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.padding(top = 10.dp))
    }
}