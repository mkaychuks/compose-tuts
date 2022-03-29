package com.example.myapplication


import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.Shapes

@ExperimentalMaterialApi
@Composable
fun ThirdPartyButton(
    title: String = "Sign Up with Google",
    loadingText: String = "Creating Account...",
    icon: Painter = painterResource(id = R.drawable.ic_google),
    background: Color = Color.White
){
    var clicked by remember { mutableStateOf(false)}

    Surface(
        onClick = { clicked = !clicked },
        color = background,
        shape = Shapes.medium,
        border = BorderStroke(1.dp, color = Color.LightGray),
        modifier = Modifier
            .width(290.dp)
            .height(47.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    end = 16.dp,
                    top = 12.dp,
                    bottom = 12.dp
                )
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(painter = icon, contentDescription = "Google SignUp", tint = Color.Unspecified )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = if(clicked) loadingText else title)
            if (clicked){
                Spacer(modifier = Modifier.width(16.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.dp),
                    strokeWidth = 2.dp,
                    color = MaterialTheme.colors.primary
                )
            }
        }
    }
}


@Composable
fun SignUpForm(){
    var emailState by remember { mutableStateOf("")}
    var passwordState by remember { mutableStateOf("")}

    OutlinedTextField(
        value = emailState,
        onValueChange = { newEmail -> emailState = newEmail},
        label = {Text("Email")},
        leadingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Email, contentDescription = "Email form")
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                Log.d("Leading Icon", "Email Icon Clicked")
            }
        )
    )
    Spacer(modifier = Modifier.height(8.dp))

    OutlinedTextField(
        value = passwordState,
        onValueChange = { newPassword -> passwordState = newPassword},
        label = {Text("Password")},
        leadingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Lock, contentDescription = "Password form")
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                Log.d("Leading Icon", "Password Icon Clicked")
            }
        )
    )
    Spacer(modifier = Modifier.height(12.dp))
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .width(290.dp)
            .height(47.dp)
    ) {
        Text("SIGN UP")
    }
    Spacer(modifier = Modifier.height(8.dp))
    Text("OR", textAlign = TextAlign.Center)
}



@ExperimentalMaterialApi
@Composable
@Preview
fun DefaultPreviewer(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SignUpForm()
        Spacer(modifier = Modifier.height(12.dp))
        ThirdPartyButton()
        Spacer(modifier = Modifier.height(8.dp))
        ThirdPartyButton(
            title = "Sign Up with Instagram",
            loadingText = "Creating Account",
            icon = painterResource(id = R.drawable.ic_google),
            background = Color.Transparent
        )
    }
}
