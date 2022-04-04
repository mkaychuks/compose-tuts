package com.example.myapplication



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.GrayscaleTransformation
import coil.transform.RoundedCornersTransformation

@Composable
fun SignUpTexts(
    title: String,
    fontSize: TextUnit,
    fontWeight: FontWeight = FontWeight.Normal
){
    Text(text = title, fontSize = fontSize, textAlign = TextAlign.Start, fontWeight = fontWeight)
}

@Composable
fun SignUpButton(
    title: String,
    fontSize: TextUnit,
    fontColor: Color
){
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .width(326.dp)
            .height(60.dp),
        shape = RoundedCornerShape(15.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF1E3799)
        ),
        elevation = ButtonDefaults.elevation(defaultElevation = 12.dp)
    ) {
        Text(text = title, fontSize = fontSize, color = fontColor)
    }
}

@Composable
fun FormFields(
    formLabel: String,
    state: String
){
    var buttonState by remember { mutableStateOf(state)}
    OutlinedTextField(
        value = buttonState,
        onValueChange = {buttonState = it},
        label = {
            Text(text = formLabel)
        },
        modifier = Modifier
            .width(326.dp)
            .height(70.dp),
        shape = RoundedCornerShape(15.dp)
    )
}



@ExperimentalCoilApi
@Composable
fun CoilImager(){
    Box(modifier = Modifier
        .height(300.dp)
        .width(300.dp),
        contentAlignment = Alignment.Center
        ){

        val painter = rememberImagePainter(
            data = "https://avatars.githubusercontent.com/u/14994036?v=4",
            builder = {
                placeholder(R.drawable.ic_google)
                error(R.drawable.ic_link_off)
                crossfade(2000)
                transformations(
                    GrayscaleTransformation(),
                    RoundedCornersTransformation(50f)
                )
            }
        )

        val painterState = painter.state
        Image(painter = painter, contentDescription = "Loading-Image")
        if(painterState is ImagePainter.State.Loading){
            CircularProgressIndicator()
        }
    }
}


@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreviewer(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Row() {
            SignUpTexts(title = "Sign Up", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(8.dp))
        SignUpButton(title = "Sign Up", fontSize = 17.sp, fontColor = Color.White)
        FormFields(formLabel = "Ebele Kayce", state = "")
    }
}