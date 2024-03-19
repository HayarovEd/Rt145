package one.win.casino.rt145.domain.utils

sealed class ResourceRt145<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?): ResourceRt145<T>(data)
    class Error<T>(message: String, data: T? = null): ResourceRt145<T>(data, message)
}