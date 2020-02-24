package com.example.faree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_to_do_next.*
import kotlinx.android.synthetic.main.activity_to_do_view.*

class ToDoViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_view)
        var itemlist = arrayListOf<String>()
        var  adapter =ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_multiple_choice
            , itemlist)

        // Adding the items to the list when the add button is pressed

        val intent = intent
        val newtask = intent.getStringExtra("NewTask")
        itemlist.add(newtask)

        listView.adapter = adapter
        adapter.notifyDataSetChanged()

        addtd.setOnClickListener {

            itemlist.add(editText1.text.toString())
            listView.adapter =  adapter
            adapter.notifyDataSetChanged()
            // This is because every time when you add the item the input space or the eidt text space will be cleared
            editText1.text.clear()
        }
        // Clearing all the items in the list when the clear button is pressed
        cleartd.setOnClickListener {

            itemlist.clear()
            adapter.notifyDataSetChanged()
        }
        // Adding the toast message to the list when an item on the list is pressed
        listView.setOnItemClickListener { adapterView, view, i, l ->
            android.widget.Toast.makeText(this, "You Selected the item --> "+itemlist.get(i), android.widget.Toast.LENGTH_SHORT).show()
        }
        // Selecting and Deleting the items from the list when the delete button is pressed
        deletetd.setOnClickListener {
            val position: SparseBooleanArray = listView.checkedItemPositions
            val count = listView.count
            var item = count - 1
            while (item >= 0) {
                if (position.get(item))
                {
                    adapter.remove(itemlist.get(item))
                }
                item--
            }
            position.clear()
            adapter.notifyDataSetChanged()
        }

    }
}
