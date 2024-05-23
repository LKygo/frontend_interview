package com.kygoinc.frontendinterview.screens.state

import com.kygoinc.frontendinterview.model.Post

data class ProductState(
    val error: String? = null,
    val isLoading:Boolean = false,
    val products: List<Post> = emptyList()
)
