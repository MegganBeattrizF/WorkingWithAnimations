package com.example.myapplication.presenter.interfaces

import com.example.myapplication.presenter.interfaces.CurrentDebtorStatus.WithEarlyPayment
import com.example.myapplication.presenter.interfaces.CurrentDebtorStatus.WithoutEarlyPayment
import com.example.myapplication.presenter.interfaces.InvoiceStatus.*
import com.example.myapplication.presenter.interfaces.PaymentStatus.*
import com.example.myapplication.presenter.interfaces.PaymentStatus.EligibleForCompulsory

interface PaymentSceneriesViewData {
    fun getSubtitle(response: String): String
    fun getComplementText(response: String): String
    fun getHelperText(response: String): String
    fun getButtonCompulsoryState(response: String): String
    fun getButtonPartialState(response: String): String
    fun getButtonContinueState(response: String): String
}

data class Response(
    var invoiceStatus: InvoiceStatus = Open,
    var currentDebitStatus: CurrentDebtorStatus = WithEarlyPayment(120.00),
    var paymentStatus: PaymentStatus = EligibleForCompulsory,
)

/**
 * se a fatura
 *
 * */

interface InvoiceStatusHab

class WithEarlyPayment(
    private val paymentValue: Double,
    private val earlyPaymentValue: Double,
    private val minimumInvoiceValue: Double,
) {
    fun isPaymentMinimum() {
        val sumValues = paymentValue + earlyPaymentValue
        //if (sumValues > minimumInvoiceValue) HandlerPaymentStatus()
    }
}

class HandlerPaymentStatus(
    private val paymentValue: Double,
    private val invoiceTotalValue: Double,
    private val minimumPaymentMethodsValue: Double,
    private val isCompulsory: Boolean
) {

    fun getStatus() = when {
        isEligibleForCompulsory() -> EligibleForCompulsory
        isEligibleForTotal() -> EligibleForTotal
        isEligibleForPartial() -> EligibleForPartial
        isNotEligible() -> NotEligible
        isEligibleForAnyValue() -> EligibleForAnyValue
        else -> EligibleForMinimum
    }

    private fun isEligibleForCompulsory() = isCompulsory && paymentValue < invoiceTotalValue
    private fun isEligibleForPartial() = isCompulsory.not() && paymentValue < invoiceTotalValue
    private fun isEligibleForTotal() = paymentValue == invoiceTotalValue
    private fun isNotEligible(): Boolean {
        return paymentValue == 0.0
                || paymentValue > invoiceTotalValue
                || paymentValue < minimumPaymentMethodsValue
    }

    private fun isEligibleForAnyValue(): Boolean {
        return paymentValue != invoiceTotalValue || paymentValue == invoiceTotalValue
    }
}

class A(private val response: Response) {
    fun handlerState() {
        when (response.invoiceStatus) {
            is Open -> {}
            is Closed, is Overdue -> {}
        }
    }

    fun handlerCurrentDebtorStatus() {
        //fazer validações na viewModel (tipo se o campo veio null e usar sealed class)
//        when (response.currentDebitStatus) {
//            is WithEarlyPayment -> com.example.myapplication.presenter.interfaces.WithEarlyPayment(
//                response.currentDebitStatus.earlyPaymentValue
//            )
//            is WithoutEarlyPayment -> {}
//        }
    }

    fun handlerPaymentStatus() = when (response.paymentStatus) {
        is EligibleForCompulsory -> {}
        is EligibleForTotal -> {}
        is EligibleForPartial -> {}
        is NotEligible -> {}
        is EligibleForMinimum -> {}
        is EligibleForAnyValue -> {}
    }
}

sealed class CurrentDebtorStatus {
    data class WithEarlyPayment(val earlyPaymentValue: Double) : CurrentDebtorStatus()
    object WithoutEarlyPayment : CurrentDebtorStatus()
}

sealed class InvoiceStatus {
    object Open : InvoiceStatus()
    object Closed : InvoiceStatus()
    object Overdue : InvoiceStatus()
}

sealed class PaymentStatus {
    object EligibleForCompulsory : PaymentStatus()
    object EligibleForTotal : PaymentStatus()
    object EligibleForPartial : PaymentStatus()
    object NotEligible : PaymentStatus()
    object EligibleForMinimum : PaymentStatus()
    object EligibleForAnyValue : PaymentStatus()
}

class EligibleForCompulsory : PaymentSceneriesViewData {
    override fun getSubtitle(response: String): String {
        TODO("Not yet implemented")
    }

    override fun getComplementText(response: String): String {
        TODO("Not yet implemented")
    }

    override fun getHelperText(response: String): String {
        TODO("Not yet implemented")
    }

    override fun getButtonCompulsoryState(response: String): String {
        TODO("Not yet implemented")
    }

    override fun getButtonPartialState(response: String): String {
        TODO("Not yet implemented")
    }

    override fun getButtonContinueState(response: String): String {
        TODO("Not yet implemented")
    }

}