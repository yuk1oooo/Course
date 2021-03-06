package com.example.android_course.presentation.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_course.domain.LoginModel
import kotlinx.coroutines.launch

class LoginViewModel(private val loginModel: LoginModel): ViewModel() {
    private var login = MutableLiveData<String>()
    private var password = MutableLiveData<String>()

    var status = MutableLiveData<Boolean?>()
    var errorMessage = MutableLiveData<String?>()

    init {
        status.value = false
        errorMessage.value = ""
    }

    fun getAccoutData(login:String, password: String){
        this.login.value = login
        this.password.value = password
    }

    fun getValidation(){
        viewModelScope.launch {
            val validation = loginModel.signIn(login.value!!, password.value!!)
            status.value = validation.status
            errorMessage.value = validation.errorMessage
        }
    }
}