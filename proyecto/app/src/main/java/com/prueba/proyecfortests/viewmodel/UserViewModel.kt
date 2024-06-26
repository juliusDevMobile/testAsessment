package com.prueba.proyecfortests.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prueba.proyecfortests.model.User
import com.prueba.proyecfortests.repository.UserRepository

class UserViewModel(private val userRepository: UserRepository) :
    ViewModel() {
    val userLiveData = MutableLiveData<User?>()
    fun loadUser(userId: Int) {
        val user = userRepository.getUserById(userId)
        userLiveData.value = user
        //Log.e("loadUser: ","loadUser: ${user.toString()}")
    }

    fun updateUser(user: User) {
        userRepository.updateUser(user)
        userLiveData.value = user
        //Log.e("updateUser: ","updateUser: ${user}")
    }
}
