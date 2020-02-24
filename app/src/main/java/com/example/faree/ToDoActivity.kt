package com.example.faree

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_to_do.*

class ToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)


        addtodo.setOnClickListener{
            val intent = Intent(this, ToDoNextActivity::class.java)
            startActivity(intent)
            this.finish()
        }



    }
}