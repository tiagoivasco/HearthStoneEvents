package com.ivasco.hearthstonecards.data.di

import com.ivasco.hearthstonecards.data.config.provideMyRetrofit
import com.ivasco.hearthstonecards.data.endpoint.CardEndpoint
import com.ivasco.hearthstonecards.data.error.NetworkErrorHandler
import com.ivasco.hearthstonecards.data.service.CardService
import org.koin.dsl.module
import retrofit2.Retrofit

val dataModule = module {
    single { CardService(provideCardService(get()), get<NetworkErrorHandler>()) }
    factory { NetworkErrorHandler() }
    single { provideMyRetrofit() }
}

private fun provideCardService(retrofit: Retrofit) = retrofit.create(CardEndpoint::class.java)

