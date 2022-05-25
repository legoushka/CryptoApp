package com.example.cryptoapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import io.reactivex.disposables.CompositeDisposable

private val compositeDisposable = CompositeDisposable()
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_price_list)
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
//        viewModel.priceList.observe(this, Observer {
//            Log.d("TEST_OF_LOADING_DATA", "Success in activity: $it ")
//        })
        viewModel.getDetailInfo("BTC").observe(this , Observer {
            viewModel.priceList.observe(this, Observer {
                Log.d("TEST_OF_LOADING_DATA", "Success in activity: $it ")
            })
        })
    }
}