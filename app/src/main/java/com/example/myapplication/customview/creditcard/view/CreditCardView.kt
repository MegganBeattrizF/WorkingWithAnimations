package com.example.myapplication.customview.creditcard.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.myapplication.R
import com.example.myapplication.databinding.CreditCardItemBinding
import com.example.myapplication.presenter.viewdata.CreditCardViewData
import com.example.myapplication.utils.ifDefaultInt

class CreditCardView(
    context: Context,
    attrs: AttributeSet,
    defStyleAttrs: Int = 0,
) : FrameLayout(context, attrs, defStyleAttrs) {

    private val binding = CreditCardItemBinding.inflate(
        LayoutInflater.from(context), this, true
    )

    fun setupViewData(viewData: List<CreditCardViewData>) = viewData.apply {
        viewData.forEach {
            binding.apply {
                ivIconBrand.setImageResource(it.brandIcon.ifDefaultInt {
                    R.drawable.ic_baseline_no_photography_24
                })
                tvCardNumber.text = it.number
                tvUserName.text = it.userName
                tvExpirationDate.text = it.expirationDate
                cvCredit.setCardBackgroundColor(it.cardColor.ifDefaultInt {
                    R.color.blue_hard
                })
            }
        }
    }
}