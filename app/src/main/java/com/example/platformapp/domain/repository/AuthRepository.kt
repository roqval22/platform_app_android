package com.example.platformapp.domain.repository

import com.example.platformapp.core.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun login(email: String, password: String): Flow<Resource<Boolean>>
    fun logout()
    val isUserLoggedIn: Boolean
}
