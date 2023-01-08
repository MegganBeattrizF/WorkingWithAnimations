package com.example.myapplication

import android.animation.ValueAnimator
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieProperty
import com.airbnb.lottie.model.KeyPath
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startMotionAnimation()
        startLoadingLottieAnimation()
        object : CountDownTimer(5000, 1000) {
            override fun onTick(secondsUnitlFinish: Long) {}
            override fun onFinish() {
                endMotionAnimation()
                endLoadingLottieAnimation()
            }
        }.start()
    }

    private fun startMotionAnimation() {
        with(binding.motion) {
            getTransition(R.id.loading).duration = 1000
            transitionToState(R.id.endLoading)
        }
    }

    private fun startLoadingLottieAnimation() {
        with(binding.lottieLoading) {
            setMaxFrame(120)
            repeatCount = ValueAnimator.INFINITE
            playAnimation()
            addValueCallback(
                KeyPath("icn-success"), LottieProperty.COLOR
            ) { if (it.startFrame <= 238) Color.MAGENTA else Color.YELLOW }
        }
    }

    private fun endLoadingLottieAnimation() {
        with(binding.lottieLoading) {
            setMinAndMaxFrame(239, 418)
            repeatCount = 0
            playAnimation()
        }
    }

    private fun endMotionAnimation() {
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