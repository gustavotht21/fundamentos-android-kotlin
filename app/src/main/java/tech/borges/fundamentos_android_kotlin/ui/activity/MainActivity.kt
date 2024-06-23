package tech.borges.fundamentos_android_kotlin.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import tech.borges.fundamentos_android_kotlin.R
import tech.borges.fundamentos_android_kotlin.src.database.dao.ProductDAO
import tech.borges.fundamentos_android_kotlin.ui.recyclerview.adapter.ProductListAdapter

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onResume() {
        super.onResume()

        val productDao = ProductDAO()

        val recyclerView = findViewById<RecyclerView>(R.id.productList)
        recyclerView.adapter = ProductListAdapter(
            context = this,
            products = productDao.get()
        )

        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            val intent = Intent(this, ProductCreate::class.java)
            startActivity(intent)
        }
    }
}