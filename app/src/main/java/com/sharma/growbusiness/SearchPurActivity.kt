package com.sharma.growbusiness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_search_pur.*

class SearchPurActivity : AppCompatActivity() {
    val db by lazy {
        task_database.getDatabase(this)
    }
    val list = arrayListOf<puchase_item_entity>()
    var adapter =search_purchase_item_adapter(list)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_pur)
        supportActionBar?.hide()
        SearchBtn.setOnClickListener {
            var temp=searchInput.text.toString()
            search_recycler.layoutManager= LinearLayoutManager(this)
            var Adapter =search_recycler.adapter
            search_recycler.adapter=adapter

            db.todoDao().get_purchase_sale_item(temp).observe(this, Observer {

                list.clear()
                list.addAll(it)
                adapter.notifyDataSetChanged()


            })
        }



    }
}