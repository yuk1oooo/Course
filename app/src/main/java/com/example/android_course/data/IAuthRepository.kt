package com.example.android_course.data

import com.example.android_course.domain.SignInResult

interface IAuthRepository {
    suspend fun signIn(login:String, password: String): SignInResult
}