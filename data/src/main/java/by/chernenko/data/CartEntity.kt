package by.chernenko.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CART")
data class CartEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "goods_name")
    val goodsName:String? = null,
    @ColumnInfo(name = "price")
    val price: Long,
    @ColumnInfo(name = "quantity")
    val quantity: Int,
    @ColumnInfo(name = "discount")
    val discount: Int,
    @ColumnInfo(name = "discounted_price")
    val discountedPrice: Long
)
