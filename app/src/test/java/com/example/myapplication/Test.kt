package com.example.myapplication

data class User(
    val nome: String,
    val idade: String,
    val email: String,
    val endereco: Endereco,
)

data class Endereco(
    val rua: String,
    val cidade: String,
    val pais: String
)
