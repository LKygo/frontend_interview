package com.kygoinc.frontendinterview.screens.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kygoinc.frontendinterview.domain.repository.ProductsRepository
import com.kygoinc.frontendinterview.model.NetworkResult
import com.kygoinc.frontendinterview.screens.state.ProductState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val repository: ProductsRepository
): ViewModel(){

    private val _state = mutableStateOf(ProductState())
    val state:State<ProductState> = _state

    init {
        getProducts()
    }

    fun getProducts(){
         viewModelScope.launch {
             when(val result = repository.getProducts()){
                 is NetworkResult.Success -> {
                     _state.value = ProductState(products = result.data)
                 }
                 is NetworkResult.Error -> {
                     _state.value = ProductState(error = result.message)
                 }
                 else ->{
                     state
                 }
             }
         }
    }
}