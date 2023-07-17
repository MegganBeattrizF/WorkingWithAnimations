package com.example.myapplication.presenter.implementation

import com.example.myapplication.R
import com.example.myapplication.data.response.CreditCard
import com.example.myapplication.presenter.interfaces.CreditCardData

class VisaCardData(private val externalData: CreditCard) : CreditCardData {
    override fun getNumber(): String = externalData.number

    override fun getExpirationDate(): String = externalData.expirationDate

    override fun getUserName(): String = externalData.userName

    override fun getBrandIcon(): Int = R.drawable.ic_visa_logo

    override fun getCardColor(): Int = R.color.purple_hard
}