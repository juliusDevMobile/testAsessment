package com.prueba.proyecfortests.utils

import android.view.View
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

object TestUtils {
    fun waitForView(
        viewInteraction: ViewInteraction, viewMatcher: Matcher<View>,
        additionalConditions: Matcher<View>? = null
    ) {
        val idlingResource = ViewIdlingResource(viewInteraction, viewMatcher, additionalConditions)
        try {
            IdlingRegistry.getInstance().register(idlingResource)
            idlingResource.isIdleNow
        } catch (e: Exception) {
            waitForView(viewInteraction, viewMatcher, additionalConditions)
        } finally {
            IdlingRegistry.getInstance().unregister(idlingResource)
        }
    }
    fun isViewDisplayed(viewInteraction: ViewInteraction): Boolean = try {
        viewInteraction.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        true
    } catch (e: NoMatchingViewException) {
        false
    }

    fun performClearAndSetText(viewInteraction: ViewInteraction, text: String) {
        viewInteraction.perform(
            ViewActions.clearText(),
            ViewActions.typeText(text),
            ViewActions.closeSoftKeyboard()
        )
    }
}