package com.example.platformapp.data.repository

import android.net.Uri
import com.example.platformapp.core.Resource
import com.example.platformapp.domain.repository.StorageRepository
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class StorageRepositoryImpl @Inject constructor(
    private val storage: FirebaseStorage
) : StorageRepository {

    override fun uploadImage(path: String, uri: Uri): Flow<Resource<String>> = flow {
        emit(Resource.Loading())
        try {
            val ref = storage.reference.child(path)
            ref.putFile(uri).await()
            val downloadUrl = ref.downloadUrl.await().toString()
            emit(Resource.Success(downloadUrl))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Error al subir imagen"))
        }
    }
}
