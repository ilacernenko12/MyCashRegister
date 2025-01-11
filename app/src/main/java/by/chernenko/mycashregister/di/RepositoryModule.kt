package by.chernenko.mycashregister.di

import by.chernenko.data.dao.CartDao
import by.chernenko.data.repository.CartRepositoryImpl
import by.chernenko.domain.repository.CartRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCartRepository(cartDao: CartDao): CartRepository {
        return CartRepositoryImpl(cartDao)
    }
}