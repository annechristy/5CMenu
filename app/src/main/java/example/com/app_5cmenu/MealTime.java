package example.com.app_5cmenu;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Annie on 10/11/14. This class handles time calculations, using a Gregorian
 * Calendar, and can determine what meal is currently happening at a hall or what time a
 * meal is at a specific hall for a specific meal.
 */
public class MealTime {

    String diningHall;
    int hallNum;
    String mealType;
    String mealtime;

    GregorianCalendar cal;
    int year;
    int month;
    int day;
    int hour;
    int min;

    /*
     * This constructor creates a mealtime that represents the current meal
     * at the specified dining hall.
     */
    /*
    public MealTime(String diningHallName) {
        diningHall = diningHallName;
        //setHallNum();
        setTime();

        mealType = currentMealType();
        if (mealType.equals("Breakfast")) {
            mealtime = breakfastTime();
        } else if (mealType.equals("Lunch")) {
            mealtime = lunchTime();
        } else if (mealType.equals("Dinner")) {
            mealtime = dinnerTime();
        } else if (mealType.equals("Brunch")) {
            mealtime = brunchTime();
        } else {
            mealtime = "ERROR";
        }

    }*/

    public MealTime(int hallNumber) {
        hallNum = hallNumber;
    }

    public void setTime() {
        cal = (GregorianCalendar) Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_WEEK);
        hour = cal.get(Calendar.HOUR_OF_DAY);
        min = cal.get(Calendar.MINUTE);
    }


    /*
     * Return the string representing the time of the current meal
     * depending on the current time and the selected hall.
     */
    public String currentMealTime() {
        String curType = currentMealType();

        if (curType.equals("Breakfast")) {
            return this.breakfastTime();
        }
        else if (curType.equals("Lunch")) {
            return this.lunchTime();
        }
        else if (curType.equals("Dinner")) {
            return this.dinnerTime();
        }
        else if (curType.equals("Brunch")) {
            return this.brunchTime();
        } else {
            return "ERROR";
        }
    }

    /*
     * Depending on the dining hall, this will return the correct
     * "current" mealtype to display.
     */
    public String currentMealType() {

        switch (hallNum) {
            case 1:  // the hoch
                // weekends
                if(day == 1 || day == 7) {
                    if(hour < 12 || (hour == 12 && min < 45)) {
                        return "Brunch";  // Brunch
                    } else {
                        return "Dinner";  // Dinner
                    }
                } else {    // Weekdays
                    if(hour < 9 || (hour == 9 && min < 30)) {
                        return "Breakfast";  // Breakfast
                    }
                    else if(hour < 13 || (hour == 13 && min < 0)) {
                        return "Lunch";  // Lunch
                    } else {
                        return "Dinner";  // Dinner
                    }
                }
            case 2:  // scripps
                // weekends
                if(day == 1 || day == 7) {
                    if(hour < 13 || (hour == 13 && min < 0)) {
                        return "Brunch";  // Brunch
                    } else {
                        return "Dinner";  // Dinner
                    }
                } else {    // Weekdays
                    if(hour < 9 || (hour == 9 && min < 0)) {
                        return "Breakfast";  // Breakfast
                    }
                    else if(hour < 13 || (hour == 13 && min < 0)) {
                        return "Lunch";  // Lunch
                    } else {
                        return "Dinner";  // Dinner
                    }
                }
            case 3:  // cmc
                // weekends
                if(day == 1 || day == 7) {
                    if(hour < 12 || (hour == 12 && min < 30)) {
                        return "Brunch";  // Brunch
                    } else {
                        return "Dinner";  // Dinner
                    }
                } else {    // Weekdays
                    if(hour < 9 || (hour == 9 && min < 30)) {
                        return "Breakfast";  // Breakfast
                    }
                    else if(hour < 13 || (hour == 13 && min < 30)) {
                        return "Lunch";  // Lunch
                    } else {
                        return "Dinner";  // Dinner
                    }
                }
            case 4:  // pitzer
                // weekends
                if(day == 1 || day == 7) {
                    if(hour < 12 || (hour == 12 && min < 30)) {
                        return "Brunch";  // Brunch
                    } else {
                        return "Dinner";  // Dinner
                    }
                } else {    // Weekdays
                    if(hour < 9 || (hour == 9 && min < 30)) {
                        return "Breakfast";  // Breakfast
                    }
                    else if(hour < 13 || (hour == 13 && min < 30)) {
                        return "Lunch";  // Lunch
                    } else {
                        return "Dinner";  // Dinner
                    }
                }
            case 5:  // frank

                // weekends
                if(day == 1 ) {
                    if(hour < 13 || (hour == 13 && min < 0)) {
                        return "Brunch";  // Brunch
                    } else {
                        return "Dinner";  // Dinner
                    }
                }
                else if(day == 7 || day == 6){
                    return "Closed"; // The hall is closed.
                } else {    // Weekdays
                    if(hour < 10 || (hour == 10 && min < 0)) {
                        return "Breakfast";  // Breakfast
                    }
                    else if(hour < 13 || (hour == 13 && min < 0)) {
                        return "Lunch";  // Lunch
                    } else {
                        return "Dinner";  // Dinner
                    }
                }

            case 6:  // frary
                // weekends
                if(day == 1 || day == 7) {
                    if(hour < 13 || (hour == 13 && min < 30)) {
                        return "Brunch";  // Brunch
                    } else {
                        return "Dinner";  // Dinner
                    }
                } else {    // Weekdays
                    if(hour < 10 || (hour == 10 && min < 0)) {
                        return "Breakfast";  // Breakfast
                    }
                    else if(hour < 14 || (hour == 14 && min < 0)) {
                        return "Lunch";  // Lunch
                    } else {
                        return "Dinner";  // Dinner
                    }
                }
            case 7:  // oldenborg
                // weekends
                if(day == 1 || day == 7) {
                    return "Closed";
                } else {    // Weekdays
                    return "Lunch";
                }

        }
        return null;
    }

    public int getMealTypeNum() {
        if (this.currentMealType().equals("Breakfast")) {
            return 1;
        }
        else if (this.currentMealType().equals("Lunch")) {
            return 2;
        }
        else if (this.currentMealType().equals("Dinner")) {
            return 3;
        }
        else if (this.currentMealType().equals("Brunch")) {
            return 4;
        }
        else {
            return -1;
        }
    }

    /*
     * For ease of conditionals and switch statements,
     * use the following ints to refer to dining halls
     * by hallNum.
     *
     * Hoch-Shanahan    1
     * Malott Commons   2
     * Collins          3
     * McConnell        4
     * Frank            5
     * Frary            6
     * Oldenborg        7
     */
    /*
    private void setHallNum() {
        if (diningHall.equals("Hoch-Shanahan")) {
            hallNum = 1;
        }
        else if (diningHall.equals("Malott Commons")) {
            hallNum = 2;
        }
        else if (diningHall.equals("Collins")) {
            hallNum = 3;
        }
        else if (diningHall.equals("McConnell")) {
            hallNum = 4;
        }
        else if (diningHall.equals("Frank")) {
            hallNum = 5;
        }
        else if (diningHall.equals("Frary")) {
            hallNum = 6;
        }
        else if (diningHall.equals("Oldenborg")) {
            hallNum = 7;
        } else {
            hallNum = -1; // Not a dining hall error code...
        }
    }
*/

    /*
     * Return the String that represents breakfast time at the hall.
     */
    public String breakfastTime() {

        switch (hallNum) {
            case 1:  // the hoch
                return "7:30 - 9:30";
            case 2:  // scripps
                return "7:30 - 9:30";
            case 3:  // cmc
                return "7:30 - 9:00";
            case 4:  // pitzer
                return "7:30 - 9:00";
            case 5:  // frank
                if(day == 6) {
                    return "closed";
                }
                return "7:30 - 10:00";
            case 6:  // frary
                return "7:30 - 10:00";
            case 7:  // oldenborg
                return "closed";

        }

        return null;
    }

    /*
     * Return the String that represents lunch time at the hall.
     */
    public String lunchTime() {
        switch (hallNum) {
            case 1:  // the hoch
                return "11:15 - 1:00";
            case 2:  // scripps
                return "11:15 - 1:30";
            case 3:  // cmc
                return "11:00 - 1:00";
            case 4:  // pitzer
                return "11:15 - 1:30";
            case 5:  // frank
                if(day == 6) {
                    return "closed";
                }
                return "11:30 - 1:00";
            case 6:  // frary
                return "11:00 - 2:00";
            case 7:  // oldenborg
                return "12:00 - 1:00";

        }
        return null;
    }

    /*
     * Return the String that represents dinner time at the hall.
     */
    public String dinnerTime() {
        switch (hallNum) {
            case 1:  // the hoch
                return "5:00 - 7:00";
            case 2:  // scripps
                if(day == 1 || day == 7) {
                    return "5:00 - 6:30";
                }
                return "4:45 - 7:00";
            case 3:  // cmc
                if(day == 1 || day == 7) {
                    return "4:30 - 6:30";
                }
                return "5:00 - 7:00";
            case 4:  // pitzer
                if(day == 1 || day == 7) {
                    return "5:00 - 6:30";
                }
                return "5:00 - 7:30";
            case 5:  // frank
                if(day == 6 || day == 7) {
                    return "closed";
                } else if (day == 1) {
                    return "5:30 - 7:00";
                }
                return "5:00 - 7:00";
            case 6:  // frary
                return "5:00 - 8:00";
            case 7:  // oldenborg
                return "closed";
        }
        return null;
    }


    /*
     * Return the String that represents brunch time at the hall.
     */
    public String brunchTime() {
        switch (hallNum) {
            case 1:  // the hoch
                return "10:30 - 12:45";
            case 2:  // scripps
                return "10:45 - 1:00";
            case 3:  // cmc
                return "10:30 - 12:30";
            case 4:  // pitzer
                return "10:30 - 12:30";
            case 5:  // frank
                if(day == 7) {
                    return "closed";
                }
                return "11:00 - 1:00";
            case 6:  // frary
                return "10:30 - 1:30";
            case 7:  // oldenborg
                return "closed";
        }
        return null;
    }
}
