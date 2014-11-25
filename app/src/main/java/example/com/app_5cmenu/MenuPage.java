package example.com.app_5cmenu;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.GregorianCalendar;
//import java.util.Locale;
//import java.util.TimeZone;


public class MenuPage extends Activity {

   // Current hall and meal objects.
   // DiningHall selectedHall;
    //Meal currentMeal;
    MealTime mealTime;

    int mealNum = -1;

    // TextViews and ListViews used to dynamically update screens.
    TextView DiningHallTextView;
    TextView MealTextView;
    TextView MealTimeTextView;
    ListView MealListView;

    // This allows for conversion from a String[] to a scrolling list.
    ArrayAdapter<String> adapter;

    // Data from the home page button click.
    String hallDataStr;
    int hallDataNum;

   // Figure out how to change this more dynamically!!! maybe with a vector?
    String[] menuItemsArray;


    // Dining Hall Numbers (hallDataNum):
    // hall 1 = Hoch
    // hall 2 = Malott
    // hall 3 = Collins
    // hall 4 = McConnell
    // hall 5 = Frank
    // hall 6 = Frary
    // hall 7 = Oldenborg

    // Meal Type Numbers (mealNum):
    // breakfast = 1
    // lunch     = 2
    // dinner    = 3
    // brunch    = 4


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);

        //System.out.println("Franky stuff" + DataCollector.frankBreakfast);
        //System.out.println(DataCollector.frankBrunch);
        //System.out.println(DataCollector.frankLunch);
        //System.out.println(DataCollector.frankDinner);


        // Get information from the home page.
        hallDataStr = getIntent().getStringExtra("hall_data");
        hallDataNum = getIntent().getIntExtra("hall_data_num", 0);

       // System.out.println("hallDataNum: " + hallDataNum);

        // Make Mealtime object
        mealTime = new MealTime(hallDataNum);
        mealNum = mealTime.getMealTypeNum();

        // Make the DiningHall object.
        //selectedHall = new DiningHall(hallDataStr);

        // Make the current Meal object.
        //currentMeal = new Meal(hallDataStr);

        // Set the food in the ListView (the setMenuItemsArray() method should use the
        // current meal to decide what to load.
        setMenuItemsArray();

        // Get the TextViews. Use these to dynamically change text views.
        DiningHallTextView = (TextView) findViewById(R.id.hall_textview);
        MealTextView = (TextView) findViewById(R.id.meal_textview);
        MealTimeTextView = (TextView) findViewById(R.id.meal_time_textview);

       // Set the TextViews.
        DiningHallTextView.setText(hallDataStr);
        MealTextView.setText(mealTime.currentMealType());
        //System.out.println("CURRENT MEAL TIME: " + mealTime.currentMealTime());
        //System.out.println("CURRENT MEAL TYPE: " + mealTime.currentMealType());
        MealTimeTextView.setText(mealTime.currentMealTime());

        // Get the ListView.
        MealListView= (ListView) findViewById(R.id.meal_items_listview);

        System.out.println("Hall data num = " + hallDataNum + "     Meal num = " + mealNum);

        String[] menuArr = this.setMenuItemsArray();
        System.out.println("MENU_ARR : " + menuArr);
        if(menuArr == null) {
            menuArr = new String[1];
            menuArr[0] = "The menuItemsArray is null.";
        }
        System.out.println("menu arr after added stuff: " + menuArr);


        // Initialize the adapter. Put menuItemsArray into the ListView.
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menuArr);
        MealListView.setAdapter(adapter);



    }


    /*
     * Fill the Menu Array with all of the food options on the Menu.
     * This is what will appear in the scrolling list view on the menu page.
     */
    public String[] setMenuItemsArray() {
        // get the correct data from the data collector
        switch(hallDataNum) {
            case 1: // hoch
                switch(mealNum) {
                    case 1:
                        System.out.println("returning DataCollector.hochBreakfast    --> " + DataCollector.hochBreakfast);
                        return DataCollector.hochBreakfast;
                    case 2:
                        return DataCollector.hochLunch;
                    case 3:
                        return DataCollector.hochDinner;
                    case 4:
                        return DataCollector.hochBrunch;
                }
            case 2: // malott
                switch(mealNum) {
                    case 1:
                        return DataCollector.malottBreakfast;
                    case 2:
                        return DataCollector.malottLunch;
                    case 3:
                        return DataCollector.malottDinner;
                    case 4:
                        return DataCollector.malottBrunch;
                }
            case 3: // collins
                switch(mealNum) {
                    case 1:
                        return DataCollector.collinsBreakfast;
                    case 2:
                        return DataCollector.collinsLunch;
                    case 3:
                        return DataCollector.collinsDinner;
                    case 4:
                        return DataCollector.collinsBrunch;
                }
            case 4: // mcconnell
                switch(mealNum) {
                    case 1:
                        return DataCollector.mcconnellBreakfast;
                    case 2:
                        return DataCollector.mcconnellLunch;
                    case 3:
                        return DataCollector.mcconnellDinner;
                    case 4:
                        return DataCollector.mcconnellBrunch;
                }
            case 5: // frank
                switch(mealNum) {
                    case 1:
                        return DataCollector.frankBreakfast;
                    case 2:
                        return DataCollector.frankLunch;
                    case 3:
                        return DataCollector.frankDinner;
                    case 4:
                        return DataCollector.frankBrunch;
                }
            case 6: // frary
                switch(mealNum) {
                    case 1:
                        return DataCollector.fraryBreakfast;
                    case 2:
                        return DataCollector.fraryLunch;
                    case 3:
                        return DataCollector.fraryDinner;
                    case 4:
                        return DataCollector.fraryBrunch;
                }
            case 7: // oldenborg
                switch(mealNum) {
                    case 1:
                        return DataCollector.oldenborgBreakfast;
                    case 2:
                        return DataCollector.oldenborgLunch;
                    case 3:
                        return DataCollector.oldenborgDinner;
                    case 4:
                        return DataCollector.oldenborgBrunch;
                }
        }
        return null;
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
