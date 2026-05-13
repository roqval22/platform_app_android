package com.example.platformapp.data.repository

import com.example.platformapp.core.Resource
import com.example.platformapp.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {

    override fun login(email: String, password: String): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading())
        try {
            firebaseAuth.signInWithEmailAndPassword(email, password).await()
            emit(Resource.Success(true))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Error desconocido"))
        }
    }

    override fun signInWithGoogle(idToken: String): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading())
        try {
            val credential = GoogleAuthProvider.getCredential(idToken, null)
            firebaseAuth.signInWithCredential(credential).await()
            emit(Resource.Success(true))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Error al autenticar con Google"))
        }
    }

    override fun logout() {
        firebaseAuth.signOut()
    }

    override val isUserLoggedIn: Boolean
        get() = firebaseAuth.currentUser != null
}
