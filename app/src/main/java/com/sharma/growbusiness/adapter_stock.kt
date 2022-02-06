package com.sharma.growbusiness

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.stock_recycler_item_layout.view.*

class adapter_stock(val list: List<stockEntity>, val StockListener:stock_listner) : RecyclerView.Adapter<adapter_stock.TodoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.stock_recycler_item_layout, parent, false)
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(list[position])
//        holder.itemView.delete.setOnClickListener {
//            Listener.delete_task(list[position])
//        }
//        holder.itemView.share.setOnClickListener {
//            Listener.share(list[position])
//        }
//        holder.itemView.edit.setOnClickListener {
//            Listener.update_task(list[position])
//        }
//        holder.itemView.del_item_button_purchase.setOnClickListener {
//            PurItemListener.delete_purchase_item(list[position])
//        }

    }



    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(todoModel: stockEntity) {
            with(itemView) {
                item_id_stock.text = todoModel.StockItemID.toUpperCase()
                //item_name_stock.text = todoModel.StockItemName.toString().toUpperCase()
                item_available_stock.text = todoModel.StockItemQTY.toString().toUpperCase()
//                user_date.text = todoModel.date
//                user_time.text = todoModel.time

            }
        }
//
    }

}
interface stock_listner {
    fun delete_purchase_item(input:puchase_item_entity)
    fun share(input:sales_entity)
    fun update_task(input: sales_entity)

}