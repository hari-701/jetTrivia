package com.example.jettrivia.data



data class DataorException<T,Boolean,E:Exception> (
                var data: T? = null,
                var loading:Boolean? = null,
                var e: E? = null)
