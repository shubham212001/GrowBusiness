package com.sharma.growbusiness

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SalesTable")
public class sales_entity(
    val PartyName:String,
    val Billno:String,
    val PayAmt:Int

){
    @PrimaryKey(autoGenerate = true)
    var EntryId=0

}
