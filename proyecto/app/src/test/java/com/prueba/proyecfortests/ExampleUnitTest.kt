package com.prueba.proyecfortests

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.prueba.proyecfortests.model.User
import com.prueba.proyecfortests.repository.UserRepository
import com.prueba.proyecfortests.viewmodel.UserViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}