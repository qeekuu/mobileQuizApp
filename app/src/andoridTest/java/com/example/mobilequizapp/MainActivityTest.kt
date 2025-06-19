package com.example.mobilequizapp

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun launchMainActivity() {
        // Uruchomienie Activity i natychmiastowe zamknięcie
        ActivityScenario.launch(MainActivity::class.java).use { scenario ->
            // Można dodać asercje, np. czy jakiś widok jest widoczny:
            // onView(withId(R.id.textQuestionNumber)).check(matches(isDisplayed()))
        }
    }
}

