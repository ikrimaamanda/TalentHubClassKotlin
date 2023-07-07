package com.example.talenthubapp.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.talenthubapp.R
import com.example.talenthubapp.databinding.FragmentBBlankBinding


class BBlankFragment : Fragment() {

    private var _binding : FragmentBBlankBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentBBlankBinding.inflate(inflater, container, false)
        return binding.root
    }



}