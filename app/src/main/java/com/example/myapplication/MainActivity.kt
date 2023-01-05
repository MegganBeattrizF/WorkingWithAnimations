package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.view.View
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startAnimation()
        object : CountDownTimer(5000, 1000) {
            override fun onTick(secondsUnitlFinish: Long) {
                binding.testTimer.text = secondsUnitlFinish.timeMillisToSeconds().toString()
            }
            override fun onFinish() {
                endAnimation()
            }
        }.start()
    }

    private fun Long.timeMillisToSeconds(): Int {
        return TimeUnit.MILLISECONDS.toSeconds(this).toInt()
    }

    private fun startAnimation() {
        with(binding.motion) {
            getTransition(R.id.loading).duration = 1000
            transitionToState(R.id.endLoading)
        }
    }

    private fun endAnimation() {
        with(binding.motion) {
            if (currentState == R.id.endLoading) {
                binding.title.text = getString(R.string.text_end)
                transitionToState(R.id.startFinish)
            }
            getTransition(R.id.finish).duration = 1000
            transitionToState(R.id.end)
        }
        Toast.makeText(this@MainActivity, "Fim da animacao", Toast.LENGTH_LONG).show()
    }
}