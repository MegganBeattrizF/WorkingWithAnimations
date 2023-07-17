package com.example.myapplication.presenter.interfaces

interface CreditCardData {
    fun getNumber(): String
    fun getExpirationDate(): String
    fun getUserName(): String
    fun getBrandIcon(): Int
    fun getCardColor(): Int
}