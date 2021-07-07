package com.example.android_course

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_course.di.modelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin{
            androidContext(this@MainActivity)
            modules(modelModule)
        }

        setContentView(R.layout.activity_main)
    }
}