package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ){
                        CircularProgressBar(percentage = 0.6f, number = 100)
                    }
                }
            }
        }
    }
}



@Composable
fun CustomButtonGradient(){
    Button(
        onClick = { /*TODO*/ },
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .width(346.dp)
            .height(60.dp),
    ) {
        Box(
            modifier = Modifier
                .width(346.dp)
                .height(60.dp)
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF642B73),
                            Color(0xFFC6426E)
                        )
                    )
                )
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ){
            Text(text = "Sign Up", color = Color.White, fontSize = 17.sp)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    MyApplicationTheme {
            CustomButtonGradient()
    }
}