package com.mburaksayilgan.movieapp.utils

import com.mburaksayilgan.movieapp.utils.Status.*

data class Resource<out T>(val status: Status, val data: T?, val message: String?, val throwable : Throwable? = Throwable()) {

    companion object {

        fun <T> success(data: T?): Resource<T> {
            return Resource(SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(ERROR, data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(LOADING, data, null)
        }

    }

}