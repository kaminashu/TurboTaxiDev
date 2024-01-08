package com.example.projectone.presentation.ui.registers

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.projectone.R
import com.example.projectone.databinding.FragmentLogInBinding
import com.example.projectone.presentation.FundamentNavActivity
import com.example.projectone.presentation.ui.sms.SmsFragment
import kotlinx.coroutines.launch
import java.lang.RuntimeException

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LogInFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LogInFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val viewModel: RegistersViewModel by lazy {
        ViewModelProvider(this).get(RegistersViewModel::class.java)
    }
    private var _binding: FragmentLogInBinding? = null
    private val binding: FragmentLogInBinding
        get() = _binding ?: throw RuntimeException("Binding null keldi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding =
            FragmentLogInBinding.inflate(LayoutInflater.from(container?.context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.progressBar.visibility = View.GONE
        binding.submitBtn.setOnClickListener {
            binding.submitBtn.isVisible = false
            val login = binding.loginEdt.text.toString()
            val parol = binding.parolEdt.text.toString()
            lifecycleScope.launch {
                binding.progressBar.visibility = View.VISIBLE
                val resp = viewModel.isLogin(login, parol)
                binding.progressBar.visibility = View.GONE
                binding.submitBtn.isVisible = true
                if (resp.mess == RESPONSE_MESSAGE) {
                    val newInstance = SmsFragment.newInstance(
                        id = resp.data?.userIdent?.toInt() ?: UNKOWN,
                        token = resp.data?.isToken?.toInt() ?: UNKOWN
                    )
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, newInstance).commit()
                } else {
                    Toast.makeText(requireActivity(), "Login yoki parol xato", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }


    companion object {
        const val UNKOWN = -1
        private const val RESPONSE_MESSAGE = "Muvaffaqiyat"
        const val STACK_NAME = "Login_Stack"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LogInFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LogInFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}