package example.com.app_5cmenu.test;

import android.test.InstrumentationTestCase;
import example.com.app_5cmenu.Meal;

/**
 * Created by Annie on 10/11/14.
 */
public class MealTest extends InstrumentationTestCase {

        public void test() throws Exception {
            final int expected = 5;
            final int reality = 3;
            assertEquals(expected, reality);
        }

    }
