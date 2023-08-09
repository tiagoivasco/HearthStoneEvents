package com.ivasco.hearthstonecards.ui.di

import com.ivasco.hearthstonecards.ui.fragment.carddetails.CardDetailsViewModel
import com.ivasco.hearthstonecards.ui.fragment.cardlist.CardListViewModel
import com.ivasco.hearthstonecards.ui.fragment.categorylist.CategoryListViewModel
import com.ivasco.hearthstonecards.ui.fragment.entry.EntryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { EntryViewModel() }
    viewModel { CategoryListViewModel(get()) }
    viewModel { CardListViewModel(get()) }
    viewModel { CardDetailsViewModel(get()) }
}