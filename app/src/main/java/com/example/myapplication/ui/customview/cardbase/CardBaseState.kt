package com.example.myapplication.ui.customview.cardbase

sealed class CardBaseState {
    object Enabled : CardBaseState()
    object Disabled : CardBaseState()
}