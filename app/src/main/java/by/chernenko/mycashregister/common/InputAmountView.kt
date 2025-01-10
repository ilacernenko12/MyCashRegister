package by.chernenko.mycashregister.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InputAmountView(input: String){
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 10.dp)

    ) {
        Text(
            text = input,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = " BYN",
            fontSize = 24.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Medium
        )
    }
}