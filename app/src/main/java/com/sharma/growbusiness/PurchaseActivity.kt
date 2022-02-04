package com.sharma.growbusiness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_dash_board.*
import kotlinx.android.synthetic.main.activity_purchase.*
import kotlinx.android.synthetic.main.activity_purchase.add_purchase_button
import kotlinx.android.synthetic.main.activity_purchase.purchase_recycler

class PurchaseActivity : AppCompatActivity(),Purlistener {
    val db by lazy {
        task_database.getDatabase(this)
    }
    val list = arrayListOf<purchase_entity>()
    var adapter = purchaseAdapter(list,this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase)
        supportActionBar?.hide()
        add_purchase_button.setOnClickListener {
            val intent =Intent(this,Add_PurchaseActivity::class.java)
            startActivity(intent)
        }
        purchase_recycler.layoutManager= LinearLayoutManager(this)
        var Adapter =purchase_recycler.adapter
        purchase_recycler.adapter=adapter

        db.todoDao().get_all_purchase().observe(this, Observer {

            list.clear()
            list.addAll(it)
            adapter.notifyDataSetChanged()


        })

    }

    override fun delete_purchase(input: purchase_entity) {
        TODO("Not yet implemented")
    }

    override fun share(input: purchase_entity) {
        TODO("Not yet implemented")
    }

    override fun update_task(input: purchase_entity) {
        TODO("Not yet implemented")
    }
}