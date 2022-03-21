package com.example.myapplication


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension


private val onBoardingConstraints = ConstraintSet {
    val username = createRefFor("username")
    val email = createRefFor("email")
    val password = createRefFor("password")
    val button = createRefFor("button")
    val topGuideline = createGuidelineFromTop(100.dp)
    val bottomGuideline = createGuidelineFromBottom(180.dp)

    constrain(username){
        top.linkTo(topGuideline, margin = 8.dp)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
    }

    constrain(email){
        top.linkTo(username.bottom, margin = 8.dp)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
    }

    constrain(password){
        top.linkTo(email.bottom, margin = 8.dp)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
    }

    constrain(button){
        top.linkTo(password.bottom, margin = 8.dp)
        start.linkTo(password.start)
        end.linkTo(password.end)
        bottom.linkTo(bottomGuideline)
        width = Dimension.fillToConstraints
    }
}

@Composable
fun OnBoarding(){
    ConstraintLayout(onBoardingConstraints, modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)) {

        Image(painter = painterResource(id = R.drawable.ifeanyi),
            contentDescription = "profile_photo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(width = 5.dp, color = Color.Blue)
                .layoutId("image")
            )

        // username input field
        OutlinedTextField(value = "", onValueChange = {},
                label = { Text(text = "Username")},
                modifier = Modifier.layoutId("username")
            )

        // email input field
        OutlinedTextField(value = "", onValueChange = {},
            label = { Text(text = "Email")},
            modifier = Modifier.layoutId("email")
        )

        // password input field
        OutlinedTextField(value = "", onValueChange = {},
            label = { Text(text = "Password")},
            modifier = Modifier.layoutId("password")
        )

        OutlinedButton(onClick = { /*TODO*/ }, modifier = Modifier
            .layoutId("button")
            .size(60.dp)) {
            Text("Login")
        }

    }
}



@Preview(showBackground = true)
@Composable
fun Previewer(){
    OnBoarding()
}