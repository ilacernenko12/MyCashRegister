package by.chernenko.mycashregister.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun NumPad(
    onClick: (String) -> Unit
) {
    val numpad = listOf(
        listOf(1, 2, 3),
        listOf(4, 5, 6),
        listOf(7, 8, 9),
        listOf("C", 0, "В ЧЕК")
    )

    Box(modifier = Modifier.padding(bottom = 10.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.fillMaxHeight()
        ) {
            numpad.forEach { buttons ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    buttons.forEach { button ->
                        val buttonText = button.toString()

                        Button(
                            onClick = { onClick(buttonText) },
                            shape = RectangleShape,
                            modifier = Modifier
                                .weight(1f)
                                .height(80.dp),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.Black,
                                containerColor = Color.Transparent
                            )
                        ) {
                            val textColor = when (buttonText) {
                                "C" -> Color.Red
                                "В ЧЕК" -> Color.Green
                                else -> Color.Black
                            }

                            val fontSize = when (buttonText) {
                                "В ЧЕК" -> 29.sp
                                else -> 32.sp
                            }
                            Text(
                                text = buttonText,
                                fontSize = fontSize,
                                color = textColor,
                                letterSpacing = (-2).sp
                            )
                        }
                    }
                }
            }
        }
    }
}
