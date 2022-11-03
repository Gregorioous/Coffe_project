package com.example.coffeproject.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.coffeproject.R
import com.example.coffeproject.databinding.ActivityMainBinding
import com.example.coffeproject.presentation.Tabs.Account.Account
import com.example.coffeproject.presentation.Tabs.Card.Card
import com.example.coffeproject.presentation.Tabs.Coffee.Coffee
import com.example.coffeproject.presentation.Tabs.Home
import com.example.coffeproject.presentation.viewModel.CardViewModel
import com.example.coffeproject.presentation.viewModel.CoffeeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private var binding:ActivityMainBinding? = null
    private val coffeeViewModel:CoffeeViewModel by viewModel()
    private val cardViewModel:CardViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        coffeeViewModel.startMigration(this)

        setSupportActionBar(binding?.topMainMenu)

        loadCoffeeToCard()


        supportFragmentManager.beginTransaction().replace(R.id.mainContent, Home()).commit()

        binding?.bottomMainMenu?.setOnItemSelectedListener { item ->

            when(item.itemId) {
                R.id.homeItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.mainContent, Home()).commit()
                R.id.coffeItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.mainContent, Coffee()).commit()
                R.id.cardItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.mainContent, Card()).commit()
                R.id.accountItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.mainContent, Account()).commit()
            }

            return@setOnItemSelectedListener true


        }
        binding?.bottomMainMenu?.selectedItemId = R.id.homeItemBottomNav



    }

    private fun loadCoffeeToCard (){

        cardViewModel.loadCoffeeFromCard.observe(this, Observer {

            val count = it.count()

            val badge = binding?.bottomMainMenu?.getOrCreateBadge(R.id.cardItemBottomNav)

            badge?.isVisible = count>0
            badge?.number = count

        })

}
}