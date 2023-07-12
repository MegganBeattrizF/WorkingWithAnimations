package com.example.myapplication.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityInsertValueBinding

class InsertValueActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityInsertValueBinding.inflate(layoutInflater).apply { setContentView(root) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // vem do backend em string -> subtitle e complementText
        //vem local -> helperText e apresentacao do botao de  compulsorio ou parcial
    }

}