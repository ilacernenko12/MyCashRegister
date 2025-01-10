package by.chernenko.mycashregister.navigation

sealed class Routes(val route: String) {
    data object Sale: Routes("sale")
    data object Refund: Routes("refund")
    data object CloseBatch: Routes("close_batch")
    data object Deposit: Routes("deposit")
    data object Withdrawal: Routes("withdrawal")
    data object Reports: Routes("reports")
    data object Cart: Routes("cart")
}