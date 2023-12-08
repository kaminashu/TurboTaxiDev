package com.example.projectone.presentation.ui.hisobot

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projectone.R

class HisobotFragment : Fragment() {

    companion object {
        fun newInstance() = HisobotFragment()
    }

    private lateinit var viewModel: HisobotViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hisobot, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HisobotViewModel::class.java)
        // TODO: Use the ViewModel
    }

}