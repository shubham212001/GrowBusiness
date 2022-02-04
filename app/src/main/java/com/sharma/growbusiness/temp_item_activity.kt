package com.sharma.growbusiness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class temp_item_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temp_item_activity)
        supportActionBar?.hide()
    }
}