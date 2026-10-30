package com.example.kotlin_vuz

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin_vuz.ui.theme.Kotlin_VUZTheme
import org.w3c.dom.Text

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
                    Column {
                        Res_string_1()
                        Res_string_2()
                        Res_string_3()
                    }
                }
            }
        }
    }
}

@Composable
fun Res_string_1() {
    Text(
        text = stringResource(R.string.AboutJC),
        color = Color.Green,
        fontSize = 16.sp,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center
    )
}

@Composable
fun Res_string_2() {
    Text(
        text = stringResource(R.string.AboutJC),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis

    )
}

@Composable
fun Res_string_3() {
    Text(
        text = stringResource(R.string.AboutJC),
        style = TextStyle(
            textIndent = TextIndent(firstLine = 48.sp)
        ),
        fontSize = 24.sp,
        color = Color.Black,
        textDecoration = TextDecoration.Underline,
        modifier = Modifier.background(Color.Green)
    )
}

@Preview(showBackground = true)
@Composable
fun TextPreview() {
    Kotlin_VUZTheme {
        Column {
            Res_string_1()
            Res_string_2()
            Res_string_3()
        }
    }
}
