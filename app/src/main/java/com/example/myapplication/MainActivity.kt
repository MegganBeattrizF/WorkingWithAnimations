package com.example.myapplication

import android.animation.ValueAnimator
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
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
        simulateBackendProcess()
    }

    private fun simulateBackendProcess() {
        object : CountDownTimer(4000, 1000) {
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
            changeLayersColor(R.color.white)
            repeatCount = ValueAnimator.INFINITE
            playAnimation()
        }
    }

    private fun endLoadingLottieAnimation() {
        with(binding.lottieLoading) {
            setMinAndMaxFrame(238, 418)
            playAnimation()
            addAnimatorUpdateListener { if (frame == 418) pauseAnimation() }
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
    }
}