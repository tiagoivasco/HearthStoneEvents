package com.ivasco.hearthstonecards.ui.fragment.categorylist

import com.ivasco.hearthstonecards.data.model.Result
import com.ivasco.hearthstonecards.data.service.CardService
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.junit.jupiter.api.Assertions.*

class CategoryListViewModelTest {

    private lateinit var viewModel: CategoryListViewModel
    private lateinit var service: CardService

    @BeforeEach
    fun setUp() {
        this.service = mock(CardService::class.java)
        this.viewModel = CategoryListViewModel(this.service)
    }

    @Test
    @DisplayName("Should set state to Loading before fetching categories")
    fun fetchCategoriesShouldSetStateToLoading() {
        viewModel.fetchCategories()

        assertEquals(UiState.Loading, viewModel.state.value)
    }

    @Test
    @DisplayName("Should set state to Success when fetching categories is successful")
    fun fetchCategoriesShouldSetStateToSuccessWhenSuccessful() = runBlocking {
        val categories = listOf("Category1", "Category2")
        val successResult = Result.Success(categories)
        `when`(service.getCategories()).thenReturn(successResult)

        viewModel.fetchCategories()

        assertEquals(UiState.Success(categories), viewModel.state.value)
    }

//    @Test
//    @DisplayName("Should set state to Error when fetching categories fails")
//    fun fetchCategoriesShouldSetStateToErrorWhenFails() = runBlocking {
//        // Mocking the result of service.getCategories() to be a Result.Fail
//        val error = Error
//        val result = Result.Fail<List<String>>(error)
//        `when`(service.getCategories()).thenReturn(result)
//
//        // Calling the fetchCategories() method
//        viewModel.fetchCategories()
//
//        // Verifying that the state is set to UiState.Error with the correct error message resource
//        val expectedState = UiState.Error(error.message)
//        assertEquals(expectedState, viewModel.state.value)
//    }
}