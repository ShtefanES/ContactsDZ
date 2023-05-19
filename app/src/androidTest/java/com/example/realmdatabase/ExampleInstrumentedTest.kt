package com.example.realmdatabase



import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.realmdatabase.mainscreen.MainActivity

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnHolderItem
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.realmdatabase.mainscreen.ContactsAdapter
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.instanceOf

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
    fun checkAllComponentIsVisible_isSuccess() {
        onView(withId(R.id.fabAddContact)) //этот метод найдет для вас View по указанным вами критериям.
            // В нашем случае, мы используем поиск по id (withId).
            .check(matches(isDisplayed()))
            .perform(click()) //действие

        val name = "Nikita"

        onView(withId(R.id.etName)) // находит нужную view
            .check(matches(isDisplayed())) // проверка
            .perform(typeText(name)) // действие
            .check(matches(withText(name))) // проверка

        val surname = "Panchenko"

        onView(withId(R.id.etSurname))
            .check(matches(isDisplayed()))
            .perform(typeText(surname))
            .check(matches(withText(surname)))

        val phone = "+799999999"

        onView(withId(R.id.etNumber))
            .check(matches(isDisplayed()))
            .perform(typeText(phone))
            .check(matches(withText(phone)))

        onView(withId(R.id.btnSave))
            .check(matches(isDisplayed()))
            .perform(click())


           pressBack()
           pressBack()

        onView(withId(R.id.rvContacts))
            .check(matches(isDisplayed()))
            .perform()
      //  onView(withId(R.id.imageView)).perform(click())

       // onView(withId(R.id.changeEtName)).check(matches(isDisplayed()))


    }
}