package by.chernenko.mycashregister.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import by.chernenko.mycashregister.closebatch.CloseBatchScreen
import by.chernenko.mycashregister.common.CartScreen
import by.chernenko.mycashregister.common.GoodsItem
import by.chernenko.mycashregister.deposit.DepositScreen
import by.chernenko.mycashregister.refund.RefundScreen
import by.chernenko.mycashregister.reports.ReportsScreen
import by.chernenko.mycashregister.sale.SaleScreen
import by.chernenko.mycashregister.sale.SaleViewModel
import by.chernenko.mycashregister.withdrawal.WithdrawalScreen

@Composable
fun NavigationGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = Routes.Sale.route,
    onTotalAmountClick: () -> Unit
) {
    val testGoodsItems = listOf(
        GoodsItem(amount = 2.40, quantity = 1),
        GoodsItem(amount = 5.00, quantity = 2),
        GoodsItem(amount = 7.90, quantity = 1),
        GoodsItem(amount = 1.50, quantity = 3),
        GoodsItem(amount = 0.90, quantity = 2),
        GoodsItem(amount = 1.00, quantity = 2),
        GoodsItem(amount = 0.50, quantity = 2),
        GoodsItem(amount = 10.00, quantity = 4),
        GoodsItem(amount = 50.00, quantity = 1),
        GoodsItem(amount = 2.00, quantity = 2),
        GoodsItem(amount = 7.00, quantity = 3),
        GoodsItem(amount = 2.50, quantity = 4),
        GoodsItem(amount = 3.80, quantity = 2),
        GoodsItem(amount = 199.99, quantity = 1),
        GoodsItem(amount = 9.99, quantity = 5),
        GoodsItem(amount = 1.50, quantity = 3),
        GoodsItem(amount = 0.90, quantity = 2),
        GoodsItem(amount = 1.00, quantity = 2),
        GoodsItem(amount = 0.50, quantity = 2),
        GoodsItem(amount = 10.00, quantity = 4),
        GoodsItem(amount = 50.00, quantity = 1),
        GoodsItem(amount = 2.00, quantity = 2),
        GoodsItem(amount = 7.00, quantity = 3),
        GoodsItem(amount = 2.50, quantity = 4),
        GoodsItem(amount = 3.80, quantity = 2),
        GoodsItem(amount = 199.99, quantity = 1),
        GoodsItem(amount = 9.99, quantity = 5)
    )
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(Routes.Sale.route) { backStackEntry ->
            val viewModel = hiltViewModel<SaleViewModel>()
            SaleScreen(onTotalAmountClick = onTotalAmountClick, viewModel = viewModel)
        }
        composable(Routes.Refund.route) { RefundScreen() }
        composable(Routes.CloseBatch.route) { CloseBatchScreen() }
        composable(Routes.Deposit.route) { DepositScreen() }
        composable(Routes.Withdrawal.route) { WithdrawalScreen() }
        composable(Routes.Reports.route) { ReportsScreen() }
        composable(Routes.Cart.route) { CartScreen(testGoodsItems) }
    }
}