package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    SimpleAnimation()
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

    Box(modifier = Modifier
        .size(size)
        .background(color = Color.Red),
        contentAlignment = Alignment.Center
    ){
        Button(onClick = { /*TODO*/ }) {
            sizeState += 50.dp
            Text(text = "Increase")
        }
    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        OnBoarding()
    }
}