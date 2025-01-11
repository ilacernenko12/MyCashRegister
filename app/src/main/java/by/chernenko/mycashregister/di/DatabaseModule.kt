package by.chernenko.mycashregister.di

import android.content.Context
import androidx.room.Room
import by.chernenko.data.dao.CartDao
import by.chernenko.data.CashRegisterDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): CashRegisterDatabase {
        return Room
            .databaseBuilder(
                context = context,
                klass = CashRegisterDatabase::class.java,
                name = "CASH_REGISTER"
            )
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    fun provideCartDao(database: CashRegisterDatabase): CartDao = database.cartDao()
}