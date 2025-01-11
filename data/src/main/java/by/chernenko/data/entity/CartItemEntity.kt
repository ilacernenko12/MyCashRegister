package by.chernenko.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CART")
data class CartItemEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "name")
    val name:String? = null,
    @ColumnInfo(name = "price")
    val price: String,
    @ColumnInfo(name = "quantity")
    val quantity: Int,
    @ColumnInfo(name = "discount")
    val discount: Int,
    @ColumnInfo(name = "discounted_price")
    val discountedPrice: String
)
