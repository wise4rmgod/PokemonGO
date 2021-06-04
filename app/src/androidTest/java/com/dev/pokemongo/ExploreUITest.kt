package com.dev.pokemongo


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class ExploreUITest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun exploreUITest() {
        
        val imageView = onView(
allOf(withContentDescription("Zoom in"),
withParent(withParent(IsInstanceOf.instanceOf(android.widget.RelativeLayout::class.java))),
isDisplayed()))
        imageView.check(matches(isDisplayed()))
        
        val imageView2 = onView(
allOf(withContentDescription("Zoom out"),
withParent(withParent(IsInstanceOf.instanceOf(android.widget.RelativeLayout::class.java))),
isDisplayed()))
        imageView2.check(matches(isDisplayed()))
        
        val textView = onView(
allOf(withText("COMMUNITY"),
withParent(allOf(withContentDescription("Community"),
withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java)))),
isDisplayed()))
        textView.check(matches(withText("COMMUNITY")))
        
        val linearLayout = onView(
allOf(withContentDescription("My Team"),
withParent(withParent(withId(R.id.tabs))),
isDisplayed()))
        linearLayout.check(matches(isDisplayed()))
        
        val textView2 = onView(
allOf(withText("CAPTURED"),
withParent(allOf(withContentDescription("Captured"),
withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java)))),
isDisplayed()))
        textView2.check(matches(withText("CAPTURED")))
        
        val textView3 = onView(
allOf(withText("CAPTURED"),
withParent(allOf(withContentDescription("Captured"),
withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java)))),
isDisplayed()))
        textView3.check(matches(withText("CAPTURED")))
        }
    }
