package com.example.android_course.domain

interface IAuthRepository {
    suspend fun signIn(login:String, password: String): SignInResult
}