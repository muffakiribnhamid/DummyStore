package com.example.dummystore

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.dummystore.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            val id = binding.etId.text.toString()

                if (id == null || id.isNullOrEmpty() || id.toInt() > 100 ) {
                    Toast.makeText(this@MainActivity2, "Please Enter Id from 1-100", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("id", id)
                    startActivity(intent)
                }
            }

        }
    }
