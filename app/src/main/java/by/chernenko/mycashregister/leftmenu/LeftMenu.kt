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
import by.chernenko.mycashregister.ui.theme.Black
import by.chernenko.mycashregister.ui.theme.Ultramarine
import by.chernenko.mycashregister.ui.theme.White
import kotlinx.coroutines.launch

@Composable
fun LeftMenu(content: @Composable () -> Unit) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val selectedIndex = remember { mutableIntStateOf(0) }

    val items = listOf(
        Pair("Продажа", Icons.Outlined.ShoppingCart),
        Pair("Возврат", Icons.Outlined.Refresh),
        Pair("Закрытие смены", Icons.Outlined.DateRange),
        Pair("Внесение наличных", Icons.Outlined.KeyboardArrowUp),
        Pair("Изъятие наличных", Icons.Outlined.KeyboardArrowDown),
        Pair("Отчеты", Icons.Outlined.Info)
    )

    ModalNavigationDrawer(
        scrimColor = Ultramarine,
        drawerState = drawerState,
        content = content,
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
                            scope.launch { drawerState.close() }
                        }
                    )
                }
            }
        }
    )
}