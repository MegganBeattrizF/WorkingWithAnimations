package com.example.myapplication

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myapplication.ui.view.fragment.BlankFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BlankFragmentTest {

    private val scenario = launchFragmentInContainer<BlankFragment>()

    @Test
    fun testEventFragment() {
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        scenario.onFragment { fragment ->
            // Set the graph on the TestNavHostController
            navController.setGraph(R.navigation.navigation_graph)

            // Make the NavController available via the findNavController() APIs
            Navigation.setViewNavController(fragment.requireView(), navController)

            onView(ViewMatchers.withId(R.id.buttonNavigate)).perform(ViewActions.click())
            assertThat(navController.currentDestination?.id).isEqualTo(R.id.blankFragment2)
        }
    }
}