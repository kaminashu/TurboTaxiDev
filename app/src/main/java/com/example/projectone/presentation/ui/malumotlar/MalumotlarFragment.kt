package com.example.projectone.presentation.ui.malumotlar

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projectone.R
import com.example.projectone.databinding.FragmentMalumotlarBinding
import java.lang.RuntimeException

class MalumotlarFragment : Fragment() {

    companion object {
        fun newInstance() = MalumotlarFragment()
    }

    private var _binfing: FragmentMalumotlarBinding? = null
    private val binding: FragmentMalumotlarBinding
        get() = _binfing ?: throw RuntimeException("Viloyatlar binding kelmadi")

    private val viewModel: MalumotlarViewModel by lazy {
        ViewModelProvider(this).get(MalumotlarViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binfing = FragmentMalumotlarBinding.inflate(
            LayoutInflater.from(container?.context),
            container,
            false
        )

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.text.observe(viewLifecycleOwner) {
            binding.malumotlarFragmentTextId.text = it
        }
        // TODO: Use the ViewModel
    }

}