package com.example.sharedpreferenceapplication

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.sharedpreferenceapplication.databinding.FragmentViewBinding

class ViewFragment : Fragment(){

    private var _binding: FragmentViewBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentViewBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = activity?.getSharedPreferences("USER_DATA", Context.MODE_PRIVATE)!!
        binding.txtUserName.text = sharedPreferences.getString("USER_NAME",null)
        binding.txtIsAdmin.text = if(sharedPreferences.getBoolean("IS_ADMIN_USER",false))"YES" else "NO"
        binding.btnAddUser.setOnClickListener {
            findNavController().navigate(R.id.action_viewFragment_to_addDataFragment)
        }
    }


}