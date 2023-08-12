package com.ivasco.hearthstonecards.ui.extensions

import com.ivasco.hearthstonecards.R
import com.ivasco.hearthstonecards.data.error.Error
import com.ivasco.hearthstonecards.data.error.NetworkError
import com.ivasco.hearthstonecards.ui.error.UiError
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class ErrorExtensionsKtTest {
    @Test
    fun `Should return NetworkError NotFound resource`() {
        assertEquals(R.string.not_found_error, NetworkError.NotFound.getMessageResource())
    }

    @Test
    fun `Should return AccessDenied NotFound resource`() {
        assertEquals(R.string.access_denied_error, NetworkError.AccessDenied.getMessageResource())
    }

    @Test
    fun `Should return NetworkError ServiceUnavailable resource`() {
        assertEquals(
            R.string.service_unavailable_error,
            NetworkError.ServiceUnavailable.getMessageResource()
        )
    }

    @Test
    fun `Should return NetworkError Unknown resource`() {
        assertEquals(R.string.unknown_network_error, NetworkError.Unknown.getMessageResource())
    }

    @Test
    fun `Should return UiError PersonNotFound resource`() {
        assertEquals(R.string.person_not_found_error, UiError.PersonNotFound.getMessageResource())
    }

    @Test
    fun `Should return Unknown error resource`() {
        val testError = object : Error {}
        assertEquals(R.string.unknown_error, testError.getMessageResource())
    }
}