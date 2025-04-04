package com.czy.jetpack_compose.features.account.data.di

import com.czy.jetpack_compose.features.account.data.reopsitory.AccountRepositoryImpl
import com.czy.jetpack_compose.features.account.domain.repository.AccountRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AccountModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient =
        HttpClient(OkHttp.create()) {
            defaultRequest {
                url(AccountRepositoryImpl.BASE_URL)
                header(HttpHeaders.ContentType, "application/json")
            }

            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                    }
                )
            }
        }

    @Provides
    @Singleton
    fun provideAccountRepository(httpClient: HttpClient): AccountRepository =
        AccountRepositoryImpl(httpClient = httpClient)
}