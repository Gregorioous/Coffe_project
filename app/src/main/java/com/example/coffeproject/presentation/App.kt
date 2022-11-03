package com.example.coffeproject.presentation

import android.app.Application
import com.example.coffeproject.presentation.di.card
import com.example.coffeproject.presentation.di.coffee
import com.example.coffeproject.presentation.di.order
import com.example.coffeproject.presentation.di.orderApi
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Koin Android logger
            androidLogger()
            //inject Android context
            androidContext(this@App)

            modules(coffee, card, order, orderApi)

        }

    }


}