package com.example.kotlin_vuz

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
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

                }
            }
        }
    }
}

@Composable
fun FirstButton() {
    Column(modifier = Modifier.fillMaxSize()
        .padding(top = 24.dp)) {
        Button(
            onClick = ({}),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(4.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(Color.LightGray),
            border = BorderStroke(2.dp, Color.Gray)
        ) {
            Text(
                text = "Нажми на меня",
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ButtonPreview() {
    Kotlin_VUZTheme {
        FirstButton()
    }
}
