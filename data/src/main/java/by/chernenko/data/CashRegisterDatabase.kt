package by.chernenko.data

import androidx.room.Database

@Database(entities = [CartEntity::class], version = 1)
abstract class CashRegisterDatabase {
    abstract fun cartDao(): CartDao
}