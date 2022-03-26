package com.example.myapplication

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.Shapes


@ExperimentalMaterialApi
@Composable
fun OnBoardingAnimatedCard(){
    var expandedState by remember { mutableStateOf(false)}

    val rotationState by animateFloatAsState(
        targetValue = if(expandedState) 180f else 0f
    )

    // parent column
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // main card
        Card(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                )
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .padding(10.dp),
            shape = Shapes.medium,
            onClick = {
                expandedState = !expandedState
            }
        ) {
            // column inside card
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // row inside column, inside the card
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "OnBoarding", fontSize = 24.sp, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, modifier = Modifier.weight(6f))
                    IconButton(
                        onClick = {
                            expandedState = !expandedState
                        },
                        modifier = Modifier
                            .weight(1f)
                            .rotate(rotationState)
                    ) {
                       Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Drop-Down")
                    }
                } // row inside column, inside the card

                if(expandedState){
                    Details()
                }

            } // column inside card

        } // main card

    } // parent column
}


@Composable
fun Details(){
    OutlinedTextField(
        value = "",
        onValueChange ={},
        label = { Text(text = "Username")},
        leadingIcon = { Icon(imageVector = Icons.Filled.Person, contentDescription = "Username")}
    )

    OutlinedTextField(
        value = "",
        onValueChange ={},
        label = { Text(text = "Password")},
        leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = "Password")}
    )
    Spacer(modifier = Modifier.height(8.dp))

    OutlinedButton(onClick = { /*TODO*/ }) {
        Text(text = "LOGIN")
    }
}








@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview1(){
    OnBoardingAnimatedCard()
}