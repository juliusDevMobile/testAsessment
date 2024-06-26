package com.prueba.proyecfortests.utils

import android.view.View
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.ViewInteraction
import org.hamcrest.Matcher
import org.hamcrest.Matchers

class ViewIdlingResource(
    private val viewInteraction: ViewInteraction,
    private val viewMatcher: Matcher<View>,
    private val additionalConditions: Matcher<View>? = null
) : IdlingResource {
    private var resourceCallback: IdlingResource.ResourceCallback? = null
    override fun getName(): String = ViewIdlingResource::class.java.name

    override fun isIdleNow(): Boolean {
        val combinedMatcher =
            if (additionalConditions != null) Matchers.allOf(viewMatcher, additionalConditions)
            else viewMatcher
        val endTime = System.currentTimeMillis() + 3000L
        while (System.currentTimeMillis() < endTime) {
            if (combinedMatcher.matches(viewInteraction)) {
                resourceCallback?.onTransitionToIdle()
                return true
            }
            Thread.sleep(100)
        }
        return false
    }

    override fun registerIdleTransitionCallback(resourceCallback: IdlingResource.ResourceCallback) {
        this.resourceCallback = resourceCallback
    }
}