package com.example.realmdatabase


import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.realmdatabase.CustomMatchers.Companion.atPosition
import com.example.realmdatabase.CustomMatchers.Companion.withHint
import com.example.realmdatabase.mainscreen.MainActivity
import org.hamcrest.Matchers.any
import org.hamcrest.Matchers.not
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun checkEmptyContactsScreen() {
        onView(withId(R.id.fabAddContact))
            .check(matches(isDisplayed()))

        onView(withId(R.id.rvContacts))
            .check(matches(isDisplayed()))
            .check(matches(not(hasDescendant(any(View::class.java)))))
    }

    @Test
    fun checkAddContactScreen() {
        onView(withId(R.id.fabAddContact))
            .perform(click())

        onView(withId(R.id.etName))
            .check(matches(isDisplayed()))
            .check(matches(withHint("Имя")))

        onView(withId(R.id.etSurname))
            .check(matches(isDisplayed()))
            .check(matches(withHint("Фамилия")))

        onView(withId(R.id.etNumber))
            .check(matches(isDisplayed()))
            .check(matches(withHint("Номер телефона")))

        onView(withId(R.id.btnSave))
            .check(matches(isDisplayed()))
            .check(matches(withText("Сохранить контакт")))
    }

    @Test
    fun checkAddingContact() {
        onView(withId(R.id.fabAddContact))
            .perform(click())

        onView(withId(R.id.etName))
            .perform(typeText("Nikita"))

        onView(withId(R.id.etSurname))
            .perform(typeText("Panchenko"))

        onView(withId(R.id.etNumber))
            .perform(typeText("+799999990"))

        onView(withId(R.id.btnSave))
            .perform(click())

        pressBack()
        pressBack()

        onView(withId(R.id.rvContacts))
            .check(matches(atPosition(0, hasDescendant(withText("Nikita Panchenko")))))
            .check(matches(atPosition(0, hasDescendant(withText("+799999990")))))
    }
}