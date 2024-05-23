package com.kygoinc.frontendinterview.model

import kotlinx.serialization.Serializable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path



@Serializable
data class Post(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)
interface ApiService {

    @GET("posts")
    suspend fun getAllPosts(): Response<List<Post>>

    @GET("posts/{postId}")
    suspend fun getPostById(@Path("postId") postId:String ):Response<Post>

}

//interface PostRepository {
//
//    suspend fun getAllPosts():NetworkResult<List<Post>>
//
//    suspend fun getPostById(postId:String): NetworkResult<Post>
//
//}