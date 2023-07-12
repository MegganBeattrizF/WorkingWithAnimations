package com.example.myapplication.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.response.CardBrand
import com.example.myapplication.data.response.CreditCard
import com.example.myapplication.data.response.CreditCardResponse
import com.example.myapplication.presenter.implementation.EloCardData
import com.example.myapplication.presenter.implementation.MastercardCardData
import com.example.myapplication.presenter.implementation.VisaCardData
import com.example.myapplication.presenter.viewdata.CreditCardViewData
import com.example.myapplication.presenter.viewholder.CreditCardTypesViewHolder

class SecondViewModel : ViewModel() {

    private val _cardViewData = MutableLiveData<List<CreditCardViewData>>()
    val cardViewData: LiveData<List<CreditCardViewData>> = _cardViewData

    private val creditCard = CreditCard(
        cardBrand = CardBrand.ELO,
        number = "**** **** **** 3090",
        expirationDate = "09/25",
        userName = "Peter A Lima"
    )
    private val response = CreditCardResponse(
        listOf(
            creditCard,
            creditCard.copy(cardBrand = CardBrand.VISA),
            creditCard.copy(cardBrand = CardBrand.MASTERCARD),
        )
    )

    fun getViewData() = response.apply {
        val data = creditCardData.map {
            val card = when (it.cardBrand) {
                CardBrand.ELO -> EloCardData(it)
                CardBrand.VISA -> VisaCardData(it)
                CardBrand.MASTERCARD -> MastercardCardData(it)
            }
            CreditCardTypesViewHolder(card).setupCardData()
        }
        _cardViewData.postValue(data)
    }
}