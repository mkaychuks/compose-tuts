package com.example.myapplication



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview



@Composable
fun OnBoarding(){
    SelectionContainer(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(text = "Hello World")
            Text(text = "Hello World 2")
            DisableSelection {
                Text(text = "Hello World 3")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun Previewer(){
    OnBoarding()
}