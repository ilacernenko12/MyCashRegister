package by.chernenko.mycashregister.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import by.chernenko.mycashregister.CloseBatchScreen
import by.chernenko.mycashregister.DepositScreen
import by.chernenko.mycashregister.RefundScreen
import by.chernenko.mycashregister.ReportsScreen
import by.chernenko.mycashregister.SaleScreen
import by.chernenko.mycashregister.WithdrawalScreen

@Composable
fun NavigationGraph(
    navController: NavHostController,
    startDestination: String = Routes.Sale.route
) {

    NavHost(navController = navController, startDestination = startDestination) {
        composable(Routes.Sale.route) { SaleScreen() }
        composable(Routes.Refund.route) { RefundScreen() }
        composable(Routes.CloseBatch.route) { CloseBatchScreen() }
        composable(Routes.Deposit.route) { DepositScreen() }
        composable(Routes.Withdrawal.route) { WithdrawalScreen() }
        composable(Routes.Reports.route) { ReportsScreen() }
    }
}