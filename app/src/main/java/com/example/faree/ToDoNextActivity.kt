package com.example.faree


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.SparseBooleanArray
import android.widget.ArrayAdapter
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_to_do_next.*
import kotlinx.android.synthetic.main.activity_to_do_next.editText
import kotlinx.android.synthetic.main.activity_to_do_view.*

class ToDoNextActivity : AppCompatActivity() {
 /* override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, "onSaveInstanceState")

        val userText = editText.text
        outState?.putCharSequence("savedText", userText)
    }*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_next)



        addtodonext.setOnClickListener {
            //get text from edittexts
            val tasktyped = findViewById<EditText>(R.id.editText)
            val taskentered = tasktyped.text.toString()
            if(!taskentered.equals("")) {

                //intent to start activity
                val intent = Intent(this@ToDoNextActivity, ToDoViewActivity::class.java)
                intent.putExtra("NewTask", taskentered)
                editText.text.clear()
                startActivity(intent)
            }
        }

        viewtodonext.setOnClickListener {
            val intent = Intent(this@ToDoNextActivity, ToDoViewActivity::class.java)
            startActivity(intent)
        }
    }
}