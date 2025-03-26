package com.example.chuyen_tien_te

import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var listSpinner1:Spinner
    lateinit var listSpinner2:Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listSpinner1 = findViewById(R.id.spinner1)
        listSpinner2 = findViewById(R.id.spinner2)
        val nations = arrayOf(
            "Vietnam - VND",
            "China - Yuan",
            "Japan - Yen",
            "UK - Pound",
            "US - Dollar"
        )
        var adapter: ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,nations)
        listSpinner1.adapter = adapter
        listSpinner2.adapter = adapter
    }
}