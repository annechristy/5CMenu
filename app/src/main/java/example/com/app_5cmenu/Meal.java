package example.com.app_5cmenu;


import java.util.ArrayList;

/**
 * Created by Annie on 10/6/14.
 */
public class Meal {

    String[] menuItems;
    MealTime mealtime;
    String mealtype;
    String hallName;
    int dow;

    public Meal(String diningHallName) {
        hallName = diningHallName;
        mealtime = new MealTime(diningHallName);
        mealtype = mealtime.currentMealType();

        setMenuItems();
    }

    // I dont think this constructor is ever used.
    public Meal(String diningHallName,String mealType, int dayOfWeek) {            // public Meal(String diningHallName, String mealType, int dayOfWeek) { < old one
        hallName = diningHallName;
        dow = dayOfWeek;
        setMenuItems();
    }

    /*
     * Returns the Array that holds the current Menu Items.
     */
    public String[] getMenuItems() {
        return menuItems;
    }

    public void setMenuItems() {   // TURN ALL THIS STUFF INTO CASE STATEMENTS TO
    // OPTIMIZE PERFORMANCE!!!!!!!!!!!!!! <--this might take some thought and reworking of everything to really optimize
        // Get the menu items from the data collector here.

        menuItems = DataCollector.defaultMenu;



        if(hallName.equals("Hoch-Shanahan")) {
           if(mealtype.equals("Breakfast")) {
                menuItems = DataCollector.hochBreakfast;
            }
            else if( mealtype.equals("Brunch")) {
                menuItems = DataCollector.hochBrunch;
            }
            else if(mealtype.equals("Lunch")) {
                menuItems = DataCollector.hochLunch;
            }
            else if(mealtype.equals("Dinner")) {
                menuItems = DataCollector.hochDinner;
            }
            else {
                // do nothing.
            }

        }





        // The following is for testing purposes, we really need to
        // input actual data here.
/*
        menuItems = new String[20];

        menuItems[0] = "ice cream";
        menuItems[1] = "candy";
        menuItems[2] = "lollipops";
        menuItems[3] = "chocolate";
        menuItems[4] = "cake pops";
        menuItems[5] = "nutter-butters";
        menuItems[6] = "lemon bars";
        menuItems[7] = "pixie sticks";
        menuItems[8] = "whipped cream";
        menuItems[9] = "marshmallows";
        menuItems[10] = "candied ginger";
        menuItems[11] = "apple pie";
        menuItems[12] = "fruit cup";
        menuItems[13] = "peppermint sticks";
        menuItems[14] = "soda";
        menuItems[15] = "hot chocolate";
        menuItems[16] = "licorice";
        menuItems[17] = "shaved ice";
        menuItems[18] = "peanut butter";
        menuItems[19] = "brownies";
*/
    }

    public String getMealType() {
        return mealtime.currentMealType();
    }

    /*
     * returns the String version of the time of the meal.
     */
    public String getMealtime() {
        return mealtime.currentMealTime();
    }
}