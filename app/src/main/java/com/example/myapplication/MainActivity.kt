package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    TextFieldsState()
                }
            }
        }
    }
}


@Composable
fun TextFieldsState(){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

       // creating a state for the text field
        var emailState by remember{ mutableStateOf("admin@gmail.com")}

       OutlinedTextField(
           value = emailState,
           onValueChange = { newEmail ->
                emailState = newEmail
       },
           label = { Text(text = "Email")},
           leadingIcon = {
               IconButton(onClick = {
                   Log.d("Leading Icon", "Leading Icon Clicked")
               }) {
                   Icon(imageVector = Icons.Filled.Email, contentDescription = "Email form")
               }
           },
           keyboardOptions = KeyboardOptions(
               imeAction = ImeAction.Done,
               keyboardType = KeyboardType.Email
           ),
           keyboardActions = KeyboardActions(
               onDone = {
                   Log.d("ImeAction","onDone click")
               }
           )
       )
    }
}





@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        TextFieldsState()
    }
}