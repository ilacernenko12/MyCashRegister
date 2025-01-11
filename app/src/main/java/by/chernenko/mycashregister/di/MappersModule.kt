package by.chernenko.mycashregister.di

import by.chernenko.data.entity.CartItemEntity
import by.chernenko.data.mapper.BaseMapper
import by.chernenko.data.mapper.cart.CartEntityToDomainMapper
import by.chernenko.data.mapper.cart.CartModelToEntityMapper
import by.chernenko.domain.model.CartItemModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MappersModule {

    /*@Provides
    @Singleton
    fun provideCartEntityToModelMapper(): BaseMapper<CartItemEntity, CartItemModel> {
        return CartEntityToDomainMapper
    }

    @Provides
    @Singleton
    fun provideCartModelToEntityMapper(): BaseMapper<CartItemModel, CartItemEntity> {
        return CartModelToEntityMapper
    }*/
}