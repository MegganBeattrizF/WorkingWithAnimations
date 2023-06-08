package com.example.myapplication.utils

import java.util.concurrent.TimeUnit


fun Long.timeMillisToSeconds(): Int {
    return TimeUnit.MILLISECONDS.toSeconds(this).toInt()
}