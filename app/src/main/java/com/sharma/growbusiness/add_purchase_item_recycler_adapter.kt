package com.sharma.growbusiness

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.add_purchase_item_in_recyclerview.view.*

class add_purchase_item_recycler_adapter(val list: List<puchase_item_entity>,val PurItemListener:purchase_item_listener) : RecyclerView.Adapter<add_purchase_item_recycler_adapter.TodoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.add_purchase_item_in_recyclerview, parent, false)
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
        holder.itemView.del_item_button_purchase.setOnClickListener {
            PurItemListener.delete_purchase_item(list[position])
        }

    }



    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(todoModel: puchase_item_entity) {
            with(itemView) {
                show_item_id.text = todoModel.Item_Id_purchase_item.toUpperCase()
                show_item_qty.text = todoModel.No_of_purchase_purchase_item.toString().toUpperCase()
                show_item_price.text = todoModel.item_selling_price_purchase_item.toString().toUpperCase()
//                user_date.text = todoModel.date
//                user_time.text = todoModel.time

            }
        }
//
    }

}
interface purchase_item_listener {
    fun delete_purchase_item(input:puchase_item_entity)
    fun share(input:sales_entity)
    fun update_task(input: sales_entity)

}