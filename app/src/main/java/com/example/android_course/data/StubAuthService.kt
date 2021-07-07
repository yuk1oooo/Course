package com.example.android_course.data

import com.example.android_course.domain.SignInResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class StubAuthService : IAuthService {
    override suspend fun signIn(login: String, password: String): SignInResponse {

        delay(1000)
        return if (!login.isNullOrEmpty() && login == password) {
            SignInResponse(true, null)
        }
        else {
            SignInResponse(false, "wrong data")
        }
    }
}