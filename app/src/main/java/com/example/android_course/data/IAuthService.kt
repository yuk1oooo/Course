package com.example.android_course.data

import com.example.android_course.domain.SignInResponse

interface IAuthService {
    suspend fun signIn(login:String, password: String): Pair<SignInResponse?, String?>
}