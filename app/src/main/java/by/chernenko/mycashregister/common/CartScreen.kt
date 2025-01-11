@file:OptIn(ExperimentalMaterial3Api::class)

package by.chernenko.mycashregister.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import by.chernenko.mycashregister.ui.theme.Ultramarine

@Composable
fun CartScreen(goodsItemUis: List<GoodsItemUi>) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 56.dp)
        ) {
            TableHeader()

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(goodsItemUis.size) { index: Int ->
                    CartItem(
                        goodsItemUi = goodsItemUis[index],
                        index = index + 1
                    )
                }
            }
        }

        Button(
            onClick = { /* Ваш код для кнопки */ },
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Ultramarine
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .align(Alignment.BottomCenter)
        ) {
            Row {
                Text(
                    text = "Итого к оплате: ",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = "${String.format("%.2f", goodsItemUis.sumOf { it.amount * it.quantity })} BYN",
                    fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun TableHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(start = 10.dp, end = 10.dp)
    ) {

        Text(
            text = "Позиция",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1f)
        )
        Text(
            text = "Цена",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1f)
        )
        Text(
            text = "Кол-во",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1f)
        )
        Text(
            text = "Итого",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1f)
        )
    }
}

@Composable
fun CartItem(goodsItemUi: GoodsItemUi, index: Int = 0) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(start = 10.dp, end = 10.dp)
    ) {

        Text(
            text = goodsItemUi.name ?: index.toString(),
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1f)
        )
        Text(
            text = String.format("%.2f", goodsItemUi.amount).replace(".", ","),
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1f)
        )
        Text(
            text = "${goodsItemUi.quantity}",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1f)
        )
        Text(
            text = String.format("%.2f", goodsItemUi.amount * goodsItemUi.quantity).replace(".", ","),
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CartScreenPreview() {
    val testGoodsItemUis = listOf(
        GoodsItemUi(amount = 2.40, quantity = 1),
        GoodsItemUi(amount = 5.00, quantity = 2),
        GoodsItemUi(amount = 7.90, quantity = 1),
        GoodsItemUi(amount = 1.50, quantity = 3),
        GoodsItemUi(amount = 0.90, quantity = 2),
        GoodsItemUi(amount = 1.00, quantity = 2),
        GoodsItemUi(amount = 0.50, quantity = 2),
        GoodsItemUi(amount = 10.00, quantity = 4),
        GoodsItemUi(amount = 50.00, quantity = 1),
        GoodsItemUi(amount = 2.00, quantity = 2),
        GoodsItemUi(amount = 7.00, quantity = 3),
        GoodsItemUi(amount = 2.50, quantity = 4),
        GoodsItemUi(amount = 3.80, quantity = 2),
        GoodsItemUi(amount = 199.99, quantity = 1),
        GoodsItemUi(amount = 9.99, quantity = 5),
    )
    CartScreen(testGoodsItemUis)
}
