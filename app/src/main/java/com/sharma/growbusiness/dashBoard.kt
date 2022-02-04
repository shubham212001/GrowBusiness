package com.sharma.growbusiness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_dash_board.*

open class dashBoard : AppCompatActivity(),listener {

    val db by lazy {
        task_database.getDatabase(this)
    }
    val list = arrayListOf<sales_entity>()
    var adapter = sales_adapter(list,this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        supportActionBar?.hide()
        var pref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        var editor = pref.edit()
        val data1 = pref.getString("ToCollect", null)
        tocollect.setText(data1)

        val data2 = pref.getString("ToPay", null)
        topay.setText(data2)
        val data3 = pref.getString("CompanyName", null)
        //dashboard.setText(data3)


        sales_recycler.layoutManager= LinearLayoutManager(this)
        var Adapter =sales_recycler.adapter
        sales_recycler.adapter=adapter

        db.todoDao().get_all().observe(this, Observer {

            list.clear()
            list.addAll(it)
            adapter.notifyDataSetChanged()


        })


add_sale_button.setOnClickListener {
    val intent=Intent(this,AddSalesActivity::class.java)
    startActivity(intent)
}







        saveChanges.setOnClickListener {
            var temp1: String = tocollect.text.toString()
            var temp2: String = topay.text.toString()

            editor.putString("ToCollect", temp1);
            editor.putString("ToPay", temp2);
            editor.apply();
            Toast.makeText(
                applicationContext,
                "To Collect and To Pay Data Saved",
                Toast.LENGTH_SHORT
            ).show()
        }
create_newButton.setOnClickListener {
    val intent=Intent(this,navigation::class.java)
    startActivity(intent)
}

    }

    override fun delete_task(input: sales_entity) {
        TODO("Not yet implemented")
    }

    override fun share(input: sales_entity) {
        TODO("Not yet implemented")
    }

    override fun update_task(input: sales_entity) {
        TODO("Not yet implemented")
    }
}