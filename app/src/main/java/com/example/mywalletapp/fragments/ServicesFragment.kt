package com.example.mywalletapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.mywalletapp.R
import com.example.mywalletapp.adapters.ServicesAdapter
import com.example.mywalletapp.databinding.FragmentServicesBinding
import com.example.mywalletapp.entities.Services
import com.example.mywalletapp.services.App

class ServicesFragment : Fragment() {
    private var _binding: FragmentServicesBinding? = null
    private val binding get() = _binding!!
    private val args: ServicesFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentServicesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val services = App.instance?.getDatabase()?.ServicesDao()?.getAllServices()
        val filteredArray = services?.filter { it.fkCategory == args.categoryId } as ArrayList
        val recyclerView = binding.servicesRecyclerview
        recyclerView.adapter = ServicesAdapter(filteredArray, requireActivity())
    }
}