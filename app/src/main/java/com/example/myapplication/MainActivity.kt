package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.GrayscaleTransformation
import coil.transform.RoundedCornersTransformation
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    @ExperimentalCoilApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp)) {
                            SignUpTexts(title = "Sign Up", fontSize = 28.sp, fontWeight = FontWeight.Bold)
                        }
                        Spacer(modifier = Modifier.height(45.dp))

                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp)) {
                            SignUpTexts(title = "Fullname", fontSize = 17.sp)
                        }
                        FormFields(formLabel = "Ebele Kayce", state = "")

                        Spacer(modifier = Modifier.height(20.dp))

                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp)) {
                            SignUpTexts(title = "Email address", fontSize = 17.sp)
                        }
                        FormFields(formLabel = "dsgnbyk@gmail.com", state = "")

                        Spacer(modifier = Modifier.height(20.dp))

                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp)) {
                            SignUpTexts(title = "Password", fontSize = 17.sp)
                        }
                        FormFields(formLabel = "***********", state = "")

                        Spacer(modifier = Modifier.height(80.dp))

                        SignUpButton(title = "Sign Up", fontSize = 17.sp, fontColor = Color.White)

                    }
                }
            }
        }
    }
}


@ExperimentalCoilApi
@Composable
fun CoilImage(){
    Box(
        modifier = Modifier
            .height(150.dp)
            .width(150.dp),
        contentAlignment = Alignment.Center
    ){
        val painter = rememberImagePainter(
            data = "https://www.bing.com/images/search?view=detailV2&ccid=9ZDZ4%2f90&id=218E38B4D2C1199E5C10DE8BEC478DE0691B0345&thid=OIP.9ZDZ4_90qBA093Z5YKOGdgHaEK&mediaurl=https%3a%2f%2fcdn2.expertreviews.co.uk%2fsites%2fexpertreviews%2ffiles%2fstyles%2fer_main_wide%2fpublic%2f2015%2f05%2fgoogle_photos.png%3fitok%3d65cfaqGF&cdnurl=https%3a%2f%2fth.bing.com%2fth%2fid%2fR.f590d9e3ff74a81034f7767960a38676%3frik%3dRQMbaeCNR%252byL3g%26pid%3dImgRaw%26r%3d0&exph=540&expw=960&q=google+photo&simid=608033735780417915&FORM=IRPRST&ck=6AB7CED57FAA27DFC1F0562511756CF8&selectedIndex=7",
            builder = {
                placeholder(R.drawable.ic_google)
                error(R.drawable.ic_google)
                crossfade(1000)
                transformations(
                    GrayscaleTransformation(),
                    RoundedCornersTransformation(50f)
                )
            }
        )
        val painterState = painter.state
        Image(painter = painter, contentDescription = "Google Picture")
        if (painterState is ImagePainter.State.Loading){
            CircularProgressIndicator()
        }
    }

}





@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        //PasswordTextField()
    }
}