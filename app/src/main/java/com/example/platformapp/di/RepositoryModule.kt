package com.example.platformapp.di

import com.example.platformapp.data.repository.AuthRepositoryImpl
import com.example.platformapp.data.repository.StorageRepositoryImpl
import com.example.platformapp.data.repository.UserRepositoryImpl
import com.example.platformapp.domain.repository.AuthRepository
import com.example.platformapp.domain.repository.StorageRepository
import com.example.platformapp.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    @Singleton
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository

    @Binds
    @Singleton
    abstract fun bindStorageRepository(
        storageRepositoryImpl: StorageRepositoryImpl
    ): StorageRepository
}
