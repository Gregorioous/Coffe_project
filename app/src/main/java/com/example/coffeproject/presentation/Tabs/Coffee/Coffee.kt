package com.example.coffeproject.presentation.Tabs.Coffee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coffeproject.R
import androidx.lifecycle.Observer
import com.example.coffeproject.data.models.CoffeeModel
import com.example.coffeproject.databinding.CoffeeBinding
import com.example.coffeproject.presentation.viewModel.CardViewModel
import com.example.coffeproject.presentation.viewModel.CoffeeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class Coffee : Fragment() {

    private var binding: CoffeeBinding? = null
    private var coffeeAdapter: CoffeeAdapter? = null
    private val coffeeViewModel: CoffeeViewModel by viewModel()
    private val cardViewModel: CardViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.coffee, container, false)

        initRecyclerCoffee()
        loadCoffee()

        return binding?.root
    }

    private fun initRecyclerCoffee() {

        binding?.catalogCoffee?.layoutManager =
            LinearLayoutManager(context)
        coffeeAdapter =
            CoffeeAdapter ({coffeeModel: CoffeeModel ->
                addToCard(
                    coffeeModel
                )
            }, { coffeeModel: CoffeeModel ->
                removeFromCard(
                    coffeeModel
                )
            }, { idProduct: Int, addToBasket: AppCompatImageButton,
                 removeFromBasket: AppCompatImageButton ->
                loadCoffeeToCardFromCardProduct(
                    idProduct, addToBasket, removeFromBasket
                )
            })
        binding?.catalogCoffee?.adapter = coffeeAdapter

    }

    private fun loadCoffee() {

        coffeeViewModel.loadCoffee.observe(viewLifecycleOwner, Observer {
            coffeeAdapter?.setList(it)
            coffeeAdapter?.notifyDataSetChanged()
        })


    }
    private fun addToCard(coffeeModel: CoffeeModel){
            cardViewModel.startInsert(coffeeModel.name,coffeeModel.image,coffeeModel.price,coffeeModel.id.toString(),
                "1")

    }
    private fun removeFromCard(coffeeModel: CoffeeModel){
        cardViewModel.deleteProductToCardFromCardProduct(coffeeModel.id.toString(),)

    }
    private fun loadCoffeeToCardFromCardProduct (idProduct:Int, addToBasket: AppCompatImageButton,
                                                 removeFromBasket:AppCompatImageButton) {
        cardViewModel.loadCoffeeToCardFromCardProduct(idProduct.toString()).observe(viewLifecycleOwner, Observer {

            val count = it.count()

            if (count>0) {
                addToBasket.visibility = View.GONE
                removeFromBasket.visibility = View.VISIBLE
            }
            else {
                addToBasket.visibility = View.VISIBLE
                removeFromBasket.visibility = View.GONE }
        })

    }

}