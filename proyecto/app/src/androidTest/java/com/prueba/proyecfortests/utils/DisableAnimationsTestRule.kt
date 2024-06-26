package com.prueba.proyecfortests.utils

import android.provider.Settings
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class DisableAnimationsTestRule: TestRule {

    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            override fun evaluate() {
                val animationScale = Settings.Global.getFloat(
                    InstrumentationRegistry.getInstrumentation().targetContext.contentResolver,
                    Settings.Global.ANIMATOR_DURATION_SCALE,
                    1.0f
                )
                try {
                    Settings.Global.putFloat(
                        InstrumentationRegistry.getInstrumentation().targetContext.contentResolver,
                        Settings.Global.ANIMATOR_DURATION_SCALE,
                        0.0f
                    )
                    base.evaluate()
                } finally {
                    Settings.Global.putFloat(
                        InstrumentationRegistry.getInstrumentation().targetContext.contentResolver,
                        Settings.Global.ANIMATOR_DURATION_SCALE,
                        animationScale
                    )
                }
            }
        }
    }
}