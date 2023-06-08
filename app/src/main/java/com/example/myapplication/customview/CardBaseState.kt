package com.example.myapplication.customview

sealed class CardBaseState {
    object Enabled : CardBaseState()
    object Disabled : CardBaseState()
}