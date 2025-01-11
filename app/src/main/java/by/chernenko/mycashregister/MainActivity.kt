@file:OptIn(ExperimentalMaterial3Api::class)

package by.chernenko.mycashregister

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.compose.rememberNavController
import by.chernenko.mycashregister.leftmenu.AppContent
import by.chernenko.mycashregister.ui.theme.MyCashRegisterTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()

            MyCashRegisterTheme {
                AppContent(navController)
            }
        }
    }
}