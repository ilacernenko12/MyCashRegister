package by.chernenko.mycashregister.common

sealed class NumpadAction {
    data class PressButton(val button: String): NumpadAction()
    data object PressClear: NumpadAction()
}