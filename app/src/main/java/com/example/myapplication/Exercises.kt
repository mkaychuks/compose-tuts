package com.example.myapplication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun Login(){
    val scaffoldState = rememberScaffoldState()

    Scaffold(scaffoldState = scaffoldState,
            modifier = Modifier.fillMaxSize()
        ) {

        Card(elevation = 8.dp,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(top = 120.dp, start = 10.dp, end = 10.dp)
                .fillMaxWidth()
                .height(300.dp)
            ) {
            
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp)
                ) {
                
                var usernameState by remember{ mutableStateOf("")}
                OutlinedTextField(value = usernameState, onValueChange = {
                    usernameState = it
                },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    label = { Text(text = "Username")}
                )

                var passwordState by remember{ mutableStateOf("")}
                OutlinedTextField(value = passwordState, onValueChange = {
                    passwordState = it
                },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    label = { Text(text = "Password")}
                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(6.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)

                ) {
                    Text(text = "LOGIN")
                }
            }
        }
    }
}






@Preview(showBackground = true)
@Composable
fun Previewer(){
    Login()
}