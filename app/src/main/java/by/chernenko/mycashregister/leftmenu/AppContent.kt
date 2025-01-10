@file:OptIn(ExperimentalMaterial3Api::class)

package by.chernenko.mycashregister.leftmenu

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import by.chernenko.mycashregister.navigation.NavigationGraph
import by.chernenko.mycashregister.navigation.Routes
import by.chernenko.mycashregister.sale.SaleViewModel
import by.chernenko.mycashregister.ui.theme.Black
import by.chernenko.mycashregister.ui.theme.Ultramarine
import by.chernenko.mycashregister.ui.theme.White
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AppContent(
    navController: NavHostController,
    drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed)
) {
    val scope = rememberCoroutineScope()
    val selectedIndex = remember { mutableIntStateOf(0) }
    val currentBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry.value?.destination?.route

    val title = remember(currentRoute) {
        when (currentRoute) {
            Routes.Sale.route -> "Продажа"
            Routes.Refund.route -> "Возврат"
            Routes.CloseBatch.route -> "Закрытие смены"
            Routes.Deposit.route -> "Внесение наличных"
            Routes.Withdrawal.route -> "Изъятие наличных"
            Routes.Reports.route -> "Отчеты"
            else -> "Касса"
        }
    }

    // Left menu
    ModalNavigationDrawer(
        scrimColor = Ultramarine,
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(300.dp),
                drawerContainerColor = White,
                drawerContentColor = Black
            ) {
                LeftMenuHeader()

                HorizontalDivider(modifier = Modifier.padding(16.dp))

                MenuItems().forEachIndexed { index, item ->
                    LeftMenuItem(text = item.first,
                        selected = index == selectedIndex.intValue,
                        icon = item.second,
                        onClick = {
                            selectedIndex.intValue = index
                            navController.navigate(item.third) {
                                popUpTo(navController.graph.startDestinationId) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                            scope.launch { drawerState.close() }
                        })
                }
            }
        }) {
        // Main content
        Scaffold(
            topBar = { MyAppBar(title, scope, drawerState, currentRoute) },
            content = { padding ->
                NavigationGraph(navController, Modifier.padding(padding))
            })
    }
}

@Composable
fun MyAppBar(
    title: String,
    scope: CoroutineScope,
    drawerState: DrawerState,
    currentRoute: String? = null
) {
    TopAppBar(title = {
        Text(
            text = title,
            fontSize = 22.sp,
            modifier = Modifier.padding(start = 10.dp)
        )
    }, navigationIcon = {
        IconButton(onClick = { scope.launch { drawerState.open() } }) {
            Icon(Icons.Filled.Menu, contentDescription = "menu")
        }
    }, actions = {
        when (currentRoute) {
            Routes.Sale.route -> {
                IconButton(onClick = { /* TODO() */ }) {
                    Icon(
                        Icons.Filled.Delete, contentDescription = "delete"
                    )
                }
                IconButton(onClick = { /* TODO() */ }) {
                    Icon(
                        Icons.Filled.Favorite, contentDescription = "delete"
                    )
                }
            }

            Routes.Refund.route -> {
                IconButton(onClick = { /* TODO() */ }) {
                    Icon(
                        Icons.Filled.Delete, contentDescription = "delete"
                    )
                }
            }

            Routes.Deposit.route -> {
                IconButton(onClick = { /* TODO() */ }) {
                    Icon(
                        Icons.Filled.Delete, contentDescription = "delete"
                    )
                }
            }

            Routes.Withdrawal.route -> {
                IconButton(onClick = { /* TODO() */ }) {
                    Icon(
                        Icons.Filled.Delete, contentDescription = "delete"
                    )
                }
            }
        }
    })
}

@Composable
fun MenuItems(): List<Triple<String, ImageVector, String>> {
    return listOf(
        Triple("Продажа", Icons.Outlined.ShoppingCart, Routes.Sale.route),
        Triple("Возврат", Icons.Outlined.Refresh, Routes.Refund.route),
        Triple("Закрытие смены", Icons.Outlined.DateRange, Routes.CloseBatch.route),
        Triple("Внесение наличных", Icons.Outlined.KeyboardArrowUp, Routes.Deposit.route),
        Triple("Изъятие наличных", Icons.Outlined.KeyboardArrowDown, Routes.Withdrawal.route),
        Triple("Отчеты", Icons.Outlined.Info, Routes.Reports.route)
    )
}