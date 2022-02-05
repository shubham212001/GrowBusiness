package com.sharma.growbusiness

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.search_purchase_item.view.*


class search_purchase_item_adapter(val list: List<puchase_item_entity>) : RecyclerView.Adapter<search_purchase_item_adapter.TodoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.search_purchase_item, parent, false)
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
        holder.itemView.setOnClickListener {

        }

    }



    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(todoModel: puchase_item_entity) {
            with(itemView) {
                SearchItemID.text = todoModel.Item_Id_purchase_item.toUpperCase()
                SearchItemPrice.text = todoModel.item_selling_price_purchase_item.toString().toUpperCase()
                SearchItemQTY.text = todoModel.No_of_purchase_purchase_item.toString().toUpperCase()

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
