package by.chernenko.mycashregister

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import by.chernenko.mycashregister.leftmenu.LeftMenu
import by.chernenko.mycashregister.ui.theme.MyCashRegisterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()

        setContent {
            MyCashRegisterTheme {
                LeftMenu {
                    TODO("content")
                }
            }
        }
    }
}

