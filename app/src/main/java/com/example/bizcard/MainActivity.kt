package com.example.bizcard

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bizcard.ui.theme.BizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(12.dp),
            shape = RoundedCornerShape(
                corner = CornerSize(15.dp)
            ),
//            backgroundColor = Color.Green,
            elevation = 4.dp
        ) {
            Column(
                modifier = Modifier.height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CreateProfileImage()
                Divider()
                CreateInfo()
                Button(
                    onClick = {
                        Log.d("Clicked", "created card")

                    }) {
                    Text(
                        text = "portfolio",
                        style = MaterialTheme.typography.button
                    )

                }
            }
        }
    }

}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Person Name",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primaryVariant
        )
        Text(
            text = "Title",
            modifier = Modifier.padding(3.dp)
        )
        Text(
            text = "Twitter Handle",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.subtitle1,
        )
    }
}

@Composable
private fun CreateProfileImage() {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, color = LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "profile image",
            modifier = Modifier.size(
                135.dp
            ),
            contentScale = ContentScale.Crop,
        )

    }
}


//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    BizCardTheme {
//        createBizCard()
//    }
//}

@Preview
@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Surface(
            modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            shape = RoundedCornerShape(
                corner = CornerSize(6.dp)
            ),
            border = BorderStroke(
                width = 2.dp,
                color = LightGray
            )

        ) {
            Portfolio(data = listOf("Project 1", "Project 2", "Project 3"))

        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    Text(text = "Project go here!")
}
