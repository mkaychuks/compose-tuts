package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ConstraintLayouts()
                }
            }
        }
    }
}

@Composable
fun ConstraintLayouts(){

    // creating a ConstraintSet for the composable
    val constraints = ConstraintSet {
        val greenBox = createRefFor("greenBox")
        val redBox = createRefFor("redBox")

        constrain(greenBox){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(redBox.start)
        }

        constrain(redBox){
            top.linkTo(parent.top)
            end.linkTo(parent.end)
            start.linkTo(greenBox.end)
        }
    }
    // making use of the constraints
    ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.background(color = Color.Cyan).layoutId("greenBox"))
        Box(modifier = Modifier.background(color = Color.Blue).layoutId("redBox"))
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
       ConstraintLayouts()
    }
}