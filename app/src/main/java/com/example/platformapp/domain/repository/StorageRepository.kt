package com.example.platformapp.domain.repository

import android.net.Uri
import com.example.platformapp.core.Resource
import kotlinx.coroutines.flow.Flow

interface StorageRepository {
    fun uploadImage(path: String, uri: Uri): Flow<Resource<String>>
}
