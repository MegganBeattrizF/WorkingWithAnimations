package com.example.myapplication.presenter.implementation

import com.example.myapplication.R
import com.example.myapplication.data.response.CreditCard
import com.example.myapplication.presenter.interfaces.CreditCardData

class MastercardCardData(private val externalData: CreditCard) : CreditCardData {
    override fun getNumber(): String = externalData.number

    override fun getExpirationDate(): String = externalData.expirationDate

    override fun getUserName(): String = externalData.userName

    override fun getBrandIcon(): Int = R.drawable.ic_mastercard_

    override fun getCardColor(): Int = R.color.green_hard
}