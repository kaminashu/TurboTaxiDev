package com.example.projectone.presentation.ui.sms

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.projectone.R
import com.example.projectone.databinding.FragmentSmsBinding
import com.example.projectone.domain.entities.AuthSmscheck
import com.example.projectone.domain.entities.ChekRequestSmsModel
import com.example.projectone.presentation.FundamentNavActivity
import kotlinx.coroutines.delay
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
        binding.progressBar2.visibility=View.GONE
        tasdiqlash()

    }

    private fun tasdiqlash() {
        binding.submitBtn.setOnClickListener{
            binding.progressBar2.visibility=View.VISIBLE
            val id = bundle.getInt(ID)
            val token = bundle.getInt(TOKEN)
            val code=binding.smsEdt.text.toString()
            binding.submitBtn.isVisible=false
            binding.ortgaBtn.isVisible=false
            lifecycleScope.launch {
                val sms = viewModel.chekSms(token, id, code)
                if(sms.resId==0){
                    val intent=FundamentNavActivity.newIntnet(requireActivity())
                    startActivity(intent)
                }else{
                    Toast.makeText(requireActivity(), "Login yoki parol xato", Toast.LENGTH_SHORT).show()
                }
                binding.submitBtn.isVisible=true
                binding.ortgaBtn.isVisible=true
                binding.progressBar2.visibility=View.GONE
            }

        }
    }


}