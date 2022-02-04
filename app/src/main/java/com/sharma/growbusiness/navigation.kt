package com.sharma.growbusiness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_navigation.*

class navigation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        supportActionBar?.hide()
        add_sales_text_view.setOnClickListener{

            val intent= Intent(this,AddSalesActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}