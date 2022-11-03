package com.example.coffeproject.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.coffeproject.data.models.CardModel
import com.example.coffeproject.data.models.CoffeeModel
import com.example.coffeproject.data.models.OrderLocalModel

@Database(entities = [CardModel::class, CoffeeModel::class, OrderLocalModel::class], version = 1)
abstract class DataBaseCoffee: RoomDatabase() {
    abstract val cardDao: CardDao
    abstract val coffeeDao: CoffeeDao
    abstract val orderLocalDao: OrderLocalDao

}