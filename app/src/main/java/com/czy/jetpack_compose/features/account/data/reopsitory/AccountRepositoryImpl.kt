package com.czy.jetpack_compose.features.account.data.reopsitory

import com.czy.jetpack_compose.features.account.domain.models.Account
import com.czy.jetpack_compose.features.account.domain.models.Movement
import com.czy.jetpack_compose.features.account.domain.repository.AccountRepository
import com.skydoves.sandwich.ApiResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class AccountRepositoryImpl(
    private val httpClient: HttpClient
) : AccountRepository {

    companion object {
        const val BASE_URL = "https://67e9cef1bdcaa2b7f5ba36f3.mockapi.io/learning/v1/"
    }

    override suspend fun getAccounts(): ApiResponse<List<Account>> {
        val response = httpClient.get("$BASE_URL/accounts").body<List<Account>>()
        return ApiResponse.of { response }
    }

    override suspend fun getAccountMovements(accountId: String): ApiResponse<List<Movement>> {
        val response = httpClient.get("$BASE_URL/movements").body<List<Movement>>()
        return ApiResponse.of { response }
    }
}