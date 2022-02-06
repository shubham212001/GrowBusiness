package com.sharma.growbusiness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_add_sales.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.abs

const val DB_NAME = "todo.db"
class AddSalesActivity : AppCompatActivity(),item_listener {
    var Pay_variable=0
    val db by lazy {
        task_database.getDatabase(this)
    }
    val list_item = arrayListOf<item>()
    var adapter = add_sales_item_recycler_adapter(list_item,this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_sales)
        supportActionBar?.hide()
        var pay_variable=0;

        val db by lazy {
            task_database.getDatabase(this)
        }
        var stock_pref = applicationContext.getSharedPreferences("StockPref", MODE_PRIVATE)
        var editor2 = stock_pref.edit()
        save_purchase_bill.setOnClickListener {
            var bill_no_variable = bill_no.text.toString()
            var cust_name_variable = cust_name.text.toString()
            var item_qty_variable = gstin.text.toString()
            var item_price_variable = item_price.text.toString()

            if (bill_no_variable.length != 0 && cust_name_variable.length != 0 ) {

                GlobalScope.launch(Dispatchers.Main) {
                    val id = withContext(Dispatchers.IO) {
                        return@withContext db.todoDao().add_sales(
                                sales_entity(
                                        bill_no_variable,
                                        cust_name_variable,
                                        pay_variable
                                )
                        )
                    }
                    finish()
                }
            }
            else {
                Toast.makeText(this,"Fields Can't be empty", Toast.LENGTH_LONG).show()
            }
        }

        var bill_no_variable = bill_no.text.toString()
        var customer_ID_variable = customer_id.text.toString()
        var cust_name_variable = cust_name.text.toString()
        var item_id_variable = item_id.text.toString()
        var item_qty_variable = gstin.text.toString()
        var item_price_variable = item_price.text.toString()
        var collective_item_data = item(bill_no_variable, item_id_variable, customer_ID_variable, cust_name_variable, item_qty_variable, item_price_variable)




        add_item_in_purchase.setOnClickListener {

            var bill_no_variable = bill_no.text.toString()
            var customer_ID_variable = customer_id.text.toString()
            var cust_name_variable = cust_name.text.toString()
            var item_id_variable = item_id.text.toString()
            var item_qty_variable = gstin.text.toString()
            var item_price_variable = item_price.text.toString()
            var collective_item_data = item(bill_no_variable, item_id_variable, customer_ID_variable, cust_name_variable, item_qty_variable, item_price_variable)
            if(!item_price_variable.isNullOrEmpty() && !item_qty_variable.isNullOrEmpty()){
                var amt = Integer.parseInt(item_price_variable)
                var qty = Integer.parseInt(item_qty_variable)
            }
            var temp1=Integer.parseInt(item_qty_variable)
            var temp2=Integer.parseInt(item_price_variable)
            pay_variable+=temp1*temp2

            if (bill_no_variable.length != 0 && cust_name_variable.length != 0 && customer_ID_variable.length!=0
                    && item_id_variable.length != 0
                    && item_qty_variable.length != 0
                    && item_price_variable.length != 0
            ) {

                GlobalScope.launch(Dispatchers.Main) {
                    val id = withContext(Dispatchers.IO) {
                        return@withContext db.todoDao().add_item(
                                item(
                                        bill_no_variable,
                                        item_id_variable,
                                        customer_ID_variable,
                                        cust_name_variable,
                                        item_qty_variable,
                                        item_price_variable
                                )
                        )
                    }

                }
                Toast.makeText(this,"Item Saved", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(this,"Fields Can't be empty", Toast.LENGTH_LONG).show()
            }
            list_item.add(collective_item_data)
            //PayAmt_variable += amt * qty
            add_item_in_purchase_recyclerview.layoutManager = LinearLayoutManager(this)
            var Adapter = add_item_in_purchase_recyclerview.adapter
            add_item_in_purchase_recyclerview.adapter = adapter
            item_id.setText("")
            item_name.setText("")
            gstin.setText("")
            item_price.setText("")
            total_amt.setText(""+pay_variable)


            //Code for stock updation
            var prev_value=stock_pref.getString(item_id_variable,"0")
            var prev_value_converison=Integer.parseInt(prev_value)
            val final_pass_variable:Int= abs(prev_value_converison-Integer.parseInt(item_qty_variable))
            var finalPassValueInString=final_pass_variable.toString()
            stock_pref.edit().remove(item_id_variable).commit();
            editor2.putString(item_id_variable,finalPassValueInString)
            editor2.apply()
            Toast.makeText(this, "Stock Updated", Toast.LENGTH_SHORT).show()
        }
    }

    override fun delete_task(input: item) {
        GlobalScope.launch(Dispatchers.Main) {
            GlobalScope.launch(Dispatchers.Main) {
                db.todoDao().delete_single_item(input)


                db.todoDao().get_all_item().observe(this@AddSalesActivity, Observer {

                    list_item.clear()
                    list_item.addAll(it)
                    adapter.notifyDataSetChanged()


                })

            }
        }



    }

    override fun share(input: sales_entity) {
        TODO("Not yet implemented")
    }

    override fun update_task(input: sales_entity) {
        TODO("Not yet implemented")
    }
}