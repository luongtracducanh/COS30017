package au.edu.swin.sdmd.l03_manyimages

import android.view.View
import android.widget.Button
import android.widget.TextView
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.android.controller.ActivityController



/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(RobolectricTestRunner::class)
class MyActivityTest {
    private lateinit var activityController: ActivityController<MainActivity>
    private lateinit var activity: MainActivity

    @Before
    @Throws(java.lang.Exception::class)
    fun setUp() {
        activity = Robolectric.buildActivity<MainActivity>(MainActivity::class.java).create().get()
    }


    @Test
    fun clickingButton_shouldChangeMessage() {
        val button =
            activity.findViewById<Button>(R.id.station)
        button.performClick()
        val title =
            activity.findViewById<TextView>(R.id.title)
        assertEquals(title.text.toString(),"station")
    }


}
