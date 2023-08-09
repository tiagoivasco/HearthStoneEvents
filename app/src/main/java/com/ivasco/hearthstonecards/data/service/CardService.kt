package com.ivasco.hearthstonecards.data.service

import com.ivasco.hearthstonecards.data.endpoint.CardEndpoint
import com.ivasco.hearthstonecards.data.error.ErrorHandler
import com.ivasco.hearthstonecards.data.model.*
import com.ivasco.hearthstonecards.data.model.Card

class CardService(
    private val endpoint: CardEndpoint,
    private val errorHandler: ErrorHandler
) {
    suspend fun getCategories(): Result<List<String>> {
        return wrapInResult { endpoint.getAllCategories().classes }
    }

    suspend fun getCardsByClass(cardName: String): Result<List<Card>> {
        return wrapInResult { endpoint.getCardsByClass(cardName) }
    }

    private suspend fun <T> wrapInResult(block: suspend () -> T): Result<T> {
        return try {
            Result.Success(block())
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Fail(errorHandler.getError(e))
        }
    }
}