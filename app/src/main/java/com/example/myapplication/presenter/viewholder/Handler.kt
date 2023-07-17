package com.example.myapplication.presenter.viewholder

// Classe abstrata que define a interface para manipular a solicitação
abstract class Handler {
    private var nextHandler: Handler? = null

    fun setNext(handler: Handler) {
        nextHandler = handler
    }

    fun handleRequest(request: String) {
        if (canHandle(request)) println("Request handled by ${javaClass.simpleName}")
        else if (nextHandler != null) nextHandler?.handleRequest(request)
        else println("Request cannot be handled.")
    }

    protected abstract fun canHandle(request: String): Boolean
}

// Implementação concreta dos handlers
class ConcreteHandlerA : Handler() {
    override fun canHandle(request: String): Boolean {
        return request == "A"
    }
}

class ConcreteHandlerB : Handler() {
    override fun canHandle(request: String): Boolean {
        return request == "B"
    }
}

class ConcreteHandlerC : Handler() {
    override fun canHandle(request: String): Boolean {
        return request == "C"
    }
}