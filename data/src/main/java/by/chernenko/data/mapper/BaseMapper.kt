package by.chernenko.data.mapper

interface BaseMapper<in From, out To> {
    fun map(from: From): To
}