package by.chernenko.mycashregister.di

import by.chernenko.domain.repository.CartRepository
import by.chernenko.domain.usecase.CartUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun bindCartUseCase(cartRepository: CartRepository): CartUseCase {
        return CartUseCase(cartRepository)
    }
}