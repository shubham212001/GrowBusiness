package com.sharma.growbusiness

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.add_sales_item_in_recyclerview.view.*

import java.text.SimpleDateFormat
import java.util.*

class add_sales_item_recycler_adapter(val list: List<item>) : RecyclerView.Adapter<add_sales_item_recycler_adapter.TodoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.add_sales_item_in_recyclerview, parent, false)
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

    }



    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(todoModel: item) {
            with(itemView) {
                show_item_id.text = todoModel.Item_Id.toUpperCase()
                show_item_qty.text = todoModel.No_of_purchase.toString().toUpperCase()
                show_item_price.text = todoModel.item_selling_price.toString().toUpperCase()
//                user_date.text = todoModel.date
//                user_time.text = todoModel.time

            }
        }
//        private fun updateTime(time: Long) {
//            //Mon, 5 Jan 2020
//            val myformat = "h:mm a"
//            val sdf = SimpleDateFormat(myformat)
//            itemView.user_time.text = sdf.format(Date(time))
//
//        }

//        private fun updateDate(time: Long) {
//            //Mon, 5 Jan 2020
//            val myformat = "EEE, d MMM yyyy"
//            val sdf = SimpleDateFormat(myformat)
//            itemView.user_date.text = sdf.format(Date(time))
//
//        }
    }

}