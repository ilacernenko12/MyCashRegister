package by.chernenko.domain.usecase

import by.chernenko.domain.model.CartItemModel
import by.chernenko.domain.repository.CartRepository

class CartUseCase(private val repository: CartRepository) {

    suspend fun add(cartItem: CartItemModel) {
        repository.addCartItem(cartItem)
    }

    suspend fun delete(cartItem: CartItemModel) {
        repository.deleteCartItem(cartItem)
    }

    suspend fun edit(cartItem: CartItemModel) {
        repository.editCartItem(cartItem)
    }

    suspend fun deleteAll() {
        repository.deleteAllCartItems()
    }

    suspend fun getAll(): List<CartItemModel> {
        return repository.getAllCartItems()
    }
}