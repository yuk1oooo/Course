package com.example.android_course.domain

import android.util.Log
import com.example.android_course.data.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginModel(private val authRepository: AuthRepository) {
    suspend fun signIn(login:String, password: String):SignInResult{
        return withContext(Dispatchers.IO) {
            val result = authRepository.signIn(login, password)
            if(result.status)
                return@withContext SignInResult(result.status, null)
            else
                return@withContext SignInResult(result.status, result.errorMessage)
        }
    }
}