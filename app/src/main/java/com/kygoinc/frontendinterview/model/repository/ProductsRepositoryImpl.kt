package com.kygoinc.frontendinterview.model.repository

import com.kygoinc.frontendinterview.domain.repository.ProductsRepository
import com.kygoinc.frontendinterview.model.ApiService
import com.kygoinc.frontendinterview.model.NetworkResult
import com.kygoinc.frontendinterview.model.Post
import com.kygoinc.frontendinterview.model.safeApiCall
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val api: ApiService
) : ProductsRepository{
    override suspend fun getProducts(): NetworkResult<List<Post>> {
        return safeApiCall { api.getAllPosts() }
    }
}