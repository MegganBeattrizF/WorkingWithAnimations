package com.example.myapplication

import java.util.concurrent.TimeUnit


fun Long.timeMillisToSeconds(): Int {
    return TimeUnit.MILLISECONDS.toSeconds(this).toInt()
}