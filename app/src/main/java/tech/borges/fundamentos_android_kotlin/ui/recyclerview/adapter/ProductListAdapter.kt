package tech.borges.fundamentos_android_kotlin.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tech.borges.fundamentos_android_kotlin.R
import tech.borges.fundamentos_android_kotlin.src.models.Product

class ProductListAdapter(
    private val context: Context,
    private val products: List<Product>
) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(product: Product) {
            val nameView = itemView.findViewById<TextView>(R.id.name)
            nameView.text = product.name

            val descriptionView = itemView.findViewById<TextView>(R.id.description)
            descriptionView.text = product.description

            val priceView = itemView.findViewById<TextView>(R.id.price)
            priceView.text = product.price.toPlainString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(products[position])
    }
}
