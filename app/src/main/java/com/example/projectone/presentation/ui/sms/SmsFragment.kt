package com.example.projectone.presentation.ui.sms

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projectone.R
import com.example.projectone.databinding.FragmentSmsBinding

class SmsFragment : Fragment() {

    companion object {
        const val ID = "id"
        const val TOKEN = "token"
        fun newInstance(id: Int, token: Int) = SmsFragment().apply {
            arguments = Bundle().apply {
                putInt(ID, id)
                putInt(TOKEN, token)
            }
        }
    }

    private lateinit var viewModel: SmsViewModel
    private lateinit var binding: FragmentSmsBinding
    private lateinit var bundle: Bundle
    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.let {
            bundle = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            FragmentSmsBinding.inflate(LayoutInflater.from(container?.context), container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[SmsViewModel::class.java]
        val token = bundle.getInt(TOKEN)
        Log.d("TAG", "onActivityCreated: $TOKEN")

    }

}