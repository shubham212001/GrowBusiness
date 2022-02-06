package com.sharma.growbusiness

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "StockTable")
data class stockEntity (
        val StockItemID:String,
        val StockItemQTY:String
        )
{
    //Leaving the empty body
    @PrimaryKey(autoGenerate = true)
    var StockID:Int=0

}