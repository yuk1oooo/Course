package com.example.android_course.presentation.login

import android.os.Bundle
import android.os.Message
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.android_course.R
import com.example.android_course.databinding.FragmentLoginBinding
import kotlinx.coroutines.delay
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val loginViewModel by viewModel<LoginViewModel>()
    private var status: Boolean = false
    private lateinit var errorMessage: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginViewModel.status.observe(viewLifecycleOwner, Observer { newStatus ->
            if (newStatus != null) {
                status = newStatus
            }
        })
        loginViewModel.errorMessage.observe(viewLifecycleOwner, Observer { newMessage ->
            if (newMessage != null) {
                errorMessage = newMessage
            }
        })

        binding.LoginButton.setOnClickListener {
            loginViewModel.getAccoutData(binding.UsernameEditText.text.toString(), binding.PasswordEditText.text.toString())
            loginViewModel.getValidation()
            binding.UsernameEditText.isEnabled = false
            binding.PasswordEditText.isEnabled = false
            if(status) {
                onClickLoginButton()
            } else {
                Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
                binding.UsernameEditText.isEnabled = true
                binding.PasswordEditText.isEnabled = true
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun onClickLoginButton(){
        Navigation.findNavController(binding.root).navigate(R.id.fromLoginFragmentToWelcomeFragment)
    }
}