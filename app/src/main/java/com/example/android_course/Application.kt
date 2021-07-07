package com.example.android_course

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_course.di.loginModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin{
            androidContext(this@Application)
            modules(loginModule)
        }

        setContentView(R.layout.activity_main)
    }
}