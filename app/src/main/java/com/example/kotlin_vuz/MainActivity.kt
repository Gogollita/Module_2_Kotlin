package com.example.kotlin_vuz

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    WaterTracker()
                }
            }
        }
    }
}

data class Contact(
    val firstName: String,
    val surName: String,
    val lastName: String,
    val phone: String?,
    val address: String,
)

@Composable
fun WaterTracker() {
    val primaryColor = colorResource(R.color.primaryColor)
    val secondaryColor = Color.Gray
    val buttonTextColor = Color.White
    var waterCount by remember { mutableIntStateOf(100) }
    var daysCount by remember { mutableIntStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Трекер воды",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = primaryColor
        )

        Spacer(modifier = Modifier.height(48.dp))

        Text(
            text = "$waterCount мл",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = secondaryColor
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { waterCount += 250 },
            colors = ButtonDefaults.buttonColors(primaryColor),
            shape = RoundedCornerShape(4.dp)
        ) {
            Text(
                text = "+250 мл",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = buttonTextColor
            )
        }
        Spacer(modifier = Modifier.height(96.dp))
        Button(
            onClick = {
                if (waterCount >= 1500)
                    daysCount += 1
                else
                    daysCount = 0
                waterCount = 0
            },
            colors = ButtonDefaults.buttonColors(primaryColor),
            shape = RoundedCornerShape(4.dp)
        ) {
            Text(
                text = "Завершить день",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = buttonTextColor
            )
        }
        Spacer(modifier = Modifier.fillMaxHeight(0.3f))
        Column{
            Text(
                text = "Серия дней подряд:",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = secondaryColor
            )
            Box(modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(8.dp)
                .size(96.dp)
                .clip(RoundedCornerShape(50))
                .background(primaryColor)
            ) {
                Text(
                    text = "$daysCount",
                    fontSize = 64.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.align(alignment = Alignment.Center)

                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WaterTrackerPreview() {
    Kotlin_VUZTheme {
        WaterTracker()
    }
}
