package rubem.oliota.github.view;


import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;

import rubem.oliota.github.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@LargeTest
public class MainActivityVisibilityChangesInTheActionbarTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityVisibilityChangesInTheActionbarTest() {
        TestUtils.setMobileWifinEnabled(true);
        SystemClock.sleep(5000);
        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.search_button), withContentDescription("Pesquisar"),
                        childAtPosition(
                                allOf(withId(R.id.search_bar),
                                        childAtPosition(
                                                withId(R.id.search),
                                                0)),
                                1),
                        isDisplayed()));
        SystemClock.sleep(3000);
        appCompatImageView.perform(click());
        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Navegar para cima"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        SystemClock.sleep(3000);
        appCompatImageButton.perform(click());
        ViewInteraction appCompatImageView2 = onView(
                allOf(withId(R.id.search_button), withContentDescription("Pesquisar"),
                        childAtPosition(
                                allOf(withId(R.id.search_bar),
                                        childAtPosition(
                                                withId(R.id.search),
                                                0)),
                                1),
                        isDisplayed()));
        SystemClock.sleep(3000);
        appCompatImageView2.perform(click());
        ViewInteraction searchAutoComplete = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete.perform(replaceText("x"), closeSoftKeyboard());

        ViewInteraction appCompatImageView3 = onView(
                allOf(withId(R.id.search_close_btn), withContentDescription("Limpar consulta"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                1),
                        isDisplayed()));
        SystemClock.sleep(3000);
        appCompatImageView3.perform(click());
        ViewInteraction appCompatImageView4 = onView(
                allOf(withId(R.id.search_close_btn), withContentDescription("Limpar consulta"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                1),
                        isDisplayed()));
        SystemClock.sleep(3000);
        appCompatImageView4.perform(click());
        SystemClock.sleep(3000);
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
