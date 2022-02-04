package com.sharma.growbusiness

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PurchaseItemsTable")
data class puchase_item_entity (
        val bill_no_purchase_item:String,
        val Item_Id_purchase_item:String,
        val Customer_Id_purchase_item:String,
        val Customer_Name_purchase_item:String,
        val No_of_purchase_purchase_item:String,
        val item_selling_price_purchase_item:String   ){
    //Leaving the empty body
    @PrimaryKey(autoGenerate = true)
    var Entry_no_purchase_item:Int=0

}