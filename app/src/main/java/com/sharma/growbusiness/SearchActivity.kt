package com.sharma.growbusiness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_purchase.*
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {
    val db by lazy {
        task_database.getDatabase(this)
    }
    val list = arrayListOf<item>()
    var adapter = searchItemAdapter(list)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        supportActionBar?.hide()
        SearchBtn.setOnClickListener {
var temp=searchInput.text.toString()
            search_recycler.layoutManager= LinearLayoutManager(this)
            var Adapter =search_recycler.adapter
            search_recycler.adapter=adapter

            db.todoDao().get_search_sale_item().observe(this, Observer {

                list.clear()
                list.addAll(it)
                adapter.notifyDataSetChanged()


            })
        }
    }
}