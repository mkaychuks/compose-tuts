package com.example.myapplication



import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.Shapes


@ExperimentalMaterialApi
@Composable
fun ExpandableCard(){
    var expandedState by remember{ mutableStateOf(false)}
    val rotationState by animateFloatAsState(
        targetValue = if(expandedState) 180f else 0f
    )
    
    Card(
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = Shapes.medium,
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    modifier = Modifier.weight(6f),
                    text = "My Title",
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .weight(1f)
                        .alpha(ContentAlpha.medium)
                        .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    }) {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Drop Down")
                }
            }

            if(expandedState){
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                            "consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                            "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                            "proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    fontWeight = FontWeight.Normal,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}



@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun Previewer(){
    ExpandableCard()
}