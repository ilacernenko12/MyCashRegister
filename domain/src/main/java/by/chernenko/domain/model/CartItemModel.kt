package by.chernenko.domain.model

data class CartItemModel(
    val id: Long = 0,
    val name: String? = null,
    val price: String,
    val quantity: Int,
    val discount: Int,
    val discountedPrice: String
)
