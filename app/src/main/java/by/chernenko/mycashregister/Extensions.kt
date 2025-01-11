package by.chernenko.mycashregister

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun CoroutineScope.launchIO(
    coroutineName: String = "Unknown",
    errorAction: suspend CoroutineScope.() -> Unit = { },
    block: suspend CoroutineScope.() -> Unit,
): Job {
    val tag = "COROUTINE_DEBUG"
    return this.launch(Dispatchers.IO) {
        try {
            Log.i(tag, "Coroutine <$coroutineName> started")
            block()
            Log.i(tag, "Coroutine <$coroutineName> completed successfully")
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                Log.e(tag, "Coroutine <$coroutineName> encountered an error: ${e.message}")
                errorAction()
            }
        } finally {
            Log.i(tag, "Coroutine <$coroutineName> finished")
        }
    }
}