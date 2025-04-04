package com.czy.jetpack_compose.features.account.domain.repository

import com.czy.jetpack_compose.features.account.domain.models.Account
import com.czy.jetpack_compose.features.account.domain.models.Movement
import com.skydoves.sandwich.ApiResponse

interface AccountRepository {

    suspend fun getAccounts(): ApiResponse<List<Account>>
    suspend fun getAccountMovements(accountId: String): ApiResponse<List<Movement>>
}