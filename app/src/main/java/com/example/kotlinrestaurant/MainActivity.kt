package com.example.kotlinrestaurant

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinrestaurant.adapter.ItemAdapter
import com.example.kotlinrestaurant.databinding.ActivityMainBinding
import com.example.kotlinrestaurant.model.Item

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var itemList: MutableList<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemList = getItemList()
        renderItems()
    }

    private fun getItemList():MutableList<Item> {
        val itemListAux: MutableList<Item> = mutableListOf()
        val context = applicationContext
        for(i in 1..10) {
            println(i)
            val imageName = "item${if (i > 4) 1 else i}"
            println(imageName)
            val imageResourceId = context.resources.getIdentifier(imageName, "drawable", context.packageName)

            val item = Item(R.drawable.item1, "Item $i", "descrição do item $i", "R$${i}0.00")
            itemListAux.add(item)
        }

        return itemListAux
    }

    private fun renderItems(){
        val recyclerView = binding.RecyclerViewItem
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        itemAdapter = ItemAdapter(this, itemList)
        recyclerView.adapter = itemAdapter
    }
}