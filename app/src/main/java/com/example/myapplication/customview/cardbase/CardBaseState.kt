package com.example.myapplication.customview.cardbase

sealed class CardBaseState {
    object Enabled : CardBaseState()
    object Disabled : CardBaseState()
}