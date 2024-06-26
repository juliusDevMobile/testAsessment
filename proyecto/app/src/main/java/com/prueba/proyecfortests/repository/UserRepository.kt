package com.prueba.proyecfortests.repository

import com.prueba.proyecfortests.model.User

interface UserRepository {
    fun getUserById(id: Int): User?
    fun updateUser(user: User)
}