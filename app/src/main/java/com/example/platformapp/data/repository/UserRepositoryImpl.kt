package com.example.platformapp.data.repository

import com.example.platformapp.core.Resource
import com.example.platformapp.core.cfg.AppCfg
import com.example.platformapp.domain.model.User
import com.example.platformapp.domain.repository.UserRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : UserRepository {

    override fun getUserProfile(uid: String): Flow<Resource<User>> = flow {
        emit(Resource.Loading())
        try {
            val snapshot = firestore.collection(AppCfg.Firebase.USERS_COLLECTION).document(uid).get().await()
            val user = snapshot.toObject(User::class.java)
            if (user != null) {
                emit(Resource.Success(user))
            } else {
                emit(Resource.Error("Usuario no encontrado"))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Error al obtener perfil"))
        }
    }

    override fun saveUserProfile(user: User): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading())
        try {
            firestore.collection(AppCfg.Firebase.USERS_COLLECTION).document(user.id).set(user).await()
            emit(Resource.Success(true))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Error al guardar perfil"))
        }
    }
}
