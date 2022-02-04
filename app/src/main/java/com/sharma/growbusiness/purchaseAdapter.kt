package com.sharma.growbusiness

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.purchase_item_layout.view.*


class purchaseAdapter(val Purlist: List<purchase_entity>,val Listener:Purlistener) : RecyclerView.Adapter<purchaseAdapter.TodoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.purchase_item_layout, parent, false)
        )
    }

    override fun getItemCount() = Purlist.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(Purlist[position])
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
        fun bind(todoModel: purchase_entity) {
            with(itemView) {
                sale_nop.text = todoModel.PartyNamePur.toUpperCase()
                sale_id.text = todoModel.BillnoPur.toString().toUpperCase()
                salePrice.text = todoModel.PayAmtPur.toString().toUpperCase()
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

interface Purlistener {
    fun delete_purchase(input:purchase_entity)
    fun share(input:purchase_entity)
    fun update_task(input: purchase_entity)

}