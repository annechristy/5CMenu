package example.com.app_5cmenu;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;


public class MenuPage extends Activity {


    TextView DiningHallTextView;
    TextView MealTextView;
    TextView MealTimeTextView;
    ListView hochMealListView;

    String diningHallData;
    int hallDataNum;

    GregorianCalendar cal;
    int year;
    int month;
    int day;
    int hour;
    int minute;

    int numMenuItems = 15;
    String[] menuItemsArray = new String[numMenuItems];
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);


        // Set the time
        this.setTime();

        System.out.println("year: " + year + " day: " + day + " hour: " + hour + ":" + minute); // for testing



        // Set the food in the ListView
        this.setMenuItemsArray();

        // Use these to dynamically change text views
        DiningHallTextView = (TextView) findViewById(R.id.hall_textview);
        diningHallData = getIntent().getStringExtra("hall_data");
        DiningHallTextView.setText(diningHallData);

        hallDataNum = getIntent().getIntExtra("hall_data_num", 0);

        MealTextView = (TextView) findViewById(R.id.meal_textview);
        MealTextView.setText(this.getMeal(day, hour, minute, hallDataNum));

        MealTimeTextView = (TextView) findViewById(R.id.meal_time_textview);
        MealTimeTextView.setText(getMealTimeString(day, hour, minute, hallDataNum));


        // initialize the adapter
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menuItemsArray);
        hochMealListView= (ListView) findViewById(R.id.hoch_breakfast_listview);
        hochMealListView.setAdapter(adapter);

    }

    public void setTime() {
        cal = (GregorianCalendar) Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_WEEK);
        hour = cal.get(Calendar.HOUR_OF_DAY);
        minute = cal.get(Calendar.MINUTE);
    }

    public String getHochMeal(int d, int h, int m) {
        // If it is the weekend (should eventually account for holidays too).
        if(d == 7 || d == 1) {
            if(h < 12 || (h ==12 && m < 45)){
                return "Brunch";
            } else {
                return "Dinner";
            }
        }
        // On a weekday
        else {

            if(h < 9 || (h == 9 && m < 30)) {
                return "Breakfast";
            }
            else if (h < 13 ) {
                return "Lunch";
            } else {
                return "Dinner";
                // Right now it defaults to the previous dinner, and doesn't wrap to the
                // next day's breakfast. What do we want to do?
            }
        }
    }

    public static String getScrippsMeal(int d, int h, int m) {
        return "implement me!";
    }

    public String getCmcMeal(int d, int h, int m) {
        return "implement me!";
    }

    public String getPitzerMeal(int d, int h, int m) {
        return "implement me!";
    }

    public String getFrankMeal(int d, int h, int m) {
        return "implement me!";
    }

    public String getFraryMeal(int d, int h, int m) {
        return "implement me!";
    }

    public String getOldenborgMeal(int d, int h, int m) {
        return "implement me!";
    }



    // Write some unit tests for this!!!
    public String getMeal(int d, int h, int m, int hallNumber) {

        switch (hallNumber) {
            case 1:  // the hoch
                return getHochMeal(d, h, m);
            case 2:  // scripps
                return getScrippsMeal(d,h,m);
            case 3:  // cmc
                return getCmcMeal(d,h,m);
            case 4:  // pitzer
                return getPitzerMeal(d,h,m);
            case 5:  // frank
                return getFrankMeal(d,h,m);
            case 6:  // frary
                return getFraryMeal(d,h,m);
            case 7:  // oldenborg
                return getOldenborgMeal(d,h,m);

        }

        // I need more information about when the halls are open....

        // If it is the weekend (should eventually account for holidays too.
        /*
        if(d == 7 || d == 1) {

            if(hallNumber == 1) {
                if(h < 12 || (h ==12 && m < 45)){
                    return "Brunch";
                } else {
                    return "Dinner";
                }
            } else {
                return "NOT THE HOCH";
            }
        }
        // On a weekday
        else {
            if(hallNumber == 1) {
                if(h < 9 || (h == 9 && m < 30)) {
                    return "Breakfast";
                }
                else if (h < 13 ) {
                    return "Lunch";
                } else {
                    return "Dinner";
                    // Right now it defaults to the previous dinner, and doesn't wrap to the
                    // next day's breakfast. What do we want to do?
                }
            } else {
                return "NOT THE HOCH";
            }
        }*/
        return "nope";
    }


    // Write some unit tests for this!!!
    public String getMealTimeString(int d, int h, int m, int hallNumber) {
        // I need more information about when the halls are open....

        // If it is the weekend (should eventually account for holidays too.
        if(d == 7 || d == 1) {
            if(hallNumber == 1) {
                if(h < 12 || (h ==12 && m < 45)){
                    return "10:30 - 12:45";
                } else {
                    return "5:00 - 7:00";
                }
            } else {
                return "NOT THE HOCH";
            }
        }
        // On a weekday
        else {
            if(hallNumber == 1) {
                if(h < 9 || (h == 9 && m < 30)) {
                    return "7:30 - 9:30";
                }
                else if (h < 13 ) {
                    return "11:15 - 1:00";
                } else {
                    return "5:00 - 7:00";
                    // Right now it defaults to the previous dinner, and doesn't wrap to the
                    // next day's breakfast. What do we want to do?
                }
            } else {
                return "NOT THE HOCH";
            }
        }

    }


    public void setMenuItemsArray() {
        // Once I know the format of my data, I should set it here more dynamically.

        // Set the menu items in the array. Hard-coded for now, until I get the hang of this.
        menuItemsArray[0] = "pickles";
        menuItemsArray[1] = "pasta bar";
        menuItemsArray[2] = "oatmeal";
        menuItemsArray[3] = "curry";
        menuItemsArray[4] = "ice cream";
        menuItemsArray[5] = "bread";
        menuItemsArray[6] = "apples";
        menuItemsArray[7] = "pizza";
        menuItemsArray[8] = "turnips";
        menuItemsArray[9] = "lima beans";
        menuItemsArray[10] = "dragon fruit";
        menuItemsArray[11] = "rice pudding";
        menuItemsArray[12] = "sushi";
        menuItemsArray[13] = "bacon";
        menuItemsArray[14] = "lettuce";

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
