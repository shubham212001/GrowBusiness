package com.sharma.growbusiness

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.sales_item.view.*

class sales_adapter(val list: List<sales_entity>,val Listener:listener) : RecyclerView.Adapter<sales_adapter.TodoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.sales_item, parent, false)
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
        fun bind(todoModel: sales_entity) {
            with(itemView) {
                sale_nop.text = todoModel.PartyName.toUpperCase()
                sale_id.text = todoModel.Billno.toString().toUpperCase()
                salePrice.text = todoModel.PayAmt.toString().toUpperCase()
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

interface listener {
    fun delete_task(input:sales_entity)
    fun share(input:sales_entity)
    fun update_task(input: sales_entity)

}