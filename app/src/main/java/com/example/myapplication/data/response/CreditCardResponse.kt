package com.example.myapplication.data.response

data class CreditCardResponse(
    val creditCardData: List<CreditCard>
)

data class CreditCard(
    val cardBrand: CardBrand,
    val number: String,
    val expirationDate: String,
    val userName: String
)

enum class CardBrand {
    ELO,
    MASTERCARD,
    VISA;
}
