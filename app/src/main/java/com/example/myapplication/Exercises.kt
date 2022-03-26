package com.example.myapplication


import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@ExperimentalMaterialApi
@Composable
fun ExpandableCard(){
    var expandedState by remember{ mutableStateOf(false)}

    val rotationState by animateFloatAsState(
        targetValue = if(expandedState) 180f else 0f
    )

    // Parent container
    Column(modifier = Modifier
        .padding(12.dp)
        .fillMaxSize()){
        // parent card
        Card(
            elevation = 12.dp,
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            onClick = {
                expandedState = !expandedState
            }
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(12.dp)
            ) {
                // row card
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // header text
                    Text(
                        modifier = Modifier.weight(6f),
                        text = "Quote of the Day",
                        maxLines = 1,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                    ) // header text

                    // icon start
                    IconButton(
                        onClick = { expandedState = !expandedState },
                        modifier = Modifier
                            .alpha(ContentAlpha.medium)
                            .weight(1f)
                            .rotate(rotationState)
                    ) {
                        Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Drop-Down Arrow")
                    } // icon end

                } // row card

                if(expandedState){
                    Text(
                        text = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                                "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                                "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                                "consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                                "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                                "proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                        fontSize = 14.sp,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

        } // parent card
    } // parent container
}


@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun Previewer(){
    ExpandableCard()
}