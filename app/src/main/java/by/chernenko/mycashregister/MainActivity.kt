package by.chernenko.mycashregister

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import by.chernenko.mycashregister.leftmenu.LeftMenu
import by.chernenko.mycashregister.navigation.NavigationGraph
import by.chernenko.mycashregister.ui.theme.MyCashRegisterTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()

            MyCashRegisterTheme {
                LeftMenu(navController)
                NavigationGraph(navController)
            }
        }
    }
}

@Composable
fun SaleScreen() {
    Text(text = "SALE")
}

@Composable
fun RefundScreen() {
    Text(text = "REFUND")
}

@Composable
fun CloseBatchScreen() {
    Text(text = "CLOSE BATCH")
}

@Composable
fun DepositScreen() {
    Text(text = "DEPOSIT")
}

@Composable
fun WithdrawalScreen() {
    Text(text = "WITHDRAWAL")
}

@Composable
fun ReportsScreen() {
    Text(text = "REPORTS")
}