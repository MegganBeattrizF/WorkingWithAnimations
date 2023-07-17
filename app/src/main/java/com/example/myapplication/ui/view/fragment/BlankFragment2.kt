package com.example.myapplication.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentBlank2Binding

class BlankFragment2 : BaseFragment<FragmentBlank2Binding>() {

    private val args: BlankFragment2Args by navArgs()

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentBlank2Binding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textTest.text = args.age.toString()
    }

}