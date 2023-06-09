package com.example.myapplication.customview.cardbase.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.myapplication.R
import com.example.myapplication.customview.cardbase.CardBaseState
import com.example.myapplication.customview.cardbase.CardBaseState.Disabled
import com.example.myapplication.customview.cardbase.CardBaseState.Enabled
import com.example.myapplication.customview.cardbase.data.CardBaseData
import com.example.myapplication.databinding.CardBaseBinding
import com.example.myapplication.utils.ifDefaultInt

internal class CardBase @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttrs: Int = 0,
) : FrameLayout(context, attrs, defStyleAttrs) {

    private val binding = CardBaseBinding.inflate(
        LayoutInflater.from(context), this, true
    )
    private lateinit var viewData: CardBaseData

    fun setupView(viewData: CardBaseData) {
        this@CardBase.viewData = viewData
        setupEnabledState()
    }

    fun setupNewStatus(state: CardBaseState) {
        setupState(state)
    }

    private fun setupState(state: CardBaseState) = when (state) {
        is Enabled -> setupEnabledState()
        is Disabled -> setupDisabledState()
    }

    private fun setupDisabledState() = with(binding) {
        tvTitle.apply {
            setTextColor(context.getColor(R.color.holo_red_dark))
            text = viewData.title.ifEmpty { "Titulo" }
        }
        ivIconRight.visibility = GONE
        ivIconLeft.setImageResource(R.drawable.ic_baseline_warning_amber_24)
        tvDescription.text = "Feature Desativada"
    }

    private fun setupEnabledState() = with(binding) {
        tvTitle.text = viewData.title.ifEmpty { "Titulo" }
        ivIconRight.apply {
            visibility = VISIBLE
            setImageResource(viewData.rightIcon.ifDefaultInt {
                R.drawable.ic_baseline_no_photography_24
            })
        }
        ivIconLeft.setImageResource(viewData.leftIcon.ifDefaultInt {
            R.drawable.ic_baseline_no_photography_24
        })
        tvDescription.text = viewData.description
    }
}
