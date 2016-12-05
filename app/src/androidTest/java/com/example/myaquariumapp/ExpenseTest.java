package com.example.myaquariumapp;

/**
 * Created by Paul on 12/4/2016.
 */

import android.support.test.espresso.ViewInteraction;
import android.support.test.runner.AndroidJUnit4;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class ExpenseTest {

    @Rule
    public ActivityTestRule<AddExpense> mActivityRule =
            new ActivityTestRule<>(AddExpense.class);

    @Test
    public void ensureTextChangesWork() {
        // Type text and then press the button.
        onView(withId(R.id.expenseName))
                .perform(typeText("Test"), closeSoftKeyboard());

        onView(withId(R.id.expenseCost))
                .perform(typeText("13"), closeSoftKeyboard());

        // Check that the text was changed.
        onView(withId(R.id.expenseName)).check(matches(withText("Test")));
        onView(withId(R.id.expenseCost)).check(matches(withText("13")));

        //check radio button
        onView(withId(R.id.radioButton))
                .perform(click());

        onView(withId(R.id.radioButton))
                .check(matches(isChecked()));

        onView(withId(R.id.radioButton2))
                .check(matches(not(isChecked())));

        //click button
        onView(withId(R.id.button)).perform(click());
    }

}
