package com.ivasco.hearthstonecards.ui.fragment.cardlist

import com.ivasco.hearthstonecards.data.service.CardService
import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class CardListViewModelTest {
    @Mock
    private lateinit var service: CardService

    private lateinit var viewModel: CardListViewModel

    /**Should set state to Loading initially and then to Success when fetching cards by category is successful*/
    @Before
    fun setupLoading() {
        MockitoAnnotations.initMocks(this)
        viewModel = CardListViewModel(service)
    }

    @Before
    fun setupError() {
        MockitoAnnotations.initMocks(this)
        viewModel = CardListViewModel(service)
    }

}