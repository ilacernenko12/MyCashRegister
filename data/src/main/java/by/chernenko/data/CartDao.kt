package by.chernenko.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CartDao {

    @Insert
    suspend fun insert(cartEntity: CartEntity)

    @Delete
    suspend fun delete(cartEntity: CartEntity)

    @Update
    suspend fun update(cartEntity: CartEntity)

    @Query("SELECT * FROM CART")
    suspend fun getAll(): List<CartEntity>

    @Query("DELETE FROM CART")
    suspend fun deleteAll()
}