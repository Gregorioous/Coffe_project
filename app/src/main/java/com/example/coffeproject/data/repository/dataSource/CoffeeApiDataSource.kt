package com.example.coffeproject.data.repository.dataSource

import android.content.Context

interface CoffeeApiDataSource {

    fun startMigration(context: Context)
}