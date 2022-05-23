package com.example.compmoviedb.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.compmoviedb.navigation.Screens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    var stateAnimate by remember {
        mutableStateOf(false)
    }

    val alphaAnimation = animateFloatAsState(
        targetValue = if (stateAnimate) 1f else 0f,
        animationSpec = tween(durationMillis = 1500)
    )

    LaunchedEffect(key1 = Unit) {
        stateAnimate = true
        delay(2000)
        navController.navigate(Screens.Main.route)
    }

    Splash(alpha = alphaAnimation.value)
}

@Composable
fun Splash(alpha: Float) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .size(120.dp)
                .alpha(alpha = alpha),
            imageVector = Icons.Default.PlayArrow,
            contentDescription = "",
            tint = Color.Black
        )
    }
}