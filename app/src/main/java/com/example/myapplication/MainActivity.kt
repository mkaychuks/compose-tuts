package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                        ExpandableCard()
                }
            }
        }
    }
}


@Composable
fun SimpleAnimation(){
    var sizeState by remember {
        mutableStateOf(200.dp)
    }

    val size by animateDpAsState(
            targetValue = sizeState,
            tween(
                durationMillis = 5000,
                delayMillis = 300,
                easing = LinearOutSlowInEasing
            )
        )

    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Blue,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 3000, delayMillis = 300, easing = LinearOutSlowInEasing),
             repeatMode = RepeatMode.Reverse
        )
    )

    Box(modifier = Modifier
        .size(size)
        .clip(shape = CircleShape)
        .background(color),
        contentAlignment = Alignment.Center
    ){
        Button(onClick = {
            sizeState += 50.dp
        }) {
            Text(text = "Increase")
        }
    }
}




@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        ExpandableCard()
    }
}