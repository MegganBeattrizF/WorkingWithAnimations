package com.example.myapplication.ui.view

import android.os.Bundle
import android.view.View.GONE
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.SecondActivityBinding
import com.example.myapplication.presenter.viewdata.CreditCardViewData
import com.example.myapplication.presenter.viewmodel.SecondViewModel
import com.example.myapplication.ui.customview.cardbase.CardBaseState
import com.example.myapplication.ui.customview.cardbase.data.CardBaseData
import com.example.myapplication.ui.customview.creditcard.view.CreditCardView

class SecondActivity : AppCompatActivity() {

    private val viewModel by lazy { SecondViewModel() }

    private val binding by lazy {
        SecondActivityBinding.inflate(layoutInflater).apply { setContentView(root) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        showViews()
        setupCardView()
    }

    private fun showViews() = binding.apply {
        contractView.visibility = GONE
        contractView.setupView(
            CardBaseData(
                title = "Comentários",
                rightIcon = R.drawable.ic_baseline_keyboard_arrow_right_24,
                leftIcon = R.drawable.ic_baseline_comment_24,
                description = "Descreva sua ideia",
            )
        )
        switchCardState.visibility = GONE
        switchCardState.setOnCheckedChangeListener { _, isEnabled ->
            contractView.apply {
                if (isEnabled) setupNewStatus(CardBaseState.Disabled)
                else setupNewStatus(CardBaseState.Enabled)
            }
        }
    }

    private fun setupCardView() = viewModel.apply {
        fun getLinearLayoutParams() = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT,
        )

        fun showCard(data: CreditCardViewData) = CreditCardView(this@SecondActivity).apply {
            setupViewData(data)
            binding.containerCreditCardItems.addView(this, getLinearLayoutParams())
        }

        getViewData()
        cardViewData.observe(this@SecondActivity) { it.forEach(::showCard) }
    }
}