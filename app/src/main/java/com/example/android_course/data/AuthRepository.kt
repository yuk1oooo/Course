package com.example.android_course.data

import com.example.android_course.domain.SignInResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthRepository(private val authService: StubAuthService): IAuthRepository {
    override suspend fun signIn(login: String, password: String): SignInResult {
        return withContext(Dispatchers.IO){
            val serviceSignIn =authService.signIn(login, password)
            if(serviceSignIn.first != null && serviceSignIn.second == null)
                return@withContext SignInResult(true, null)
            else
                return@withContext SignInResult(false, serviceSignIn.second)
        }
    }
}