package com.example.android_course.data

import com.example.android_course.domain.SignInResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class StubAuthService : IAuthService {
    override suspend fun signIn(login: String, password: String): Pair<SignInResponse?, String?> {
        return withContext(Dispatchers.IO) {
            delay(1000)
            if (!login.isNullOrEmpty() && login == password) Pair(SignInResponse(login, password), null)
            else Pair(null, "wrong data")
        }
    }
}