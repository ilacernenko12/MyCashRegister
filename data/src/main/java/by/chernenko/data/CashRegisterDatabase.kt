package by.chernenko.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CartEntity::class],
    version = 1
)
abstract class CashRegisterDatabase: RoomDatabase() {
    abstract fun cartDao(): CartDao
}