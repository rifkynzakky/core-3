package com.example.core3_medallist

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle? ) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = mutableListOf<list>()
        resources.openRawResource(R.raw.medallists).bufferedReader().forEachLine {
            val temp = it.split(",")
            list.add(list(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]))
        }

        val countries = findViewById<RecyclerView>(R.id.recycler_view)

        countries.adapter = AdapterData(list)
        countries.layoutManager = LinearLayoutManager(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        val sharedPreferences: SharedPreferences = this.getSharedPreferences("key", Context.MODE_PRIVATE)

        if (id == R.id.action_save) {
            // User chose the "save" action, mark the current item
            val i = Intent(this, Activity2::class.java).apply {
                val name = sharedPreferences.getString("key", "no item")
//                putExtra("NUMBER", list("x","x", "x", "x", "x", "x"))
            }
            startActivity(i)
        }
        return super.onOptionsItemSelected(item)
    }

    fun loadData(item: list){
        val editor = getSharedPreferences("key", MODE_PRIVATE).edit()
        editor.putString("Country",item.country)
        editor.putString("IOC",item.countryCode)
    }

}