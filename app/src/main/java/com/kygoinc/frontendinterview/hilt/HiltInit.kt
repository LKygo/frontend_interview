package com.kygoinc.frontendinterview.hilt
import android.content.Context
import android.provider.SyncStateContract
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.kygoinc.frontendinterview.domain.repository.ProductsRepository
import com.kygoinc.frontendinterview.model.ApiService
import com.kygoinc.frontendinterview.model.Post
import com.kygoinc.frontendinterview.model.repository.ProductsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
        explicitNulls = true
    }

    @Provides
    @Singleton
    fun provideHttpClient(
        @ApplicationContext context: Context,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun providePostRepository(
        postAPi: ApiService,
    ): ProductsRepository {
        return ProductsRepositoryImpl(
            api = postAPi
        )
    }

//    @Provides
//    @Singleton
//    fun providePostRepository(apiService: ApiService): Post {
//        return  ProductsRepositoryImpl(api = apiService)
//    }


    @Provides
    @Singleton
    fun provideApiService(
        client: OkHttpClient,
        networkJson: Json,
    ): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .client(client)
            .addConverterFactory(
                networkJson.asConverterFactory("application/json".toMediaType()),
            )
            .build()
            .create(ApiService::class.java)
    }
}



