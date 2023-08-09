package com.ivasco.hearthstonecards.data.model

import com.ivasco.hearthstonecards.data.error.Error

sealed class Result<T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Fail<T>(val error: Error) : Result<T>()
}