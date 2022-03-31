package com.example.myapplication


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.GrayscaleTransformation
import coil.transform.RoundedCornersTransformation

@ExperimentalCoilApi
@Composable
fun CoilImager(){
    Box(
        modifier = Modifier
            .width(200.dp)
            .height(200.dp),
    contentAlignment = Alignment.Center){
        val painter = rememberImagePainter(
            data = "",
            builder = {
                placeholder(R.drawable.ifeanyi)
                error(R.drawable.ic_google)
                crossfade(1000)
                transformations(
                    GrayscaleTransformation(),
                    RoundedCornersTransformation()
                )
            }
        )
        val painterState = painter.state
        Image(painter = painter, contentDescription = "Image Loading")
        if(painterState is ImagePainter.State.Loading){
            CircularProgressIndicator()
        }
    }
}


@Composable
fun PasswordTextField(){
    var passwordState by rememberSaveable{ mutableStateOf("")}

    var passwordVisibilty by remember { mutableStateOf(false)}

    val icon = if(passwordVisibilty)
        painterResource(id = R.drawable.ic_link_on)
        else
            painterResource(id = R.drawable.ic_link_off)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = passwordState,
            onValueChange = {passwordState = it},
            placeholder = {Text("Password")},
            label = {Text("password")},
            trailingIcon = {
                IconButton(onClick = {passwordVisibilty = !passwordVisibilty}) {
                    Icon(painter = icon, contentDescription = "Hidden")
                }
            },
            visualTransformation = if(passwordVisibilty) VisualTransformation.None
                                    else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreviewer(){
    PasswordTextField()
}