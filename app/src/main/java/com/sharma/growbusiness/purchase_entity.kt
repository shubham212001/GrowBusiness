package com.sharma.growbusiness

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PurchaseTable")
public class purchase_entity(
    val PartyNamePur:String,
    val BillnoPur:String,
    val PayAmtPur:Int

){
    @PrimaryKey(autoGenerate = true)
    var EntryIdPur=0

}
