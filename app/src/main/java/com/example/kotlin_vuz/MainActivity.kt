package com.example.kotlin_vuz

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlin_vuz.ui.theme.Kotlin_VUZTheme

class MainActivity : ComponentActivity() {
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
                    Hello(
                        name = null
                    )
                }
            }
        }
    }
}

@Composable
fun Hello(name: String?) {
    Text(
        text = if (name != null) "Hello $name!" else "Имя не задано",
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp)
    )
}

@Preview(name = "Альбомная ориентация", showSystemUi = true, device = "spec:width=411dp,height=891dp,dpi=420,orientation=landscape")
@Preview(name = "Портретная ориентация", showSystemUi = true, device = "spec:width=411dp,height=891dp,dpi=420,orientation=portrait")
@Preview(name = "Круглая ориентация", device = "spec:width=200dp,height=200dp,isRound=true", showSystemUi = true, showBackground = true, backgroundColor = 0xFFFFFF00)
@Composable
fun HelloPreview() {
    Kotlin_VUZTheme {
        Hello(name = "Android")
    }
}

