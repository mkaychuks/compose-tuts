package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    TextStyling()
                }
            }
        }
    }
}

@Composable
fun TextStyling(){
    Box(modifier = Modifier
        .background(color = Color.White)
        .fillMaxSize()
    ){
        Text(text = buildAnnotatedString {
             withStyle(
                 style = SpanStyle(
                     color = Color.Green,
                     fontSize = 50.sp
                 )
             ){
                 append("I")
             }
            append("feanyi ")

            withStyle(
                style = SpanStyle(
                    color = Color.Green,
                    fontSize = 50.sp
                )
            ){
                append("S")
            }
            append("amuel")
        },
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline
            )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        TextStyling()
    }
}