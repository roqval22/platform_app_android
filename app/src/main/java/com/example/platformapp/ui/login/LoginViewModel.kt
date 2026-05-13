package com.example.platformapp.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.platformapp.core.Resource
import com.example.platformapp.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _loginState = MutableStateFlow<Resource<Boolean>?>(null)
    val loginState: StateFlow<Resource<Boolean>?> = _loginState

    fun login(email: String, password: String) {
        viewModelScope.launch {
            repository.login(email, password).collect { result ->
                _loginState.value = result
            }
        }
    }

    fun signInWithGoogle(idToken: String) {
        viewModelScope.launch {
            repository.signInWithGoogle(idToken).collect { result ->
                _loginState.value = result
            }
        }
    }

    fun logout() {
        repository.logout()
    }

    val isUserLoggedIn: Boolean
        get() = repository.isUserLoggedIn
}
