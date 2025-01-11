package by.chernenko.domain.repository

import by.chernenko.domain.model.CartItemModel

interface CartRepository {
    suspend fun addCartItem(cartItem: CartItemModel)
    suspend fun deleteCartItem(cartItem: CartItemModel)
    suspend fun editCartItem(cartItem: CartItemModel)
    suspend fun deleteAllCartItems()
    suspend fun getAllCartItems(): List<CartItemModel>
}