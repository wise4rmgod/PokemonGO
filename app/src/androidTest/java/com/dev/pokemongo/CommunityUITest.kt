package com.dev.pokemongo


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class CommunityUITest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun communityUITest() {
        val tabView = onView(
allOf(withContentDescription("Community"),
childAtPosition(
childAtPosition(
withId(R.id.tabs),
0),
1),
isDisplayed()))
        tabView.perform(click())
        
        val tabView2 = onView(
allOf(withContentDescription("My Team"),
childAtPosition(
childAtPosition(
withId(R.id.tabs),
0),
2),
isDisplayed()))
        tabView2.perform(click())
        
        val tabView3 = onView(
allOf(withContentDescription("Captured"),
childAtPosition(
childAtPosition(
withId(R.id.tabs),
0),
3),
isDisplayed()))
        tabView3.perform(click())
        
        val tabView4 = onView(
allOf(withContentDescription("My Team"),
childAtPosition(
childAtPosition(
withId(R.id.tabs),
0),
2),
isDisplayed()))
        tabView4.perform(click())
        
        val tabView5 = onView(
allOf(withContentDescription("Community"),
childAtPosition(
childAtPosition(
withId(R.id.tabs),
0),
1),
isDisplayed()))
        tabView5.perform(click())
        
        val textView = onView(
allOf(withText("COMMUNITY"),
withParent(allOf(withContentDescription("Community"),
withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java)))),
isDisplayed()))
        textView.check(matches(withText("COMMUNITY")))
        
        val textView2 = onView(
allOf(withId(R.id.friendtext), withText("Friends"),
withParent(withParent(withId(R.id.friendscard))),
isDisplayed()))
        textView2.check(matches(withText("Friends")))
        
        val textView3 = onView(
allOf(withId(R.id.foestext), withText("Foes"),
withParent(withParent(withId(R.id.foescard))),
isDisplayed()))
        textView3.check(matches(withText("Foes")))
        
        val textView4 = onView(
allOf(withId(R.id.trainer), withText("Wobbuffet"),
withParent(withParent(IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java))),
isDisplayed()))
        textView4.check(matches(withText("Wobbuffet")))
        }
    
    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
    }
