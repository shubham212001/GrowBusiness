package com.sharma.growbusiness

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.search_recycler_item_view.view.*


class searchItemAdapter(val list: List<item>) : RecyclerView.Adapter<searchItemAdapter.TodoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.search_recycler_item_view, parent, false)
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
        fun bind(todoModel: item) {
            with(itemView) {
                SearchItemID.text = todoModel.Item_Id.toUpperCase()
                SearchItemName.text = todoModel.Customer_Id.toString().toUpperCase()
                SearchItemPrice.text = todoModel.No_of_purchase.toString().toUpperCase()

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

