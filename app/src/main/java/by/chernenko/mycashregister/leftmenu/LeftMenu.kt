package by.chernenko.mycashregister.leftmenu

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import by.chernenko.mycashregister.navigation.Routes
import by.chernenko.mycashregister.ui.theme.Black
import by.chernenko.mycashregister.ui.theme.Ultramarine
import by.chernenko.mycashregister.ui.theme.White
import kotlinx.coroutines.launch

@Composable
fun LeftMenu(
    navController: NavController
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val selectedIndex = remember { mutableIntStateOf(0) }


    val items = listOf(
        Triple("Продажа", Icons.Outlined.ShoppingCart, Routes.Sale.route),
        Triple("Возврат", Icons.Outlined.Refresh, Routes.Refund.route),
        Triple("Закрытие смены", Icons.Outlined.DateRange, Routes.CloseBatch.route),
        Triple("Внесение наличных", Icons.Outlined.KeyboardArrowUp, Routes.Deposit.route),
        Triple("Изъятие наличных", Icons.Outlined.KeyboardArrowDown, Routes.Withdrawal.route),
        Triple("Отчеты", Icons.Outlined.Info, Routes.Reports.route)
    )

    ModalNavigationDrawer(
        scrimColor = Ultramarine,
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = White,
                drawerContentColor = Black
            ) {
                LeftMenuHeader()

                HorizontalDivider(modifier = Modifier.padding(16.dp))

                items.forEachIndexed { index, item ->
                    LeftMenuItem(
                        text = item.first,
                        selected = index == selectedIndex.intValue,
                        icon = item.second,
                        onClick = {
                            selectedIndex.intValue = index
                            navController.navigate(item.third) {
                                popUpTo(Routes.Sale.route)
                            }

                            scope.launch { drawerState.close() }
                        }
                    )
                }
            }
        }
    ) {

    }
}