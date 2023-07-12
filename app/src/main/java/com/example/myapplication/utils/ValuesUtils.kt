package com.example.myapplication.utils

fun Int.ifDefaultInt(defaultValue: () -> Int): Int =
    if (this == 0) defaultValue.invoke() else this