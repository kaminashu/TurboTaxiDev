package com.example.projectone.presentation.ui.sms

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.projectone.R
import com.example.projectone.databinding.FragmentSmsBinding
import com.example.projectone.domain.entities.AuthSmscheck
import com.example.projectone.domain.entities.ChekRequestSmsModel
import kotlinx.coroutines.launch

class SmsFragment : Fragment() {

    companion object {
        private const val ID = "id"
        private const val TOKEN = "token"
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
    ): View {
        binding =
            FragmentSmsBinding.inflate(LayoutInflater.from(container?.context), container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[SmsViewModel::class.java]
        val token = bundle.getInt(TOKEN)
        val id = bundle.getInt(ID)
        val auth = AuthSmscheck(
            userIdent = id.toString(),
            smsCode = "30697",
            lang = "uz",
            isToken = token.toString()
        )
        val chekRequestSmsModel = ChekRequestSmsModel(auth)
        lifecycleScope.launch {
            val chekSms = viewModel.chekSms(chekRequestSmsModel)
            Log.d("My_TAG", "onActivityCreated: " + chekSms.mess)
        }
        Log.d("My_TAG", "onActivityCreated: $token and $id")

    }

}