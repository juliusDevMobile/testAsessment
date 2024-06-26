package com.prueba.proyecfortests

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.prueba.proyecfortests.model.User
import com.prueba.proyecfortests.repository.UserRepository
import com.prueba.proyecfortests.viewmodel.UserViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UserTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    @Mock
    private lateinit var userViewModel: UserViewModel
    @Mock
    private lateinit var userRepository: UserRepository

    private var id:Int=0
    private lateinit var name:String
    private lateinit var email:String

    @Before
    fun setUp(){
        MockitoAnnotations.openMocks(this)
        userViewModel = UserViewModel(userRepository)
    }

    @Test
    fun validaUpdateUser(){
        id=1
        name = "name test"
        email = "test@gmail.com"
        userViewModel.updateUser(User(id,name,email))
        Assert.assertEquals(id, userViewModel.userLiveData.value?.id)
        Assert.assertEquals(name, userViewModel.userLiveData.value?.name)
        Assert.assertEquals(email, userViewModel.userLiveData.value?.email)
    }

    @Test
    fun loadUser(){
        val userMocked = User(1,"nombre 1","nombre@gmail.com")
        `when`(userRepository.getUserById(1)).thenReturn(userMocked)
        id=1
        userViewModel.loadUser(id)
        Assert.assertEquals(id, userViewModel.userLiveData.value?.id)
    }
}