package com.example.coffeproject.presentation.Tabs.Account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coffeproject.R
import com.example.coffeproject.databinding.FragmentAccountBinding
import com.example.coffeproject.presentation.Tabs.Account.OrderAdapter
import com.example.coffeproject.presentation.viewModel.OrderLocalViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class Account : Fragment() {

    private var binding: FragmentAccountBinding? = null

    private var orderAdapter: OrderAdapter? = null
    private val orderLocalViewModel:OrderLocalViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_account, container, false)

        initRecyclerOrder()

        loadOrders()

        binding?.clearOrders?.setOnClickListener(View.OnClickListener {
            orderLocalViewModel.clearOrders()
        })

        return binding?.root
    }


    private fun initRecyclerOrder() {

        binding?.listOrders?.layoutManager =
            LinearLayoutManager(context)
        orderAdapter = OrderAdapter()
        binding?.listOrders?.adapter = orderAdapter

    }

    private fun loadOrders() {

        orderLocalViewModel.loadOrder.observe(viewLifecycleOwner, Observer {
            orderAdapter?.setList(it)
            orderAdapter?.notifyDataSetChanged()

        })


    }


}