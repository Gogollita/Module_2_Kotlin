package com.example.kotlin_vuz

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

data class Contact(
    val firstName: String,
    val surName: String,
    val lastName: String,
    val phone: String?,
    val address: String,
)

@Composable
fun ContactColumn(contact: Contact) {
    val field = mapOf(
        "Имя" to contact.firstName,
        "Отчество" to contact.surName,
        "Фамилия" to contact.lastName,
        "Мобильный телефон" to contact.phone,
        "Адрес" to contact.address
    )
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .background(Color.LightGray)
        .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            for ((name, value) in field)
                Text(
                    text = "$name: $value",
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 14.sp,
                )
        }
        Image(
            painter = painterResource(R.drawable.cheremsha),
            contentDescription = null
        )
    }
}

@Composable
fun ContactList(contact: List<Contact>) {
    Column{
        ContactColumn(contact[0])
        ContactColumn(contact[1])
        ContactColumn(contact[2])
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ContactColumnPreview() {
    val contact = Contact("Евгений", "Андреевич", "Лукашин", "+7 495 495 95 95", "г. Москва, 3-я улица Строителей, д. 25, кв. 12")
    Kotlin_VUZTheme {
        ContactColumn(contact)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AnotherCirclePreview() {
    val contact = listOf(
        Contact("Евгений", "Андреевич", "Лукашин", "+7 495 495 95 95", "г. Москва, 3-я улица Строителей, д. 25, кв. 12"),
        Contact("Василий", "Егорович", "Кузякин", "—", "Ивановская область, дер. Крутово, д. 4"),
        Contact("Людмила", "Прокофьевна", "Калугина", "+7 495 788 78 78", "Москва, Большая Никитская, д. 43, кв. 290"),
    )
    Kotlin_VUZTheme {
        ContactList(contact)
    }
}
