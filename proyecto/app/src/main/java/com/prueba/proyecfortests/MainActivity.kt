package com.prueba.proyecfortests

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.prueba.proyecfortests.databinding.ActivityMainBinding
import com.prueba.proyecfortests.model.User
import com.prueba.proyecfortests.viewmodel.UserViewModel
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {
    private val viewModel:UserViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setClickListener()
    }

    private fun setClickListener() {
        binding.btnUpdateUser.setOnClickListener {
            if (validateFields()) {
                //viewModel.updateUser(getUser())
            } else {
                Toast.makeText(applicationContext, "credenciales invalidas", Toast.LENGTH_LONG)
                    .show()
            }

        }
        binding.btnLoadUser.setOnClickListener {
            if (validateFields()) {
                //viewModel.updateUser(getUser())
            } else {
                Toast.makeText(applicationContext, "Ingrese ID", Toast.LENGTH_LONG).show()
            }

        }
    }

    private fun validateFields(): Boolean {
        return when {
            binding.etId.text.isNullOrEmpty() -> false
            binding.etName.text.isNullOrEmpty() -> false
            binding.tvEmail.text.isNullOrEmpty() -> false
            else -> true
        }
    }

    private fun getUser() =
        User(
            id = binding.etId.text.toString().toInt(),
            name = binding.etName.text.toString(),
            email = binding.etName.text.toString()
        )


}