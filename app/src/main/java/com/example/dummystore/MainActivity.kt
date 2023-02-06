package com.example.dummystore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.dummystore.api.Items
import com.example.dummystore.api.RetrofitInstance
import com.example.dummystore.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNew.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
            finish()
        }



        getData()

    }

    private fun getData() {
        var id = intent.getStringExtra("id")


        RetrofitInstance.apiinterface.getData(id.toString()).enqueue(object : Callback<Items> {
            override fun onResponse(call: Call<Items>, response: Response<Items>) {
                binding.tvName.text = response.body()!!.title!!
                binding.tvDescription.text = response.body()!!.description!!
                binding.tvprice.text = "${response.body()!!.price}$"!!
                Glide.with(this@MainActivity).load(response.body()!!.thumbnail).into(binding.imageView!!)
                binding.progressBar.isVisible = false
            }

            override fun onFailure(call: Call<Items>, t: Throwable) {
                Toast.makeText(this@MainActivity,"ERROR",Toast.LENGTH_LONG).show()
            }

        })
    }
}
