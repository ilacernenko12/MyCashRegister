package by.chernenko.mycashregister.common

import kotlinx.serialization.Serializable

@Serializable
data class GoodsItemUi(
    val name: String? = null,
    val description: String? = null,
    val amount: Double,
    val quantity: Int
)
