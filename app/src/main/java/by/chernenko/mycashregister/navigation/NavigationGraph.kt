package by.chernenko.mycashregister.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import by.chernenko.mycashregister.closebatch.CloseBatchScreen
import by.chernenko.mycashregister.deposit.DepositScreen
import by.chernenko.mycashregister.refund.RefundScreen
import by.chernenko.mycashregister.reports.ReportsScreen
import by.chernenko.mycashregister.sale.SaleScreen
import by.chernenko.mycashregister.withdrawal.WithdrawalScreen

@Composable
fun NavigationGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = Routes.Sale.route
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(Routes.Sale.route) { SaleScreen(modifier) }
        composable(Routes.Refund.route) { RefundScreen() }
        composable(Routes.CloseBatch.route) { CloseBatchScreen() }
        composable(Routes.Deposit.route) { DepositScreen() }
        composable(Routes.Withdrawal.route) { WithdrawalScreen() }
        composable(Routes.Reports.route) { ReportsScreen() }
    }
}