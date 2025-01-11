package by.chernenko.data

import androidx.room.Database
import androidx.room.RoomDatabase
import by.chernenko.data.dao.CartDao
import by.chernenko.data.entity.CartItemEntity

@Database(
    entities = [CartItemEntity::class],
    version = 1
)
abstract class CashRegisterDatabase: RoomDatabase() {
    abstract fun cartDao(): CartDao
}