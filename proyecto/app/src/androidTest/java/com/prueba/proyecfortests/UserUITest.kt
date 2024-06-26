package com.prueba.proyecfortests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.prueba.proyecfortests.utils.TestUtils.isViewDisplayed
import com.prueba.proyecfortests.utils.TestUtils.performClearAndSetText
import com.prueba.proyecfortests.utils.TestUtils.waitForView
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserUITest {

    val etId = onView(withId(R.id.etId))
    val etName = onView(withId(R.id.etName))
    val etEmail = onView(withId(R.id.etEmail))
    val btnUpdateUser = onView(withId(R.id.btnUpdateUser))
    val btnLoadUser = onView(withId(R.id.btnLoadUser))

    @get:Rule
    val activityTestRule get() = ActivityScenarioRule(MainActivity::class.java)

    /*@get:Rule
    val disableAnimationsRule: TestRule get() = DisableAnimationsTestRule()*/

    @Test
    fun saveUser(){
        waitForView(etId, isDisplayed())
        if(isViewDisplayed(etId))
            performClearAndSetText(etId,"1")

        waitForView(etName, isDisplayed())
        if(isViewDisplayed(etName))
            performClearAndSetText(etName,"usuario")

        waitForView(etEmail, isDisplayed())
        if(isViewDisplayed(etEmail))
            performClearAndSetText(etEmail,"test@gmail.com")

        waitForView(btnUpdateUser, isDisplayed())
        if(isViewDisplayed(btnUpdateUser))
            btnUpdateUser.perform(ViewActions.click())
    }

    @Test
    fun laodUser(){
        waitForView(etId, isDisplayed())
        if(isViewDisplayed(etId))
            performClearAndSetText(etId,"1")

        waitForView(btnLoadUser, isDisplayed())
        if(isViewDisplayed(btnLoadUser))
            btnLoadUser.perform(ViewActions.click())
    }

}