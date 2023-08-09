package com.ivasco.hearthstonecards.ui.error

import com.ivasco.hearthstonecards.data.error.Error

sealed class UiError : Error {
    object PersonNotFound : UiError()
}
