package com.example.myapplication.presenter.viewholder

import com.example.myapplication.presenter.interfaces.CreditCardData
import com.example.myapplication.presenter.viewdata.CreditCardViewData

class CreditCardTypesViewHolder(private val type: CreditCardData) {
    fun setupCardData() = type.run {
        CreditCardViewData(
            number = getNumber(),
            expirationDate = getExpirationDate(),
            userName = getUserName(),
            brandIcon = getBrandIcon(),
            cardColor = getCardColor()
        )
    }
}