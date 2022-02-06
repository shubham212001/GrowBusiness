package com.sharma.growbusiness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_dash_board.*
import kotlinx.android.synthetic.main.activity_stock.*

class StockActivity : AppCompatActivity(),stock_listner {
    val db by lazy {
    task_database.getDatabase(this)
}
    val list = arrayListOf<stockEntity>()
    var adapter = adapter_stock(list,this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stock)
        supportActionBar?.hide()
        stock_recycler.layoutManager= LinearLayoutManager(this)
        var Adapter =stock_recycler.adapter
        stock_recycler.adapter=adapter
        var Stockpref = applicationContext.getSharedPreferences("StockPref", MODE_PRIVATE)
        var editor = Stockpref.edit()
        var all_shared_pref=Stockpref.all


        db.todoDao().stock_get_all_items().observe(this, Observer {

            list.clear()
            //list.addAll(it)
            for(temp_iterateOverSharedPref in all_shared_pref){
                var temp_a=temp_iterateOverSharedPref.value.toString()
                list.add(stockEntity(temp_iterateOverSharedPref.key,temp_a))
            }
            adapter.notifyDataSetChanged()


        })

    }

    override fun delete_purchase_item(input: puchase_item_entity) {
        TODO("Not yet implemented")
    }

    override fun share(input: sales_entity) {
        TODO("Not yet implemented")
    }

    override fun update_task(input: sales_entity) {
        TODO("Not yet implemented")
    }
}