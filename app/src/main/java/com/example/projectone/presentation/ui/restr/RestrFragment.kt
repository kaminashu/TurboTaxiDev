package com.example.projectone.presentation.ui.restr

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projectone.R

class RestrFragment : Fragment() {

    companion object {
        const val TAG="MY_TAG"
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
        viewModel = ViewModelProvider(this)[RestrViewModel::class.java]
   //     Log.d(TAG, "onActivityCreated: ${viewModel.getReestr()}")
    }



}