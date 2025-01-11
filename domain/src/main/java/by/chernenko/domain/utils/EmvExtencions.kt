package by.chernenko.domain.utils

import java.util.Locale
import kotlin.math.pow

/**
 * Extension functions for working with EMV format and financial operations.
 */

/**
 * This function converts a string representation of a financial amount
 * (e.g. "2,22", "4.50") into an EMV-compatible fixed-length string format (12 digits).
 * The result is padded with leading zeros and expects the input in a localized
 * format (e.g., with a comma as a decimal separator).
 *
 * Example:
 *
 * Input: "2,22" -> Output: "000000000222"
 *
 * Input: "4.50" -> Output: "000000000450"
 *
 * @receiver String The string representation of the financial amount.
 * @return String The EMV-formatted string with leading zeros.
 */
fun String.toEmvAmount(): String {
    if (this.contains('.')) {
        val formattedPrice = this.replace(".", "")
        return String.format(Locale.US,"%012d", formattedPrice.toInt())
    } else {
        val formattedPrice = this.replace(",", "")
        return String.format(Locale.US,"%012d", formattedPrice.toInt())
    }
}

/**
 * Extension function to convert EMV formatted amount (fixed-length string)
 * back into a human-readable financial amount.
 *
 * @receiver String The EMV-formatted string (e.g., "000000000222").
 * @param withComma Boolean If true, the result will use a comma as the decimal separator.
 *                         If false, the result will use a dot.
 * @param decimalPoint Int The number of decimal places to include. Default is 2.
 * @return String The formatted financial amount as a string with a decimal separator.
 */
fun String.fromEmvAmount(withComma: Boolean = false, decimalPoint: Int = 2): String {
    val amountInCents = this.toLong()

    val multiplier = 10.0.pow(decimalPoint.toDouble()).toLong()
    val rubles = amountInCents / multiplier
    val kopecks = amountInCents % multiplier

    val formattedAmount = String.format("%d.%0${decimalPoint}d", rubles, kopecks)

    return if (withComma) {
        formattedAmount.replace(".", ",")
    } else {
        formattedAmount
    }
}

