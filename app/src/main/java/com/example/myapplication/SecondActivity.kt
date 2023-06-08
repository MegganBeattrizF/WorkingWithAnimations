package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.customview.CardBaseData
import com.example.myapplication.customview.CardBaseState
import com.example.myapplication.databinding.SecondActivityBinding

class SecondActivity : AppCompatActivity() {

    private val binding by lazy {
        SecondActivityBinding.inflate(layoutInflater).apply { setContentView(root) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.contractView.setupView(
            CardBaseData(
                title = "Comentários",
                rightIcon = R.drawable.ic_baseline_keyboard_arrow_right_24,
                leftIcon = R.drawable.ic_baseline_comment_24,
                description = "Descreva sua ideia",
            )
        )
        binding.apply {
            switchCardState.setOnCheckedChangeListener { _, isEnabled ->
                contractView.apply {
                    if (isEnabled) setupNewStatus(CardBaseState.Disabled)
                    else setupNewStatus(CardBaseState.Enabled)
                }
            }
        }

    }
}