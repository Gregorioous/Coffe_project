package com.example.coffeproject.presentation.di

import androidx.room.Room
import com.example.coffeproject.data.localDB.DataBaseCoffee
import com.example.coffeproject.data.repository.dataSource.CoffeeApiDataSource
import com.example.coffeproject.data.repository.dataSource.CoffeeDataSource
import com.example.coffeproject.data.repository.dataSourceIMPL.CoffeeApiDataSourceIMPL
import com.example.coffeproject.data.repository.dataSourceIMPL.CoffeeDataSourceIMPL
import com.example.coffeproject.data.repository.repository.CardRepository
import com.example.coffeproject.data.repository.repository.CoffeeRepository
import com.example.coffeproject.data.repository.repository.OrderApiRepository
import com.example.coffeproject.data.repository.repository.OrderLocalRepository
import com.example.coffeproject.domain.repository.CardCall
import com.example.coffeproject.domain.repository.CoffeeCall
import com.example.coffeproject.domain.repository.OrderApiCall
import com.example.coffeproject.domain.repository.OrderLocalCall
import com.example.coffeproject.domain.useCase.CardUseCase
import com.example.coffeproject.domain.useCase.CoffeeUseCase
import com.example.coffeproject.domain.useCase.OrderApiUseCase
import com.example.coffeproject.domain.useCase.OrderLocalUseCase
import com.example.coffeproject.presentation.viewModel.CardViewModel
import com.example.coffeproject.presentation.viewModel.CoffeeViewModel
import com.example.coffeproject.presentation.viewModel.OrderApiViewModel
import com.example.coffeproject.presentation.viewModel.OrderLocalViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val coffee = module{

    single {
        Room.databaseBuilder(androidContext(), DataBaseCoffee::class.java,
            "dbC").build()
    }

    single { get<DataBaseCoffee>().coffeeDao }


    single<CoffeeDataSource> {
        CoffeeDataSourceIMPL(
            get()
        )
    }

    single<CoffeeApiDataSource> {
        CoffeeApiDataSourceIMPL(
            get()
        )
    }

    single<CoffeeCall> { CoffeeRepository(get(),get()) }

    single { CoffeeUseCase(get()) }

    viewModel { CoffeeViewModel(get()) }

}

val card = module{

    single {
        Room.databaseBuilder(androidContext(), DataBaseCoffee::class.java,
            "dbO").build()
    }

    single { get<DataBaseCoffee>().cardDao }


    single<CardCall> { CardRepository(get()) }

    single { CardUseCase(get()) }

    viewModel { CardViewModel(get()) }

}

val order = module{

    single {
        Room.databaseBuilder(androidContext(), DataBaseCoffee::class.java,
            "dbS").build()
    }

    single { get<DataBaseCoffee>().orderLocalDao }


    single<OrderLocalCall> { OrderLocalRepository(get()) }

    single { OrderLocalUseCase(get()) }

    viewModel { OrderLocalViewModel(get()) }

}

val orderApi= module{

    single<OrderApiCall> { OrderApiRepository() }

    single { OrderApiUseCase(get()) }

    viewModel { OrderApiViewModel(get()) }

}

