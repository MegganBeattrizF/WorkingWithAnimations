package com.example.myapplication.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityInsertValueBinding
import com.example.myapplication.presenter.viewholder.ConcreteHandlerA
import com.example.myapplication.presenter.viewholder.ConcreteHandlerB
import com.example.myapplication.presenter.viewholder.ConcreteHandlerC

class InsertValueActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityInsertValueBinding.inflate(layoutInflater).apply { setContentView(root) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val handlerA = ConcreteHandlerA()
        val handlerB = ConcreteHandlerB()
        val handlerC = ConcreteHandlerC()

        handlerA.setNext(handlerB)
        handlerB.setNext(handlerC)

        handlerA.handleRequest("B") // A solicitação é tratada pelo handler B
        handlerA.handleRequest("D") // Nenhum handler pode tratar a solicitação

        // vem do backend em string -> subtitle e complementText
        //vem local -> helperText e apresentacao do botao de  compulsorio ou parcial
    }

}