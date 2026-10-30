package com.example.kotlin_vuz

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlin_vuz.ui.theme.Kotlin_VUZTheme

class CirclePreview : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kotlin_VUZTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize()
                    .padding(40.dp)
                ) {

                }
            }
        }
    }
}

@Composable
fun RedCircleInBlackBox() {
    Box(modifier = Modifier
        .background(Color.Black)
        .width(240.dp)
        .height(120.dp)
    ){
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = null,
            modifier = Modifier.align(alignment = Alignment.TopEnd)
        )
    }
}

@Composable
fun PurpleCircleInBlueBox() {
    Box(modifier = Modifier
        .background(Color.Blue)
        .width(240.dp)
        .height(120.dp)
    ){
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
                .align(alignment = Alignment.Center),
            colorFilter = ColorFilter.tint(Color(0xFF800080))
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun InitialCirclePreview() {
    Kotlin_VUZTheme {
        RedCircleInBlackBox()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AnotherCirclePreview() {
    Kotlin_VUZTheme {
        PurpleCircleInBlueBox()
    }
}
