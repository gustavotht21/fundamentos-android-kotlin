package tech.borges.fundamentos_android_kotlin.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import tech.borges.fundamentos_android_kotlin.R
import tech.borges.fundamentos_android_kotlin.src.database.dao.ProductDAO
import tech.borges.fundamentos_android_kotlin.src.models.Product
import java.math.BigDecimal

class ProductCreate : AppCompatActivity(R.layout.activity_product_create) {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        Log.i("ProductCreate", "onCreate: Teste")

        val saveButton = findViewById<Button>(R.id.button)
        saveButton.setOnClickListener {
            val nameField = findViewById<EditText>(R.id.name)
            val name = nameField.text.toString()

            val descriptionField = findViewById<EditText>(R.id.description)
            val description = descriptionField.text.toString()

            val priceField = findViewById<EditText>(R.id.price)
            val stringPrice = priceField.text.toString()

            val price = if (stringPrice.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(stringPrice)
            }

            val productDao = ProductDAO()

            productDao.store(
                Product(
                    name = name,
                    description = description,
                    price = price
                )
            )
        }
    }
}