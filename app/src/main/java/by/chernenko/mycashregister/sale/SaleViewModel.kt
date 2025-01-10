package by.chernenko.mycashregister.sale

import androidx.lifecycle.ViewModel
import by.chernenko.mycashregister.common.NumpadAction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class SaleViewModel : ViewModel() {
    private val _totalAmount = MutableStateFlow("0,00")
    val totalAmount: StateFlow<String> = _totalAmount.asStateFlow()

    private val _quantity = MutableStateFlow(0)
    val quantity: StateFlow<Int> = _quantity.asStateFlow()

    private val _input = MutableStateFlow("0,00")
    val input: StateFlow<String> = _input.asStateFlow()

    fun handleAction(action: NumpadAction) {
        when (action) {
            is NumpadAction.PressButton -> {
                when (action.button) {
                    "C" -> { resetInput() }
                    "В ЧЕК" -> { addToReceipt() }
                    else -> { processInput(number = action.button) }
                }
            }
        }
    }

    private fun resetInput() {
        _input.value = "0,00"
    }

    private fun addToReceipt() {
        if (_input.value == "0,00") return

        if (_totalAmount.value == "0,00") {
            _totalAmount.value = _input.value
        } else {
            val doubleTotal = _totalAmount.value.replace(',', '.').toDouble()
            val doubleInput = _input.value.replace(',', '.').toDouble()
            _totalAmount.value = String.format("%.2f", doubleTotal + doubleInput).replace('.', ',')
        }
        _quantity.value += 1
        _input.value = "0,00"
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
            val formatted = newValue.substring(0, newValue.length - 2) + "," + newValue.substring(newValue.length - 2)
            formatted
        }
    }

    companion object {
        const val MAX_INPUT_AMOUNT_LENGTH = 8
        const val MAX_SHOW_AMOUNT_LENGTH = 8
    }
}