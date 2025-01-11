package by.chernenko.data.repository

import by.chernenko.data.mapper.cart.CartModelToEntityMapper
import by.chernenko.data.dao.CartDao
import by.chernenko.data.mapper.cart.CartEntityToDomainMapper
import by.chernenko.domain.model.CartItemModel
import by.chernenko.domain.repository.CartRepository

class CartRepositoryImpl (
    private val cartDao: CartDao
): CartRepository {
    override suspend fun addCartItem(cartItem: CartItemModel) {
        cartDao.insert(CartModelToEntityMapper.map(cartItem))
    }

    override suspend fun deleteCartItem(cartItem: CartItemModel) {
        cartDao.delete(CartModelToEntityMapper.map(cartItem))
    }

    override suspend fun editCartItem(cartItem: CartItemModel) {
        cartDao.update(CartModelToEntityMapper.map(cartItem))
    }

    override suspend fun deleteAllCartItems() {
        cartDao.deleteAll()
    }

    override suspend fun getAllCartItems(): List<CartItemModel> {
        return cartDao.getAll().map { entity ->
            CartEntityToDomainMapper.map(entity)
        }
    }
}