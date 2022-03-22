package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val scaffoldstate = rememberScaffoldState()
                    val scope = rememberCoroutineScope()
                    Scaffold(scaffoldState = scaffoldstate){
                        var counter = produceState(initialValue = 0){
                            delay(3000L)
                            value = 4
                        }
                        if(counter.value % 5 == 0 && counter.value > 0){
                            LaunchedEffect(key1 = scaffoldstate.snackbarHostState){
                                scaffoldstate.snackbarHostState.showSnackbar("Hello")
                            }
                        }

                        Button(onClick = {}) {
                            Text("Click me: $counter")
                        }
                    }
                }
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {

    }
}