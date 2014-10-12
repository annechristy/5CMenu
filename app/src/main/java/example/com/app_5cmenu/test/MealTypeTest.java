package example.com.app_5cmenu.test;

import android.test.InstrumentationTestCase;
import example.com.app_5cmenu.Meal;


/**
 * Created by Annie on 10/6/14.
 */
public class MealTypeTest extends InstrumentationTestCase {

    // EXAMPLE TEST

    public void test() throws Exception {
        final int expected = 5;
        final int reality = 5;
        assertEquals(expected, reality);
    }


    // getMealType TESTS

    // Mudd
    public void test_getMealType1_Hoch() throws Exception {
        Meal testMeal = new Meal("Hoch-Shanahan", 5, 17, 25);
        String expectedMealType = "Dinner";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType2_Hoch() throws Exception {
        Meal testMeal = new Meal("Hoch-Shanahan", 1, 17, 25);
        String expectedMealType = "Dinner";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType3_Hoch() throws Exception {
        Meal testMeal = new Meal("Hoch-Shanahan", 3, 6, 7);
        String expectedMealType = "Breakfast";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType4_Hoch() throws Exception {
        Meal testMeal = new Meal("Hoch-Shanahan", 4, 11, 15);
        String expectedMealType = "Lunch";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType5_Hoch() throws Exception {
        Meal testMeal = new Meal("Hoch-Shanahan", 4, 13, 5);
        String expectedMealType = "Dinner";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType6_Hoch() throws Exception {
        Meal testMeal = new Meal("Hoch-Shanahan", 7, 10, 58);
        String expectedMealType = "Brunch";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType7_Hoch() throws Exception {
        Meal testMeal = new Meal("Hoch-Shanahan", 3, 20, 20);
        String expectedMealType = "Dinner";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }



    // Scripps
    public void test_getMealType1_Scripps() throws Exception {
        Meal testMeal = new Meal("Malott Commons", 2, 8, 40);
        String expectedMealType = "Breakfast";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType2_Scripps() throws Exception {
        Meal testMeal = new Meal("Malott Commons", 4, 11, 20);
        String expectedMealType = "Lunch";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType3_Scripps() throws Exception {
        Meal testMeal = new Meal("Malott Commons", 5, 16, 50);
        String expectedMealType = "Dinner";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType4_Scripps() throws Exception {
        Meal testMeal = new Meal("Malott Commons", 1, 12, 50);
        String expectedMealType = "Brunch";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType5_Scripps() throws Exception {
        Meal testMeal = new Meal("Malott Commons", 7, 17, 0);
        String expectedMealType = "Dinner";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType6_Scripps() throws Exception {
        Meal testMeal = new Meal("Malott Commons", 1, 1, 0);
        String expectedMealType = "Brunch";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType7_Scripps() throws Exception {
        Meal testMeal = new Meal("Malott Commons", 4, 15, 8);
        String expectedMealType = "Dinner";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }


    // CMC
    public void test_getMealType1_CMC() throws Exception {
        Meal testMeal = new Meal("Collins", 4, 7, 31);
        String expectedMealType = "Breakfast";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType2_CMC() throws Exception {
        Meal testMeal = new Meal("Collins", 3, 12, 45);
        String expectedMealType = "Lunch";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType3_CMC() throws Exception {
        Meal testMeal = new Meal("Collins", 6, 18, 1);
        String expectedMealType = "Dinner";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType4_CMC() throws Exception {
        Meal testMeal = new Meal("Collins", 1, 12, 29);
        String expectedMealType = "Brunch";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType5_CMC() throws Exception {
        Meal testMeal = new Meal("Collins", 7, 16, 30);
        String expectedMealType = "Dinner";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType6_CMC() throws Exception {
        Meal testMeal = new Meal("Collins", 5, 10, 10);
        String expectedMealType = "Lunch";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType7_CMC() throws Exception {
        Meal testMeal = new Meal("Collins", 4, 2, 2);
        String expectedMealType = "Breakfast";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }


    // Pitzer
    public void test_getMealType1_Pitzer() throws Exception {
        Meal testMeal = new Meal("McConnell", 5, 7, 30);
        String expectedMealType = "Breakfast";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType2_Pitzer() throws Exception {
        Meal testMeal = new Meal("McConnell", 4, 13, 28);
        String expectedMealType = "Lunch";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType3_Pitzer() throws Exception {
        Meal testMeal = new Meal("McConnell", 2, 17, 22);
        String expectedMealType = "Dinner";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType4_Pitzer() throws Exception {
        Meal testMeal = new Meal("McConnell", 1, 11, 0);
        String expectedMealType = "Brunch";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType5_Pitzer() throws Exception {
        Meal testMeal = new Meal("McConnell", 1, 17, 0);
        String expectedMealType = "Dinner";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType6_Pitzer() throws Exception {
        Meal testMeal = new Meal("McConnell", 3, 20, 7);
        String expectedMealType = "Dinner";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType7_Pitzer() throws Exception {
        Meal testMeal = new Meal("McConnell", 6, 13, 30);
        String expectedMealType = "Dinner";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }


    // Frary
    public void test_getMealType1_Frary() throws Exception {
        Meal testMeal = new Meal("Frary", 4, 7, 40);
        String expectedMealType = "Breakfast";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType2_Frary() throws Exception {
        Meal testMeal = new Meal("Frary", 3, 13, 59);
        String expectedMealType = "Lunch";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType3_Frary() throws Exception {
        Meal testMeal = new Meal("Frary", 5, 19, 0);
        String expectedMealType = "Dinner";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType4_Frary() throws Exception {
        Meal testMeal = new Meal("Frary", 1, 13, 29);
        String expectedMealType = "Brunch";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType5_Frary() throws Exception {
        Meal testMeal = new Meal("Frary", 7, 19, 4);
        String expectedMealType = "Dinner";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType6_Frary() throws Exception {
        Meal testMeal = new Meal("Frary", 4, 14, 5);
        String expectedMealType = "Dinner";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType7_Frary() throws Exception {
        Meal testMeal = new Meal("Frary", 1, 9, 0);
        String expectedMealType = "Brunch";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    // Frank
    public void test_getMealType1_Frank1() throws Exception {
        Meal testMeal = new Meal("Frank", 6, 13, 0);
        String expectedMealType = "Closed";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType1_Frank2() throws Exception {
        Meal testMeal = new Meal("Frank", 7, 15, 8);
        String expectedMealType = "Closed";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType1_Frank3() throws Exception {
        Meal testMeal = new Meal("Frank", 3, 7, 30);
        String expectedMealType = "Breakfast";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType1_Frank4() throws Exception {
        Meal testMeal = new Meal("Frank", 4, 11, 15);
        String expectedMealType = "Lunch";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType1_Frank5() throws Exception {
        Meal testMeal = new Meal("Frank", 4, 18, 0);
        String expectedMealType = "Dinner";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType1_Frank6() throws Exception {
        Meal testMeal = new Meal("Frank", 1, 12, 0);
        String expectedMealType = "Brunch";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType1_Frank7() throws Exception {
        Meal testMeal = new Meal("Frank", 1, 17, 30);
        String expectedMealType = "Dinner";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }


    // Oldenborg  (Show lunch all day on days when it is open.
    public void test_getMealType1_Oldenborg1() throws Exception {
        Meal testMeal = new Meal("Oldenborg", 4, 12, 30);
        String expectedMealType = "Lunch";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType1_Oldenborg2() throws Exception {
        Meal testMeal = new Meal("Oldenborg", 1, 12, 30);
        String expectedMealType = "Closed";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType1_Oldenborg3() throws Exception {
        Meal testMeal = new Meal("Oldenborg", 3, 18, 9);
        String expectedMealType = "Lunch";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType1_Oldenborg4() throws Exception {
        Meal testMeal = new Meal("Oldenborg", 3, 3, 9);
        String expectedMealType = "Lunch";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

    public void test_getMealType1_Oldenborg5() throws Exception {
        Meal testMeal = new Meal("Oldenborg", 7, 5, 30);
        String expectedMealType = "Closed";
        String returnedMealType = testMeal.getMealType();
        assertEquals(expectedMealType, returnedMealType);
    }

}

