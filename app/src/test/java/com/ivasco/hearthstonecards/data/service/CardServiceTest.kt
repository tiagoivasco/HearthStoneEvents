package com.ivasco.hearthstonecards.data.service

import com.ivasco.hearthstonecards.data.endpoint.CardEndpoint
import com.ivasco.hearthstonecards.data.error.ErrorHandler
import com.ivasco.hearthstonecards.data.model.Result
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Test

internal class CardServiceTest {
    private val errorHandler: ErrorHandler = mockk()
    private val endpoint: CardEndpoint = mockk()
    private val repository = CardService(endpoint, errorHandler)
}