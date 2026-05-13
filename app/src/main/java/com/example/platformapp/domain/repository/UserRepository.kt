package com.example.platformapp.domain.repository

import com.example.platformapp.core.Resource
import com.example.platformapp.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUserProfile(uid: String): Flow<Resource<User>>
    fun saveUserProfile(user: User): Flow<Resource<Boolean>>
}
