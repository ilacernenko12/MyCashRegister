package by.chernenko.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import by.chernenko.data.entity.CartItemEntity

@Dao
interface CartDao {

    @Insert
    suspend fun insert(cartItemEntity: CartItemEntity)

    @Delete
    suspend fun delete(cartItemEntity: CartItemEntity)

    @Update
    suspend fun update(cartItemEntity: CartItemEntity)

    @Query("SELECT * FROM CART")
    suspend fun getAll(): List<CartItemEntity>

    @Query("DELETE FROM CART")
    suspend fun deleteAll()
}