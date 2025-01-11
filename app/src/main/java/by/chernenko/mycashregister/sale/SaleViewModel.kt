package by.chernenko.mycashregister.sale

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.chernenko.domain.model.CartItemModel
import by.chernenko.domain.usecase.CartUseCase
import by.chernenko.mycashregister.common.NumpadAction
import by.chernenko.mycashregister.launchIO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class SaleViewModel @Inject constructor(
    private val cartUseCase: CartUseCase
) : ViewModel() {
    private val _totalAmount = MutableStateFlow(0.0)
    val totalAmount: StateFlow<String> = _totalAmount
        .map { String.format(Locale.US, "%.2f", it).replace('.', ',') }
        .stateIn(viewModelScope, SharingStarted.Lazily, "0,00")

    private val _quantity = MutableStateFlow(0)
    val quantity: StateFlow<Int> = _quantity.asStateFlow()

    // TODO(отрефакторить как и totalAmount)
    private val _input = MutableStateFlow(INITIAL_VALUE)
    val input: StateFlow<String> = _input.asStateFlow()

    fun handleAction(action: NumpadAction) {
        when (action) {
            is NumpadAction.PressButton -> {
                when (action.button) {
                    "C" -> {
                        resetInput()
                    }

                    "В ЧЕК" -> {
                        addToReceipt()
                    }

                    else -> {
                        processInput(number = action.button)
                    }
                }
            }

            NumpadAction.PressClear -> {}
        }
    }

    private fun addToReceipt() {
        if (_input.value == INITIAL_VALUE) return

        val totalAmount = _totalAmount.value
        val inputAmount = _input.value.replace(',', '.').toDoubleOrNull() ?: 0.0

        _totalAmount.value = totalAmount + inputAmount

        incrementQuantity()
        addCartItemToDatabase(price = _input.value, quantity = _quantity.value) // т.к. кол-во инкрементится то и в бд записывается тоже
        resetInput()
    }

    private fun addCartItemToDatabase(price: String, quantity: Int) {
        viewModelScope.launchIO(coroutineName = "AddToCart", errorAction = { TODO() }) {
            cartUseCase.add(
                CartItemModel(
                    price = price,
                    quantity = quantity,
                    discount = 0,
                    discountedPrice = price
                )
            )
        }
    }

    private fun resetInput() {
        _input.value = INITIAL_VALUE
    }

    private fun incrementQuantity() {
        _quantity.value += 1
    }

    private fun processInput(number: String) {
        if (_input.value.length > MAX_INPUT_AMOUNT_LENGTH) return

        if (_input.value == "0,00") {
            _input.value = "0,0$number"
        } else {
            val currentValue = _input.value.replace(",", "")
            val newValue = "$currentValue$number"
            val formattedValue = formatValue(newValue)
            _input.value = formattedValue
        }
    }

    private fun formatValue(value: String): String {
        val newValue = if (value.startsWith("0")) {
            value.substring(1, value.length)
        } else {
            value
        }
        return if (newValue.length >= 4) {
            val beforeDecimal = value.substring(0, value.length - 2)
            val afterDecimal = value.substring(value.length - 2)
            "$beforeDecimal,$afterDecimal"
        } else {
            val formatted = newValue.substring(
                0,
                newValue.length - 2
            ) + "," + newValue.substring(newValue.length - 2)
            formatted
        }
    }

    private companion object {
        const val MAX_INPUT_AMOUNT_LENGTH = 8
        const val MAX_SHOW_AMOUNT_LENGTH = 8
        const val INITIAL_VALUE = "0,00"
    }
}
