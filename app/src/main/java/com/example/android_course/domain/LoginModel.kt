package com.example.android_course.domain

import com.example.android_course.data.AuthRepository


class LoginModel(private val authRepository: IAuthRepository) {
    suspend fun signIn(login:String, password: String):SignInResult{

        val result = authRepository.signIn(login, password)
        return if(result.status) {
            SignInResult(result.status, null)
        }
        else {
            SignInResult(result.status, result.errorMessage)
        }
    }
}