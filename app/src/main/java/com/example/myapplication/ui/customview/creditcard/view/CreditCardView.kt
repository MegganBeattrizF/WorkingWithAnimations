package com.example.myapplication.ui.customview.creditcard.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.myapplication.R
import com.example.myapplication.databinding.CreditCardItemBinding
import com.example.myapplication.presenter.viewdata.CreditCardViewData
import com.example.myapplication.utils.ifDefaultInt

class CreditCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttrs: Int = 0,
) : FrameLayout(context, attrs, defStyleAttrs) {

    private val binding = CreditCardItemBinding.inflate(
        LayoutInflater.from(context), this, true
    )

    fun setupViewData(viewData: CreditCardViewData) = viewData.also {
        with(binding) {
            ivIconBrand.setImageResource(it.brandIcon.ifDefaultInt {
                R.drawable.ic_baseline_no_photography_24
            })
            tvCardNumber.text = it.number
            tvUserName.text = it.userName
            tvExpirationDate.text = context.getString(R.string.expiration_label, it.expirationDate)
            containerCardHeader.setBackgroundResource(it.cardColor.ifDefaultInt {
                R.color.blue_hard
            })
        }
    }
}