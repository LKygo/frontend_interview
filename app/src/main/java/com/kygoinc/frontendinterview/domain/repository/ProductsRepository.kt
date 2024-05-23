package com.kygoinc.frontendinterview.domain.repository

import com.kygoinc.frontendinterview.model.NetworkResult
import com.kygoinc.frontendinterview.model.Post

interface ProductsRepository {
    suspend fun getProducts(): NetworkResult<List<Post>>
}