package by.chernenko.mycashregister.sale

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import by.chernenko.mycashregister.ui.theme.Red

@Composable
fun SaleScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Red) // Устанавливаем красный фон
    ) {
        Text("test text")
    }
}