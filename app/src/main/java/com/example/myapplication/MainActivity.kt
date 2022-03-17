package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    TextFieldsScaffold()
                }
            }
        }
    }
}

@Composable
fun TextFieldsScaffold(){
    val scaffoldState = rememberScaffoldState()

    var textFieldState by remember{
        mutableStateOf("")
    }

    val scope = rememberCoroutineScope()


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(value = textFieldState, onValueChange = { newText ->
                textFieldState = newText
            },
                singleLine = true,
                label = { Text("Username")},
                modifier = Modifier.fillMaxWidth()
                )
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = {
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar("Hello $textFieldState", duration = SnackbarDuration.Short)
                }
            }) {
                Text("Greet me")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        TextFieldsScaffold()
    }
}