package au.edu.swin.sdmd.core2_local

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class ExtensionTest {
    class TestLocation(val mainName: Int, val mainImage: Int)

    private var detailName = 0

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun initValidString() {
        detailName = R.id.detail_name
    }

    @Test
    fun changedImageName() {
        val university = TestLocation(R.id.university_caption, R.id.university)
        val station = TestLocation(R.id.station_caption, R.id.station)
        val hall = TestLocation(R.id.hall_caption, R.id.hall)
        val garden = TestLocation(R.id.garden_caption, R.id.garden)
        val testStringArray = arrayOf("Luong", "Trac", "Duc", "Anh")
        val testLocationArray = arrayOf(university, station, hall, garden)

        fun miniTest(testLocation: TestLocation, testString: String) {
            val mainName = onView(withId(testLocation.mainName))
            val mainImage = onView(withId(testLocation.mainImage))
            val detailName = onView(withId(detailName))

            mainImage.perform(ViewActions.click())
            // detailName.perform(replaceText("Uni")) // another method
            detailName.perform(ViewActions.clearText())
            detailName.perform(ViewActions.typeText(testString))
            closeSoftKeyboard()
            pressBack()
            mainName.check(matches(withText(testString)))
        }

        for (i in testLocationArray.indices) miniTest(testLocationArray[i], testStringArray[i])
    }
}