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

//        @Query("Select * from entity order by id ASC")
//        fun get_all1(): LiveData<List<entity>>

    //Query for deletion of an item from the list
    @Delete
    suspend fun delete_task(input: sales_entity)
    //delete_single_item
    @Delete
    suspend fun delete_single_item(input: item)
    @Update
    suspend fun update_task(input: sales_entity)
}