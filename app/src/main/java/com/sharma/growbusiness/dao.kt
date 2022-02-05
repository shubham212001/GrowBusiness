package com.sharma.growbusiness


import androidx.lifecycle.LiveData
import androidx.room.*
@Dao
public interface dao {

    @Insert
    suspend fun add_sales(input: sales_entity): Long

    @Insert
    suspend fun add_item(input: item): Long
    @Insert
    suspend fun add_purchase(input: purchase_entity): Long

    @Insert
    suspend fun add_purchase_item(input: puchase_item_entity): Long

    @Query("Select * from SalesTable order by Billno DESC")
    fun get_all(): LiveData<List<sales_entity>>

    @Query("Select * from itemstable order by Item_Id DESC")
    fun get_all_item(): LiveData<List<item>>

    @Query("Select * from PurchaseTable order by EntryIdPur DESC")
    fun get_all_purchase(): LiveData<List<purchase_entity>>

    @Query("Select * from PurchaseItemsTable order by Entry_no_purchase_item DESC")
    fun get_all_purchase_items(): LiveData<List<puchase_item_entity>>

    //get_search_sale_item
    @Query("Select * from ItemsTable where bill_no=:input ")
    fun get_search_sale_item(input:String): LiveData<List<item>>

//    @Query("Select * from PurchaseItemsTable where bill_no_purchase_item=:input ")
//    fun get_search_purchase_item(input:String): LiveData<List<purchase_entity>>

//        @Query("Select * from entity order by id ASC")
//        fun get_all1(): LiveData<List<entity>>

    @Query("Select * from PurchaseItemsTable where bill_no_purchase_item=:input ")
    fun get_purchase_sale_item(input:String): LiveData<List<puchase_item_entity>>
    //Query for deletion of an item from the list

    @Query("Select Customer_Name_purchase_item from PurchaseItemsTable where bill_no_purchase_item=:input ")
    fun get_purchase_customer_name(input:String):String

    @Query("Select Customer_Id_purchase_item from PurchaseItemsTable where bill_no_purchase_item=:input ")
    fun get_purchase_customer_id(input:String):String

    //get_sale_customer_name
    @Query("Select Customer_Name from ItemsTable where bill_no=:input ")
    fun get_sale_customer_name(input:String):String

    @Query("Select Customer_Id from ItemsTable where bill_no=:input ")
    fun get_sale_customer_id(input:String):String
    @Delete
    suspend fun delete_task(input: sales_entity)
    //delete_single_item
    @Delete
    suspend fun delete_single_item(input: item)
    @Update
    suspend fun update_task(input: sales_entity)
}