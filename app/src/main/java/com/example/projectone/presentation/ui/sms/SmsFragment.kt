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
import com.example.projectone.domain.entities.ReestrReqParamsSubModel
import com.example.projectone.domain.entities.ReestrReqSubOrderModel
import com.example.projectone.domain.entities.ReestrRequest
import com.example.projectone.presentation.FundamentNavActivity
import com.example.projectone.presentation.ui.registers.LogInFragment
import com.example.projectone.presentation.ui.restr.RestrFragment.Companion.TAG
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SmsFragment : Fragment() {
    companion object {
        private const val ID = "id"
        private const val TOKEN = "token"
        private const val RESPONSE_ID = 0
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
        binding.progressBar2.visibility = View.GONE
        binding.submitBtn.setOnClickListener {
            tasdiqlash()
        }
        binding.ortgaBtn.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, LogInFragment()).commit()
        }
    }

    private fun tasdiqlash() {
        binding.progressBar2.visibility = View.VISIBLE
        val id = bundle.getInt(ID)
        val token = bundle.getInt(TOKEN)
        val code = binding.smsEdt.text.toString()
        binding.submitBtn.isVisible = false
        binding.ortgaBtn.isVisible = false
        lifecycleScope.launch {
            val sms = viewModel.chekSms(token, id, code)
            /*   val reqRestrParamsSubModel=ReestrReqParamsSubModel(countryId = 13, status = "s1")
               val requestReqSubOrderModel=ReestrReqSubOrderModel(userIdent = id.toString(),action = "order_list",lang = "uz",reqRestrParamsSubModel = reqRestrParamsSubModel,isToken = token.toString())
               val reestrRequest=ReestrRequest(requestReqSubOrderModel = requestReqSubOrderModel)
               val response=viewModel.getReestr(reestrRequest)
               Log.d(TAG, "tasdiqlash: ${response.list?.get(1)?.status}")*/
            if (sms.resId == RESPONSE_ID) {
                val intent = FundamentNavActivity.newIntnet(requireActivity())
                startActivity(intent)
            } else {
                Toast.makeText(requireActivity(), "Login yoki parol xato", Toast.LENGTH_SHORT)
                    .show()
            }
            binding.submitBtn.isVisible = true
            binding.ortgaBtn.isVisible = true
            binding.progressBar2.visibility = View.GONE
        }
    }
}