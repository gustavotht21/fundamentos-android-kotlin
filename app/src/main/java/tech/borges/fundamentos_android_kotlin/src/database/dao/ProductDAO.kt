package tech.borges.fundamentos_android_kotlin.src.database.dao

import tech.borges.fundamentos_android_kotlin.src.models.Product

class ProductDAO : BaseDAO<Product>() {

    override fun get(): List<Product> {
        return productList.toList()
    }

    override fun store(data: Product) {
        productList.add(data)
    }

    companion object {
        private val productList = mutableListOf<Product>()
    }
}