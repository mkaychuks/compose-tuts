package com.example.myapplication

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
fun Login(){
    LazyColumn{
        items(
            300
        ){
            Text(text = "$it is the number her",
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
                )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun Previewer(){
    Login()
}