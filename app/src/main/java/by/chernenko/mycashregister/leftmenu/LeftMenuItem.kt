package by.chernenko.mycashregister.leftmenu

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import by.chernenko.mycashregister.ui.theme.Black
import by.chernenko.mycashregister.ui.theme.Ultramarine
import by.chernenko.mycashregister.ui.theme.White

@Composable
fun LeftMenuItem(
    text: String,
    selected: Boolean,
    icon: ImageVector,
    onClick: () -> Unit
) {
    NavigationDrawerItem(
        label = { Text(text = text) },
        selected = selected,
        icon = { Icon(icon, contentDescription = null) },
        colors = NavigationDrawerItemDefaults.colors(
            selectedContainerColor = if (selected) Ultramarine else White,
            selectedTextColor = if (selected) White else Ultramarine,
            selectedIconColor = if (selected) White else Ultramarine,
            unselectedContainerColor = if (!selected) White else Ultramarine,
            unselectedTextColor = if (!selected) Black else White,
            unselectedIconColor = if (!selected) Ultramarine else White
        ),
        onClick = onClick
    )
}