package com.example.kotlin_vuz

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
                        name = "Android"
                    )
                }
            }
        }
    }
}

@Composable
fun Hello(name: String?) {
    Text(
        text = if (name != null) "Hello $name!" else "Имя не задано"
    )
}

@Preview(showBackground = true)
@Composable
fun HelloPreview() {
    Kotlin_VUZTheme {
        Hello(name = null)
    }
}
