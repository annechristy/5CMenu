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


        // Get information from the home page.
        hallDataStr = getIntent().getStringExtra("hall_data");
        hallDataNum = getIntent().getIntExtra("hall_data_num", 0);

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
        MealTimeTextView.setText(mealTime.currentMealTime());

        // Get the ListView.
        MealListView= (ListView) findViewById(R.id.meal_items_listview);

        // Initialize the adapter. Put menuItemsArray into the ListView.
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menuItemsArray);
        MealListView.setAdapter(adapter);



    }

    /*
     * Fill the Menu Array with all of the food options on the Menu.
     * This is what will appear in the scrolling list view on the menu page.
     */
    public void setMenuItemsArray() {
        // get the correct data from the data collector
        switch(hallDataNum) {
            case 1: // hoch
                switch(mealNum) {
                    case 1:
                        String[] hochBreakfastArr = new String[DataCollector.hochBreakfast.size()];
                        hochBreakfastArr = DataCollector.hochBreakfast.toArray(hochBreakfastArr);
                        menuItemsArray = hochBreakfastArr;
                    case 2:
                        String[] hochLunchArr = new String[DataCollector.hochLunch.size()];
                        hochLunchArr = DataCollector.hochLunch.toArray(hochLunchArr);
                        menuItemsArray = hochLunchArr;
                    case 3:
                        String[] hochDinnerArr = new String[DataCollector.hochDinner.size()];
                        hochDinnerArr = DataCollector.hochDinner.toArray(hochDinnerArr);
                        menuItemsArray = hochDinnerArr;
                    case 4:
                        String[] hochBrunchArr = new String[DataCollector.hochBrunch.size()];
                        hochBrunchArr = DataCollector.hochBrunch.toArray(hochBrunchArr);
                        menuItemsArray = hochBrunchArr;
                }
            case 2: // malott
                switch(mealNum) {
                    case 1:
                        String[] malottBreakfastArr = new String[DataCollector.malottBreakfast.size()];
                        malottBreakfastArr = DataCollector.malottBreakfast.toArray(malottBreakfastArr);
                        menuItemsArray = malottBreakfastArr;
                    case 2:
                        String[] malottLunchArr = new String[DataCollector.malottLunch.size()];
                        malottLunchArr = DataCollector.malottLunch.toArray(malottLunchArr);
                        menuItemsArray = malottLunchArr;
                    case 3:
                        String[] malottDinnerArr = new String[DataCollector.malottDinner.size()];
                        malottDinnerArr = DataCollector.malottDinner.toArray(malottDinnerArr);
                        menuItemsArray = malottDinnerArr;
                    case 4:
                        String[] malottBrunchArr = new String[DataCollector.malottBrunch.size()];
                        malottBrunchArr = DataCollector.malottBrunch.toArray(malottBrunchArr);
                        menuItemsArray = malottBrunchArr;
                }
            case 3: // mcconnell
                switch(mealNum) {
                    case 1:
                        String[] mcconnellBreakfastArr = new String[DataCollector.mcconnellBreakfast.size()];
                        mcconnellBreakfastArr = DataCollector.mcconnellBreakfast.toArray(mcconnellBreakfastArr);
                        menuItemsArray = mcconnellBreakfastArr;
                    case 2:
                        String[] mcconnellLunchArr = new String[DataCollector.mcconnellLunch.size()];
                        mcconnellLunchArr = DataCollector.mcconnellLunch.toArray(mcconnellLunchArr);
                        menuItemsArray = mcconnellLunchArr;
                    case 3:
                        String[] mcconnellDinnerArr = new String[DataCollector.mcconnellDinner.size()];
                        mcconnellDinnerArr = DataCollector.mcconnellDinner.toArray(mcconnellDinnerArr);
                        menuItemsArray = mcconnellDinnerArr;
                    case 4:
                        String[] mcconnellBrunchArr = new String[DataCollector.mcconnellBrunch.size()];
                        mcconnellBrunchArr = DataCollector.mcconnellBrunch.toArray(mcconnellBrunchArr);
                        menuItemsArray = mcconnellBrunchArr;
                }
            case 4: // collins
                switch(mealNum) {
                    case 1:
                        String[] collinsBreakfastArr = new String[DataCollector.collinsBreakfast.size()];
                        collinsBreakfastArr = DataCollector.collinsBreakfast.toArray(collinsBreakfastArr);
                        menuItemsArray = collinsBreakfastArr;
                    case 2:
                        String[] collinsLunchArr = new String[DataCollector.collinsLunch.size()];
                        collinsLunchArr = DataCollector.collinsLunch.toArray(collinsLunchArr);
                        menuItemsArray = collinsLunchArr;
                    case 3:
                        String[] collinsDinnerArr = new String[DataCollector.collinsDinner.size()];
                        collinsDinnerArr = DataCollector.collinsDinner.toArray(collinsDinnerArr);
                        menuItemsArray = collinsDinnerArr;
                    case 4:
                        String[] collinsBrunchArr = new String[DataCollector.collinsBrunch.size()];
                        collinsBrunchArr = DataCollector.collinsBrunch.toArray(collinsBrunchArr);
                        menuItemsArray = collinsBrunchArr;
                }
            case 5: // frank
                switch(mealNum) {
                    case 1:
                        String[] frankBreakfastArr = new String[DataCollector.frankBreakfast.size()];
                        frankBreakfastArr = DataCollector.frankBreakfast.toArray(frankBreakfastArr);
                        menuItemsArray = frankBreakfastArr;
                    case 2:
                        String[] frankLunchArr = new String[DataCollector.frankLunch.size()];
                        frankLunchArr = DataCollector.frankLunch.toArray(frankLunchArr);
                        menuItemsArray = frankLunchArr;
                    case 3:
                        String[] frankDinnerArr = new String[DataCollector.frankDinner.size()];
                        frankDinnerArr = DataCollector.frankDinner.toArray(frankDinnerArr);
                        menuItemsArray = frankDinnerArr;
                    case 4:
                        String[] frankBrunchArr = new String[DataCollector.frankBrunch.size()];
                        frankBrunchArr = DataCollector.frankBrunch.toArray(frankBrunchArr);
                        menuItemsArray = frankBrunchArr;
                }
            case 6: // frary
                switch(mealNum) {
                    case 1:
                        String[] fraryBreakfastArr = new String[DataCollector.fraryBreakfast.size()];
                        fraryBreakfastArr = DataCollector.fraryBreakfast.toArray(fraryBreakfastArr);
                        menuItemsArray = fraryBreakfastArr;
                    case 2:
                        String[] fraryLunchArr = new String[DataCollector.fraryLunch.size()];
                        fraryLunchArr = DataCollector.fraryLunch.toArray(fraryLunchArr);
                        menuItemsArray = fraryLunchArr;
                    case 3:
                        String[] fraryDinnerArr = new String[DataCollector.fraryDinner.size()];
                        fraryDinnerArr = DataCollector.fraryDinner.toArray(fraryDinnerArr);
                        menuItemsArray = fraryDinnerArr;
                    case 4:
                        String[] fraryBrunchArr = new String[DataCollector.fraryBrunch.size()];
                        fraryBrunchArr = DataCollector.fraryBrunch.toArray(fraryBrunchArr);
                        menuItemsArray = fraryBrunchArr;
                }
            case 7: // oldenborg
                switch(mealNum) {
                    case 1:
                        String[] oldenborgBreakfastArr = new String[DataCollector.oldenborgBreakfast.size()];
                        oldenborgBreakfastArr = DataCollector.oldenborgBreakfast.toArray(oldenborgBreakfastArr);
                        menuItemsArray = oldenborgBreakfastArr;
                    case 2:
                        String[] oldenborgLunchArr = new String[DataCollector.oldenborgLunch.size()];
                        oldenborgLunchArr = DataCollector.oldenborgLunch.toArray(oldenborgLunchArr);
                        menuItemsArray = oldenborgLunchArr;
                    case 3:
                        String[] oldenborgDinnerArr = new String[DataCollector.oldenborgDinner.size()];
                        oldenborgDinnerArr = DataCollector.oldenborgDinner.toArray(oldenborgDinnerArr);
                        menuItemsArray = oldenborgDinnerArr;
                    case 4:
                        String[] oldenborgBrunchArr = new String[DataCollector.oldenborgBrunch.size()];
                        oldenborgBrunchArr = DataCollector.oldenborgBrunch.toArray(oldenborgBrunchArr);
                        menuItemsArray = oldenborgBrunchArr;
                }
        }
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
