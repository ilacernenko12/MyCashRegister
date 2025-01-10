package by.chernenko.mycashregister.sale

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import by.chernenko.mycashregister.common.InputAmountView
import by.chernenko.mycashregister.common.NumPad
import by.chernenko.mycashregister.common.NumpadAction
import by.chernenko.mycashregister.common.TotalAmountView

@Composable
fun SaleScreen(viewModel: SaleViewModel = viewModel()) {

    val input by viewModel.input.collectAsState()
    val totalAmount by viewModel.totalAmount.collectAsState()
    val quantity by viewModel.quantity.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TotalAmountView(
            amount = totalAmount,
            quantity = quantity,
            onClick = { }
        )
        Spacer(modifier = Modifier.padding(12.dp))
        InputAmountView(input)
        Spacer(modifier = Modifier.padding(12.dp))

        NumPad(
            onClick = { button ->
                viewModel.handleAction(NumpadAction.PressButton(button))
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SaleScreenPreview() {
    SaleScreen()
}