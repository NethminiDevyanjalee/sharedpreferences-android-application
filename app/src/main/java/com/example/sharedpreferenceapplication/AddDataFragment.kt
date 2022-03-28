package com.example.sharedpreferenceapplication

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.sharedpreferenceapplication.databinding.FragmentAddDataBinding
import com.example.sharedpreferenceapplication.databinding.FragmentViewBinding
import java.util.prefs.AbstractPreferences

class AddDataFragment : Fragment() {

    private var _binding: FragmentAddDataBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddDataBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = activity?.getSharedPreferences("USER_DATA", Context.MODE_PRIVATE)!!
        binding.btnSave.setOnClickListener {
            val userName = binding.editTextUserName.text
            val isAdminUser = binding.checkBoxIsAdminUser.isChecked
            sharedPreferences.edit().putString("USER_NAME",userName.toString()).apply()
            sharedPreferences.edit().putBoolean("IS_ADMIN_USER",isAdminUser).apply()
            findNavController().navigate(R.id.action_addDataFragment_to_viewFragment)
        }
    }




}