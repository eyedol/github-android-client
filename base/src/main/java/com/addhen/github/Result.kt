package com.addhen.github

class Result<out T>(
    val status: Status = Status.LOADING,
    val message: String? = null,
    val data: T? = null
) {

    companion object {

        fun <T> success(data: T): Result<T> {
            return Result(Status.SUCCESS, null, data)
        }

        fun <T> error(message: String, data: T?): Result<T> {
            return Result(Status.ERROR, message, data)
        }

        fun <T> loading(): Result<T> {
            return Result(message = null, data = null)
        }
    }

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }
}
