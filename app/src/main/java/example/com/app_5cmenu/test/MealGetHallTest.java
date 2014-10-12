package example.com.app_5cmenu.test;

import android.test.InstrumentationTestCase;
import example.com.app_5cmenu.Meal;

/**
 * Created by Annie on 10/6/14.
 */
public class MealGetHallTest extends InstrumentationTestCase {

    // getHall TESTS
    public void test_getHall_Hoch() throws Exception {
        Meal testMeal = new Meal("Hoch-Shanahan", 2, 5, 25);
        String expectedHall = "Hoch-Shanahan";
        String actualHall = testMeal.getHall();
        assertEquals(expectedHall, actualHall);
    }

    public void test_getHall_McConnell() throws Exception {
        Meal testMeal = new Meal("McConnell", 7, 2, 0);
        String expectedHall = "McConnell";
        String actualHall = testMeal.getHall();
        assertEquals(expectedHall, actualHall);
    }

    public void test_getHall_Malott() throws Exception {
        Meal testMeal = new Meal("Malott Commons", 7, 2, 0);
        String expectedHall = "Malott Commons";
        String actualHall = testMeal.getHall();
        assertEquals(expectedHall, actualHall);
    }

    public void test_getHall_Collins() throws Exception {
        Meal testMeal = new Meal("Collins", 7, 2, 0);
        String expectedHall = "Collins";
        String actualHall = testMeal.getHall();
        assertEquals(expectedHall, actualHall);
    }

    public void test_getHall_Frary() throws Exception {
        Meal testMeal = new Meal("Frary", 7, 2, 0);
        String expectedHall = "Frary";
        String actualHall = testMeal.getHall();
        assertEquals(expectedHall, actualHall);
    }

    public void test_getHall_Frank() throws Exception {
        Meal testMeal = new Meal("Frank", 7, 2, 0);
        String expectedHall = "Frank";
        String actualHall = testMeal.getHall();
        assertEquals(expectedHall, actualHall);
    }

    public void test_getHall_Oldenborg() throws Exception {
        Meal testMeal = new Meal("Oldenborg", 7, 2, 0);
        String expectedHall = "Oldenborg";
        String actualHall = testMeal.getHall();
        assertEquals(expectedHall, actualHall);
    }

}
