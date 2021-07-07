package com.example.android_course.data

import com.example.android_course.domain.IAuthRepository
import com.example.android_course.domain.SignInResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthRepository(private val authService: StubAuthService): IAuthRepository {
    override suspend fun signIn(login: String, password: String): SignInResult {
        val serviceSignIn = authService.signIn(login, password)
        return if (serviceSignIn.success && serviceSignIn.error == null)
            SignInResult(true, null)
        else
            SignInResult(false, serviceSignIn.error)
    }
}