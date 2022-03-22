package com.example.myapplication


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension


private val onBoardingConstraints = ConstraintSet {
    val username = createRefFor("username")
    val button = createRefFor("button")
    val topGuideline = createGuidelineFromTop(100.dp)
    val bottomGuideline = createGuidelineFromBottom(180.dp)

    constrain(username){
        top.linkTo(topGuideline, margin = 8.dp)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
    }

    constrain(button){
        top.linkTo(username.bottom, margin = 8.dp)
        start.linkTo(username.start)
        end.linkTo(username.end)
        bottom.linkTo(bottomGuideline)
        width = Dimension.fillToConstraints
    }
}

@Composable
fun OnBoarding(){
    ConstraintLayout(onBoardingConstraints, modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)) {

        val labelHintState = produceState(initialValue = ""){
            kotlinx.coroutines.delay(3000)
            value = "Username"
        }

        // username input field
        OutlinedTextField(value = "", onValueChange = {},
                label = { Text(text = labelHintState.value)},
                modifier = Modifier.layoutId("username")
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