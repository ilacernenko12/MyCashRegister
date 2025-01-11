package by.chernenko.data.mapper.cart

import by.chernenko.data.entity.CartItemEntity
import by.chernenko.data.mapper.BaseMapper
import by.chernenko.domain.model.CartItemModel
import by.chernenko.domain.utils.fromEmvAmount
import javax.inject.Singleton

@Singleton
object CartEntityToDomainMapper: BaseMapper<CartItemEntity, CartItemModel> {
    override fun map(from: CartItemEntity): CartItemModel {
        return CartItemModel(
            id = from.id,
            name = from.name,
            price = from.price.fromEmvAmount(withComma = true),
            quantity = from.quantity,
            discount = from.discount,
            discountedPrice = from.discountedPrice.fromEmvAmount(withComma = true)
        )
    }
}