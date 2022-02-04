package com.sharma.growbusiness

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_add_purchase.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//To be corrected in the next step
const val Db_NAME = "todo.db"
class Add_PurchaseActivity : AppCompatActivity(),purchase_item_listener {
    var Pay_variable = 0
    val db by lazy {
        task_database.getDatabase(this)
    }
    val list_item = arrayListOf<puchase_item_entity>()
    //val list_item2 = arrayListOf<purchase_entity>()
    var adapter = add_purchase_item_recycler_adapter(list_item, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_purchase)
        supportActionBar?.hide()
        var pay_variable=0;

        val db by lazy {
            task_database.getDatabase(this)
        }

        save_purchase_bill.setOnClickListener {
            var bill_no_variable = bill_no.text.toString()
            var cust_name_variable = cust_name.text.toString()
            var item_qty_variable = nop.text.toString()
            var item_price_variable = item_price.text.toString()

            if (bill_no_variable.length != 0 && cust_name_variable.length != 0 ) {

                GlobalScope.launch(Dispatchers.Main) {
                    val id = withContext(Dispatchers.IO) {
                        return@withContext db.todoDao().add_purchase(
                                purchase_entity(
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
        var item_qty_variable = nop.text.toString()
        var item_price_variable = item_price.text.toString()
        var collective_item_data = item(bill_no_variable, item_id_variable, customer_ID_variable, cust_name_variable, item_qty_variable, item_price_variable)




        add_item_in_purchase.setOnClickListener {

            var bill_no_variable = bill_no.text.toString()
            var customer_ID_variable = customer_id.text.toString()
            var cust_name_variable = cust_name.text.toString()
            var item_id_variable = item_id.text.toString()
            var item_qty_variable = nop.text.toString()
            var item_price_variable = item_price.text.toString()
            var collective_item_data = puchase_item_entity(bill_no_variable, item_id_variable, customer_ID_variable, cust_name_variable, item_qty_variable, item_price_variable)
            if (!item_price_variable.isNullOrEmpty() && !item_qty_variable.isNullOrEmpty()) {
                var amt = Integer.parseInt(item_price_variable)
                var qty = Integer.parseInt(item_qty_variable)
            }
            var temp1 = Integer.parseInt(item_qty_variable)
            var temp2 = Integer.parseInt(item_price_variable)
            pay_variable += temp1 * temp2

            if (bill_no_variable.length != 0 && cust_name_variable.length != 0 && customer_ID_variable.length != 0
                    && item_id_variable.length != 0
                    && item_qty_variable.length != 0
                    && item_price_variable.length != 0
            ) {

                GlobalScope.launch(Dispatchers.Main) {
                    val id = withContext(Dispatchers.IO) {
                        return@withContext db.todoDao().add_purchase_item(
                                puchase_item_entity(
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
                Toast.makeText(this, "Item Saved", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Fields Can't be empty", Toast.LENGTH_LONG).show()
            }
            list_item.add(collective_item_data)
            //PayAmt_variable += amt * qty
            add_item_in_purchase_recyclerview.layoutManager = LinearLayoutManager(this)
            var Adapter = add_item_in_purchase_recyclerview.adapter
            add_item_in_purchase_recyclerview.adapter = adapter
            item_id.setText("")
            item_name.setText("")
            nop.setText("")
            item_price.setText("")
            total_amt.setText("" + pay_variable)
        }

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