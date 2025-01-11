package by.chernenko.data.mapper.cart

import by.chernenko.data.entity.CartItemEntity
import by.chernenko.data.mapper.BaseMapper
import by.chernenko.domain.model.CartItemModel
import by.chernenko.domain.utils.toEmvAmount

object CartModelToEntityMapper: BaseMapper<CartItemModel, CartItemEntity> {
    override fun map(from: CartItemModel): CartItemEntity {
        return CartItemEntity(
            id = from.id,
            name = from.name,
            price = from.price.toEmvAmount(),
            quantity = from.quantity,
            discount = from.discount,
            discountedPrice = from.discountedPrice.toEmvAmount()
        )
    }
}
