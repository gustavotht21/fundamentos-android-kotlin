package tech.borges.fundamentos_android_kotlin.src.models

import java.math.BigDecimal

data class Product(
    val name: String,
    val description: String,
    val price: BigDecimal
)
