package com.ivasco.hearthstonecards.data.error

interface ErrorHandler {
    fun getError(throwable: Throwable): Error
}