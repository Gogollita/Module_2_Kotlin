package com.example.kotlin_vuz

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlin_vuz.ui.theme.Kotlin_VUZTheme
import kotlin.random.Random

data class Cart(
    val products: List<Product>
)
data class Product(
    val id: Int,
    val name: String,
    val price: Int
)
class MainActivity : ComponentActivity() {
    private var totalSum = 0
    private var productSize = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartScreen()
        }
    }

    @Composable
    fun ShoppingCartScreen() {
        var products by remember {
            mutableStateOf(
                listOf(
                    Product(0, "Товар #1", 100),
                    Product(1, "Товар #2", 150),
                    Product(2, "Товар #3", 56)
                )
            )
        }
        Column {
            EnumProducts(products)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Товаров на сумму: $totalSum рублей")
            AddProductSection {
                products = products + Product(
                    id = products.size,
                    name = "Товар #${products.size + 1}",
                    price = Random.nextInt(0, 100)
                )
                productSize = products.size
                Log.d("ADD", "$products")
            }
            RemoveProductSection {
                products = products.dropLast(1)
                productSize--
                Log.d("REMOVE", "$products")

            }

            totalSum = 0
            Cart(products)
        }
    }

    @Composable
    private fun EnumProducts(products: List<Product>) {
        for (product in products) {
            Text(text = product.name + " - " + product.price + " рублей")
            totalSum += product.price
        }
    }

    @Composable
    fun AddProductSection(
        onAdd: () -> Unit
    ) {
        // Если сумма заказа больше 500, то показываем сообщение о бесплатной доставке
        if (totalSum > 500){
            Toast.makeText(LocalContext.current, "Доставка бесплатная!", Toast.LENGTH_SHORT).show()
        }
        Button(onClick = onAdd) {
            Text(text = "Добавить товар")
        }
    }

    @Composable
    fun RemoveProductSection(
        onRemove: () -> Unit
    ) {
        if (productSize > 0) {
            Button(onClick = onRemove) {
                Text(text = "Удалить товар")
            }
        }
        else {
            //todo
        }
    }
}