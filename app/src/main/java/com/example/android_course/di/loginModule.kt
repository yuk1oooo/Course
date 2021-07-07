package com.example.android_course.di

import com.example.android_course.data.AuthRepository
import com.example.android_course.data.IAuthService
import com.example.android_course.data.StubAuthService
import com.example.android_course.domain.IAuthRepository
import com.example.android_course.domain.LoginModel
import com.example.android_course.domain.SignInResponse
import com.example.android_course.domain.SignInResult
import com.example.android_course.presentation.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {
    viewModel { LoginViewModel(get()) }
    single { LoginModel(get()) }
    single<IAuthRepository> { AuthRepository(get()) }
    single<IAuthService> { StubAuthService() }
}
