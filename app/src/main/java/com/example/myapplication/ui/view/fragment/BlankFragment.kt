package com.example.myapplication.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentBlankBinding

class BlankFragment : BaseFragment<FragmentBlankBinding>() {

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentBlankBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonNavigate.setOnClickListener {
            navigate()
        }
    }

    private fun navigate() {
        val age = 12
        val action = BlankFragmentDirections.actionBlankFragmentToBlankFragment2(age)
        navController.navigate(action)
    }

}