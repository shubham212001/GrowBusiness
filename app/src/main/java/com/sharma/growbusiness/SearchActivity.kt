package com.sharma.growbusiness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_purchase.*
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SearchActivity : AppCompatActivity(),Search_item_Listener {
    val db by lazy {
        task_database.getDatabase(this)
    }
    val list = arrayListOf<item>()
    var adapter = searchItemAdapter(list,this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        supportActionBar?.hide()
        SearchBtn.setOnClickListener {
                var temp=bill_no_input.text.toString()
                if(temp.length!=0) {

                search_recycler.layoutManager = LinearLayoutManager(this)
                var Adapter = search_recycler.adapter
                search_recycler.adapter = adapter
                db.todoDao().get_search_sale_item().observe(this, Observer {

                    list.clear()
                    list.addAll(it)
                    adapter.notifyDataSetChanged()


                })

                GlobalScope.launch (Dispatchers.IO){
                    var cust_id_from_dao_function = db.todoDao().getCustomerID(temp)
                    search_customer_id.setText("" + cust_id_from_dao_function)
                    var cust_name_from_dao_function = db.todoDao().getCustomerName(temp)
                    SearchCustomerName.setText("" + cust_name_from_dao_function)
                }

            }else {
                    Toast.makeText(this, "Enter Bill No", Toast.LENGTH_SHORT).show()
                }
        }
    }

    override fun delete_search(input: String) {
        TODO("Not yet implemented")
    }
}