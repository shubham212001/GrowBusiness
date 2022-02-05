package com.sharma.growbusiness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_purchase.*
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.activity_search.SearchBtn
import kotlinx.android.synthetic.main.activity_search.searchInput
import kotlinx.android.synthetic.main.activity_search.search_recycler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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

            db.todoDao().get_search_sale_item(temp).observe(this, Observer {

                list.clear()
                list.addAll(it)
                adapter.notifyDataSetChanged()


            })

            GlobalScope.launch {
                var cust_name_received=db.todoDao().get_sale_customer_name(temp)
                customer_name_shower_sale.setText(""+cust_name_received)
            }

            GlobalScope.launch {
                var cust_id_received=db.todoDao().get_sale_customer_id(temp)
                customer_id_shower_sale.setText(""+cust_id_received)
            }
        }
    }
}