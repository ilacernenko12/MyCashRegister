package by.chernenko.mycashregister.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import by.chernenko.mycashregister.ui.theme.Ultramarine
import by.chernenko.mycashregister.ui.theme.White


@Composable
fun TotalAmountView(
    amount: String,
    quantity: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Ultramarine)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "К оплате:",
            color = White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 90.dp, end = 90.dp, top = 10.dp)

        )
        Text(
            text = "$amount BYN",
            color = White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.wrapContentSize()
        )

        Text(
            text = "Позиций: $quantity",
            color = White,
            fontSize = 26.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier
                .padding(top = 6.dp, bottom = 10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TotalAmountViewPreview() {
    TotalAmountView(
        amount = "220222",
        quantity = 4
    ) {

    }
}