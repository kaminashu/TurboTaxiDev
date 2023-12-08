package com.example.projectone.presentation.ui.restr

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projectone.R

class RestrFragment : Fragment() {

    companion object {
        fun newInstance() = RestrFragment()
    }

    private lateinit var viewModel: RestrViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_restr, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RestrViewModel::class.java)
        // TODO: Use the ViewModel
    }

}