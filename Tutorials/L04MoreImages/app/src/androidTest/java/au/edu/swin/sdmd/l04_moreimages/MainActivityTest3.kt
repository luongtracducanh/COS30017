package au.edu.swin.sdmd.l04_moreimages


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author: Duc Minh Le
 */
@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest3 {

  @Rule
  @JvmField
  var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

  @Test
  fun mainActivityTest3() {
    val materialButton = onView(
      allOf(withId(R.id.college), withText("College")))

    materialButton.perform(click())

    // try different assertions
    val imageView = onView(
      allOf(
        // imageView(contentDescription="college"):
         withId(R.id.imageView), withContentDescription("college")
        // LinearLayout(contentDescription=content):
        // withContentDescription("content")
      )
    ).check(matches(isDisplayed()))
  }
}
