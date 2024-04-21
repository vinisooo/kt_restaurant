package com.example.kotlinrestaurant.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinrestaurant.databinding.ItemBinding
import com.example.kotlinrestaurant.model.Item

class ItemAdapter(
    private val context: Context, private val itemList: MutableList<Item>
): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val listItem = ItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ItemViewHolder(listItem)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.itemImg.setBackgroundResource(itemList[position].img!!)
        holder.itemName.text = itemList[position].name
        holder.itemDescription.text = itemList[position].description
        holder.itemPrice.text = itemList[position].price!!
        holder.addItemBtn.setOnClickListener {
            addItem(itemList[position])
        }
    }

    inner class ItemViewHolder(binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {
        val itemImg = binding.itemImg
        val itemName = binding.itemName
        val itemDescription = binding.itemDescription
        val itemPrice = binding.itemPrice
        val addItemBtn = binding.addButton
    }

    private fun addItem(item: Item) {
        val toast = Toast.makeText(context, "${item.name} adicionado ao carrinho", Toast.LENGTH_SHORT)
        toast.show()
    }
}