package com.example.myapplication


import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Composable
fun OnBoarding(){
    var sizeState by remember{ mutableStateOf(200.dp)}

    val size by animateDpAsState(
        targetValue = sizeState,
        tween(
            durationMillis = 5000,
            delayMillis = 500,
            easing = LinearOutSlowInEasing
        )
    )

    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.DarkGray,
        animationSpec = InfiniteRepeatableSpec(
            tween(
                durationMillis = 5000,
                delayMillis = 500,
                easing = LinearOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(modifier = Modifier
        .size(size)
        .clip(shape = CircleShape)
        .background(color),
    contentAlignment = Alignment.Center){
        Button(onClick = {
             sizeState += 50.dp
        },
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Increase")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun Previewer(){
    OnBoarding()
}