package com.example.android.teatime;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;

/**
 * Created by Yuri Levenhagen on 2018-01-10 as part
 * of the Udacity-Google Advanced Android App Development course.
 * <p>
 * The base example code belongs to The Android Open Source Project under the Apache 2.0 licence
 * All code further implemented as part of the course is under the same licence.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@RunWith(AndroidJUnit4.class)
public class MenuActivityScreenTest {

    private static final int GREEN_TEA_INDEX = 1;

    @Rule
    public ActivityTestRule<MenuActivity> mActivityTestRule
            = new ActivityTestRule<>(MenuActivity.class);

    @Test
    public void clickGridView_StartsOrderActivityWithTheSelectedTypeOfTea() {
        onData(anything())
                .inAdapterView(withId(R.id.tea_grid_view))
                .atPosition(GREEN_TEA_INDEX)
                .perform(click());

        onView(withId(R.id.tea_name_text_view))
                .check(matches(withText("Green Tea")));
    }
}
