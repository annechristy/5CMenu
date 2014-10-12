package example.com.app_5cmenu;

import java.util.Vector;

/**
 * Created by Annie on 10/6/14.
 */
public class Meal {

    String hall;
    String meal;
    Vector<String> menuItems;

    int day;
    int hour;
    int minute;

    /*
     * Note that hours are in 24 hour time. Enter the time that it is currently.
     */
    public Meal(String diningHall, int dy, int hr, int min) {
        // some code goes here
        hall = diningHall;
        day = dy;
        hour = hr;
        minute = min;
    }

    /*
     * Returns the type of meal (i.e. Breakfast, Lunch, Dinner, Brunch)
     * as calculated by the day and time that was passed to the Meal
     * object in the constructor. Return type is String.
     */
    public String getMealType() {
        // some code goes here
        if (hall.equals("Hoch-Shanahan")) {
            // weekends
            if(day == 1 || day == 7) {
                if(hour < 12 || (hour == 12 && minute < 45)) {
                    return "Brunch";  // Brunch
                } else {
                    return "Dinner";  // Dinner
                }
            } else {    // Weekdays
                if(hour < 9 || (hour == 9 && minute < 30)) {
                    return "Breakfast";  // Breakfast
                }
                else if(hour < 13 || (hour == 13 && minute < 0)) {
                    return "Lunch";  // Lunch
                } else {
                    return "Dinner";  // Dinner
                }
            }
        }
        else if (hall.equals("Malott Commons")) {
            // weekends
            if(day == 1 || day == 7) {
                if(hour < 13 || (hour == 13 && minute < 0)) {
                    return "Brunch";  // Brunch
                } else {
                    return "Dinner";  // Dinner
                }
            } else {    // Weekdays
                if(hour < 9 || (hour == 9 && minute < 0)) {
                    return "Breakfast";  // Breakfast
                }
                else if(hour < 13 || (hour == 13 && minute < 0)) {
                    return "Lunch";  // Lunch
                } else {
                    return "Dinner";  // Dinner
                }
            }
        }
        else if (hall.equals("McConnell")) {
            // weekends
            if(day == 1 || day == 7) {
                if(hour < 12 || (hour == 12 && minute < 30)) {
                    return "Brunch";  // Brunch
                } else {
                    return "Dinner";  // Dinner
                }
            } else {    // Weekdays
                if(hour < 9 || (hour == 9 && minute < 30)) {
                    return "Breakfast";  // Breakfast
                }
                else if(hour < 13 || (hour == 13 && minute < 30)) {
                    return "Lunch";  // Lunch
                } else {
                    return "Dinner";  // Dinner
                }
            }
        }
        else if (hall.equals("Collins")) {
            // weekends
            if(day == 1 || day == 7) {
                if(hour < 12 || (hour == 12 && minute < 30)) {
                    return "Brunch";  // Brunch
                } else {
                    return "Dinner";  // Dinner
                }
            } else {    // Weekdays
                if(hour < 9 || (hour == 9 && minute < 0)) {
                    return "Breakfast";  // Breakfast
                }
                else if(hour < 13 || (hour == 13 && minute < 0)) {
                    return "Lunch";  // Lunch
                } else {
                    return "Dinner";  // Dinner
                }
            }
        }
        else if (hall.equals("Frary")) {
            // weekends
            if(day == 1 || day == 7) {
                if(hour < 13 || (hour == 13 && minute < 30)) {
                    return "Brunch";  // Brunch
                } else {
                    return "Dinner";  // Dinner
                }
            } else {    // Weekdays
                if(hour < 10 || (hour == 10 && minute < 0)) {
                    return "Breakfast";  // Breakfast
                }
                else if(hour < 14 || (hour == 14 && minute < 0)) {
                    return "Lunch";  // Lunch
                } else {
                    return "Dinner";  // Dinner
                }
            }
        }
        else if (hall.equals("Oldenborg")) {
            // weekends
            if(day == 1 || day == 7) {
                return "Closed";
            } else {    // Weekdays
                return "Lunch";
            }
        }
        else if (hall.equals("Frank")) {
            // weekends
            if(day == 1 ) {
                if(hour < 13 || (hour == 13 && minute < 0)) {
                    return "Brunch";  // Brunch
                } else {
                    return "Dinner";  // Dinner
                }
            }
            else if(day == 7 || day == 6){
                return "Closed"; // The hall is closed.
            } else {    // Weekdays
                if(hour < 10 || (hour == 10 && minute < 0)) {
                    return "Breakfast";  // Breakfast
                }
                else if(hour < 13 || (hour == 13 && minute < 0)) {
                    return "Lunch";  // Lunch
                } else {
                    return "Dinner";  // Dinner
                }
            }
        }

        return "implement me";
    }

    /*
     * Returns the day of the meal according to
     * the day to int code that the Android Calendar
     * Class uses.
     */
    public int getDay() {
        // some code goes here
        return day;
    }

    /*
     * Returns the hour of the meal within the day
     * (12 hour clock) when the meal begins.
     */
    public int getStartHour() {
        // some code goes here

        if (hall.equals("Hoch-Shanahan")) {
            // weekends
            if(day == 1 || day == 7) {
                if(hour < 12 || (hour == 12 && minute < 45)) {
                    return 10;  // Brunch
                } else {
                    return 5;  // Dinner
                }
            } else {    // Weekdays
                if(hour < 9 || (hour == 9 && minute < 30)) {
                    return 7;  // Breakfast
                }
                else if(hour < 13 || (hour == 13 && minute < 0)) {
                    return 11;  // Lunch
                } else {
                    return 5;  // Dinner
                }
            }
        }
        else if (hall.equals("Malott Commons")) {
            // weekends
            if(day == 1 || day == 7) {
                if(hour < 13 || (hour == 13 && minute < 0)) {
                    return 10;  // Brunch
                } else {
                    return 4;  // Dinner
                }
            } else {    // Weekdays
                if(hour < 9 || (hour == 9 && minute < 0)) {
                    return 7;  // Breakfast
                }
                else if(hour < 13 || (hour == 13 && minute < 0)) {
                    return 11;  // Lunch
                } else {
                    return 4;  // Dinner
                }
            }
        }
        else if (hall.equals("McConnell")) {
            // weekends
            if(day == 1 || day == 7) {
                if(hour < 12 || (hour == 12 && minute < 30)) {
                    return 10;  // Brunch
                } else {
                    return 5;  // Dinner
                }
            } else {    // Weekdays
                if(hour < 9 || (hour == 9 && minute < 30)) {
                    return 7;  // Breakfast
                }
                else if(hour < 13 || (hour == 13 && minute < 30)) {
                    return 11;  // Lunch
                } else {
                    return 5;  // Dinner
                }
            }
        }
        else if (hall.equals("Collins")) {
            // weekends
            if(day == 1 || day == 7) {
                if(hour < 12 || (hour == 12 && minute < 30)) {
                    return 10;  // Brunch
                } else {
                    return 4;  // Dinner
                }
            } else {    // Weekdays
                if(hour < 9 || (hour == 9 && minute < 0)) {
                    return 7;  // Breakfast
                }
                else if(hour < 13 || (hour == 13 && minute < 0)) {
                    return 11;  // Lunch
                } else {
                    return 5;  // Dinner
                }
            }
        }
        else if (hall.equals("Frary")) {
            // weekends
            if(day == 1 || day == 7) {
                if(hour < 13 || (hour == 13 && minute < 30)) {
                    return 10;  // Brunch
                } else {
                    return 5;  // Dinner
                }
            } else {    // Weekdays
                if(hour < 10 || (hour == 10 && minute < 0)) {
                    return 7;  // Breakfast
                }
                else if(hour < 14 || (hour == 14 && minute < 0)) {
                    return 11;  // Lunch
                } else {
                    return 5;  // Dinner
                }
            }
        }
        else if (hall.equals("Oldenborg")) {
            // weekends
            if(day == 1 || day == 7) {
                return -1; // Error code for when the hall is closed.
            } else {    // Weekdays
                return 12;
            }
        }
        else if (hall.equals("Frank")) {
            // weekends
            if(day == 1 ) {
                if(hour < 13 || (hour == 13 && minute < 0)) {
                    return 11;  // Brunch
                } else {
                    return 5;  // Dinner
                }
            }
            else if(day == 7 || day == 6){
                return -1; // The hall is closed.
            } else {    // Weekdays
                if(hour < 10 || (hour == 10 && minute < 0)) {
                    return 7;  // Breakfast
                }
                else if(hour < 13 || (hour == 13 && minute < 0)) {
                    return 11;  // Lunch
                } else {
                    return 5;  // Dinner
                }
            }
        }

        return 100;
    }

    /*
     * Returns the minute of the meal within the hour
     * when the meal begins.
     */
    public int getStartMinute() {
        // some code goes here
        if (hall.equals("Hoch-Shanahan")) {
            // weekends
            if(day == 1 || day == 7) {
                if(hour < 12 || (hour == 12 && minute < 45)) {
                    return 30;  // Brunch
                } else {
                    return 0;  // Dinner
                }
            } else {    // Weekdays
                if(hour < 9 || (hour == 9 && minute < 30)) {
                    return 30;  // Breakfast
                }
                else if(hour < 13 || (hour == 13 && minute < 0)) {
                    return 15;  // Lunch
                } else {
                    return 0;  // Dinner
                }
            }
        }
        else if (hall.equals("Malott Commons")) {
            // weekends
            if(day == 1 || day == 7) {
                if(hour < 13 || (hour == 13 && minute < 0)) {
                    return 5;  // Brunch
                } else {
                    return 0;  // Dinner
                }
            } else {    // Weekdays
                if(hour < 9 || (hour == 9 && minute < 0)) {
                    return 30;  // Breakfast
                }
                else if(hour < 13 || (hour == 13 && minute < 0)) {
                    return 15;  // Lunch
                } else {
                    return 45;  // Dinner
                }
            }
        }
        else if (hall.equals("McConnell")) {
            // weekends
            if(day == 1 || day == 7) {
                if(hour < 12 || (hour == 12 && minute < 30)) {
                    return 30;  // Brunch
                } else {
                    return 0;  // Dinner
                }
            } else {    // Weekdays
                if(hour < 9 || (hour == 9 && minute < 30)) {
                    return 30;  // Breakfast
                }
                else if(hour < 13 || (hour == 13 && minute < 30)) {
                    return 15;  // Lunch
                } else {
                    return 0;  // Dinner
                }
            }
        }
        else if (hall.equals("Collins")) {
            // weekends
            if(day == 1 || day == 7) {
                if(hour < 12 || (hour == 12 && minute < 30)) {
                    return 30;  // Brunch
                } else {
                    return 30;  // Dinner
                }
            } else {    // Weekdays
                if(hour < 9 || (hour == 9 && minute < 0)) {
                    return 30;  // Breakfast
                }
                else if(hour < 13 || (hour == 13 && minute < 0)) {
                    return 0;  // Lunch
                } else {
                    return 0;  // Dinner
                }
            }
        }
        else if (hall.equals("Frary")) {
            // weekends
            if(day == 1 || day == 7) {
                if(hour < 13 || (hour == 13 && minute < 30)) {
                    return 30;  // Brunch
                } else {
                    return 0;  // Dinner
                }
            } else {    // Weekdays
                if(hour < 10 || (hour == 10 && minute < 0)) {
                    return 30;  // Breakfast
                }
                else if(hour < 14 || (hour == 14 && minute < 0)) {
                    return 0;  // Lunch
                } else {
                    return 0;  // Dinner
                }
            }
        }
        else if (hall.equals("Oldenborg")) {
            // weekends
            if(day == 1 || day == 7) {
                return -1; // Error code for when the hall is closed.
            } else {    // Weekdays
                return 0;
            }
        }
        else if (hall.equals("Frank")) {
            // weekends
            if(day == 1 ) {
                if(hour < 13 || (hour == 13 && minute < 0)) {
                    return 0;  // Brunch
                } else {
                    return 30;  // Dinner
                }
            }
            else if(day == 7 || day == 6){
                return -1; // The hall is closed.
            } else {    // Weekdays
                if(hour < 10 || (hour == 10 && minute < 0)) {
                    return 30;  // Breakfast
                }
                else if(hour < 13 || (hour == 13 && minute < 0)) {
                    return 30;  // Lunch
                } else {
                    return 0;  // Dinner
                }
            }
        }

        return 100;
    }

    /*
     * Returns the hour of the meal within the day
     * (12 hour clock) when the meal ends.
     */
    public int getEndHour() {
        // some code goes here
        if (hall.equals("Hoch-Shanahan")) {
            // weekends
            if(day == 1 || day == 7) {
                if(hour < 12 || (hour == 12 && minute < 45)) {
                    return 12;  // Brunch
                } else {
                    return 7;  // Dinner
                }
            } else {    // Weekdays
                if(hour < 9 || (hour == 9 && minute < 30)) {
                    return 9;  // Breakfast
                }
                else if(hour < 13 || (hour == 13 && minute < 0)) {
                    return 1;  // Lunch
                } else {
                    return 7;  // Dinner
                }
            }
        }
        else if (hall.equals("Malott Commons")) {
            // weekends
            if(day == 1 || day == 7) {
                if(hour < 13 || (hour == 13 && minute < 0)) {
                    return 1;  // Brunch
                } else {
                    return 6;  // Dinner
                }
            } else {    // Weekdays
                if(hour < 9 || (hour == 9 && minute < 0)) {
                    return 9;  // Breakfast
                }
                else if(hour < 13 || (hour == 13 && minute < 0)) {
                    return 1;  // Lunch
                } else {
                    return 7;  // Dinner
                }
            }
        }
        else if (hall.equals("McConnell")) {
            // weekends
            if(day == 1 || day == 7) {
                if(hour < 12 || (hour == 12 && minute < 30)) {
                    return 12;  // Brunch
                } else {
                    return 6;  // Dinner
                }
            } else {    // Weekdays
                if(hour < 9 || (hour == 9 && minute < 30)) {
                    return 9;  // Breakfast
                }
                else if(hour < 13 || (hour == 13 && minute < 30)) {
                    return 1;  // Lunch
                } else {
                    return 7;  // Dinner
                }
            }
        }
        else if (hall.equals("Collins")) {
            // weekends
            if(day == 1 || day == 7) {
                if(hour < 12 || (hour == 12 && minute < 30)) {
                    return 12;  // Brunch
                } else {
                    return 6;  // Dinner
                }
            } else {    // Weekdays
                if(hour < 9 || (hour == 9 && minute < 0)) {
                    return 9;  // Breakfast
                }
                else if(hour < 13 || (hour == 13 && minute < 0)) {
                    return 1;  // Lunch
                } else {
                    return 7;  // Dinner
                }
            }
        }
        else if (hall.equals("Frary")) {
            // weekends
            if(day == 1 || day == 7) {
                if(hour < 13 || (hour == 13 && minute < 30)) {
                    return 1;  // Brunch
                } else {
                    return 8;  // Dinner
                }
            } else {    // Weekdays
                if(hour < 10 || (hour == 10 && minute < 0)) {
                    return 10;  // Breakfast
                }
                else if(hour < 14 || (hour == 14 && minute < 0)) {
                    return 2;  // Lunch
                } else {
                    return 8;  // Dinner
                }
            }
        }
        else if (hall.equals("Oldenborg")) {
            // weekends
            if(day == 1 || day == 7) {
                return -1; // Error code for when the hall is closed.
            } else {    // Weekdays
                return 1;
            }
        }
        else if (hall.equals("Frank")) {
            // weekends
            if(day == 1 ) {
                if(hour < 13 || (hour == 13 && minute < 0)) {
                    return 1;  // Brunch
                } else {
                    return 7;  // Dinner
                }
            }
            else if(day == 7 || day == 6){
                return -1; // The hall is closed.
            } else {    // Weekdays
                if(hour < 10 || (hour == 10 && minute < 0)) {
                    return 10;  // Breakfast
                }
                else if(hour < 13 || (hour == 13 && minute < 0)) {
                    return 1;  // Lunch
                } else {
                    return 7;  // Dinner
                }
            }
        }

        return 100;
    }

    /*
     * Returns the minute of the meal within the hour
     * when the meal ends.
     */
    public int getEndMinute() {
        // some code goes here
        if (hall.equals("Hoch-Shanahan")) {
            // weekends
            if(day == 1 || day == 7) {
                if(hour < 12 || (hour == 12 && minute < 45)) {
                    return 30;  // Brunch
                } else {
                    return 0;  // Dinner
                }
            } else {    // Weekdays
                if(hour < 9 || (hour == 9 && minute < 30)) {
                    return 30;  // Breakfast
                }
                else if(hour < 13 || (hour == 13 && minute < 0)) {
                    return 0;  // Lunch
                } else {
                    return 0;  // Dinner
                }
            }
        }
        else if (hall.equals("Malott Commons")) {
            // weekends
            if(day == 1 || day == 7) {
                if(hour < 13 || (hour == 13 && minute < 0)) {
                    return 0;  // Brunch
                } else {
                    return 30;  // Dinner
                }
            } else {    // Weekdays
                if(hour < 9 || (hour == 9 && minute < 0)) {
                    return 30;  // Breakfast
                }
                else if(hour < 13 || (hour == 13 && minute < 0)) {
                    return 30;  // Lunch
                } else {
                    return 0;  // Dinner
                }
            }
        }
        else if (hall.equals("McConnell")) {
            // weekends
            if(day == 1 || day == 7) {
                if(hour < 12 || (hour == 12 && minute < 30)) {
                    return 30;  // Brunch
                } else {
                    return 30;  // Dinner
                }
            } else {    // Weekdays
                if(hour < 9 || (hour == 9 && minute < 30)) {
                    return 30;  // Breakfast
                }
                else if(hour < 13 || (hour == 13 && minute < 30)) {
                    return 30;  // Lunch
                } else {
                    return 30;  // Dinner
                }
            }
        }
        else if (hall.equals("Collins")) {
            // weekends
            if(day == 1 || day == 7) {
                if(hour < 12 || (hour == 12 && minute < 30)) {
                    return 30;  // Brunch
                } else {
                    return 30;  // Dinner
                }
            } else {    // Weekdays
                if(hour < 9 || (hour == 9 && minute < 0)) {
                    return 0;  // Breakfast
                }
                else if(hour < 13 || (hour == 13 && minute < 0)) {
                    return 0;  // Lunch
                } else {
                    return 0;  // Dinner
                }
            }
        }
        else if (hall.equals("Frary")) {
            // weekends
            if(day == 1 || day == 7) {
                if(hour < 13 || (hour == 13 && minute < 30)) {
                    return 30;  // Brunch
                } else {
                    return 0;  // Dinner
                }
            } else {    // Weekdays
                if(hour < 10 || (hour == 10 && minute < 0)) {
                    return 0;  // Breakfast
                }
                else if(hour < 14 || (hour == 14 && minute < 0)) {
                    return 0;  // Lunch
                } else {
                    return 0;  // Dinner
                }
            }
        }
        else if (hall.equals("Oldenborg")) {
            // weekends
            if(day == 1 || day == 7) {
                return -1; // Error code for when the hall is closed.
            } else {    // Weekdays
                return 0;
            }
        }
        else if (hall.equals("Frank")) {
            // weekends
            if(day == 1 ) {
                if(hour < 13 || (hour == 13 && minute < 0)) {
                    return 0;  // Brunch
                } else {
                    return 0;  // Dinner
                }
            }
            else if(day == 7 || day == 6){
                return -1; // The hall is closed.
            } else {    // Weekdays
                if(hour < 10 || (hour == 10 && minute < 0)) {
                    return 30;  // Breakfast
                }
                else if(hour < 13 || (hour == 13 && minute < 0)) {
                    return 30;  // Lunch
                } else {
                    return 0;  // Dinner
                }
            }
        }

        return 100;
    }

    /*
     * Returns the mealTime nicely formatted as a String.
     * Looks something like "7:00 - 9:30"
     */
    public String mealTime(String mealtype) {
        // some code goes here
        int startHour = this.getStartHour();
        int startMin = this.getStartMinute();
        int endHour = this.getEndHour();
        int endMin = this.getEndMinute();
        return startHour + ":" + startMin + " - " + endHour + ":" + endMin;
    }

    /*
     * Populate the menuItems Vector with the options for that
     * meal. Using a vector allows it to change in size.
     *
     * Takes in a String[] and the items within it should be
     * added to the Vector.
     */
    public void setMenuItems(String[] foodArray) {
        // some code goes here
    }

    /*
     * Turn the menuItems Vector into an Array, and return
     * the array.
     */
    public String[] getMenuItems() {
        // some code goes here
        return null;
    }

    /*
     * Return the name of the dining hall.
     */
    public String getHall() {
        // some code goes here
        return hall;
    }

}
