package com.sharma.growbusiness


import androidx.lifecycle.LiveData
import androidx.room.*
import java.util.logging.LogManager

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

    @Query("Select * from PurchaseItemsTable ")
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
//    @Delete
//    suspend fun delete_purchase_item(input: puchase_item_entity)
    @Delete
suspend fun delete_purchase_item(input:puchase_item_entity)

    @Update
    suspend fun update_task(input: sales_entity)

    @Insert
    suspend fun stock_add_item(input: stockEntity): Long

    @Query("Update StockTable set StockItemQTY=:input1 where StockItemID=:input2" )
    suspend fun stock_update(input1: String ,input2:String)

    @Query("Select * from  StockTable")
    fun stock_get_all_items():LiveData<List<stockEntity>>

    @Query("Select * from  StockTable where StockItemID=:input")
    fun stock_get_particular_item(input: String):stockEntity

    //If this thing returns null means it is the first time item being added
//    @Query("Select StockItemQTY from StockTable where StockItemID=:input")
//    suspend fun check_if_stock_already_in_database(input:String):List<stockStatusEntity>
//
//    //Query for inserting into stock table
//    @Insert
//    suspend fun InsertIntoStock()
//
//    //Query to get the just previous stock value for that particular item id
//    @Query("select StockItemQTY from StockTable where StockItemID=:input_item_id")
//    suspend fun get_previous_stock_value_for_updation_in_next_method_call_query(input_item_id:String)
//
//    //Query to update the record by using purchase items
//    @Query("Update StockTable set StockItemQTY=:quantity_to_be_added where StockItemID=:input_item_id")
//    suspend fun update_stock_after_purchasing(quantity_to_be_added:String,input_item_id:String)


}