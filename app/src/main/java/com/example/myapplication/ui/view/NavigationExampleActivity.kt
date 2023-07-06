package com.example.myapplication.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.NavigationExampleActivityBinding

class NavigationExampleActivity : AppCompatActivity() {

    private val binding by lazy {
        NavigationExampleActivityBinding.inflate(layoutInflater).apply {setContentView(root) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.root
    }
}