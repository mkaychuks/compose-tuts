package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    Nonsense()
                }
            }
        }
    }
}


private val constraints = ConstraintSet{
    val greenBox = createRefFor("greenButton")
    val redBox = createRefFor("redButton")

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

@Composable
fun Nonsense(){
    // making use of the constraints
    ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.background(color = Color.Blue)
            .layoutId("redButton")
            .size(50.dp, 50.dp))

        Box(modifier = Modifier.background(color = Color.Red)
            .layoutId("greenButton")
            .size(50.dp, 50.dp))
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
       Nonsense()
    }
}