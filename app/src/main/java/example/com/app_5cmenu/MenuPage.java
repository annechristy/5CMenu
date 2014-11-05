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
    // Parser information
    private static final String URL = "https://aspc.pomona.edu/menu/";
    ProgressDialog mProgressDialog;

    // Current hall and meal objects.
    DiningHall selectedHall;
    Meal currentMeal;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);

        new FetchWebsiteData().execute();

        // Get information from the home page.
        hallDataStr = getIntent().getStringExtra("hall_data");
        hallDataNum = getIntent().getIntExtra("hall_data_num", 0);

        // Make the DiningHall object.
        selectedHall = new DiningHall(hallDataStr);

        // Make the current Meal object.
        currentMeal = new Meal(hallDataStr);

        // Set the food in the ListView (the setMenuItemsArray() method should use the
        // current meal to decide what to load.
        setMenuItemsArray();

        // Get the TextViews. Use these to dynamically change text views.
        DiningHallTextView = (TextView) findViewById(R.id.hall_textview);
        MealTextView = (TextView) findViewById(R.id.meal_textview);
        MealTimeTextView = (TextView) findViewById(R.id.meal_time_textview);

       // Set the TextViews.
        DiningHallTextView.setText(hallDataStr);
        MealTextView.setText(currentMeal.getMealType());
        System.out.println("MealType: " + currentMeal.getMealType());
        MealTimeTextView.setText(currentMeal.getMealtime());
        System.out.println("MealTime: " + currentMeal.getMealtime());

        // Get the ListView.
        MealListView= (ListView) findViewById(R.id.meal_items_listview);
        System.out.println("MenuItems: " + menuItemsArray);

        // Initialize the adapter. Put menuItemsArray into the ListView.
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menuItemsArray);
        MealListView.setAdapter(adapter);



    }

    /*
     * Fill the Menu Array with all of the food options on the Menu.
     * This is what will appear in the scrolling list view on the menu page.
     */
    public void setMenuItemsArray() {
       menuItemsArray = selectedHall.getCurrentMenu();
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

    private class FetchWebsiteData extends AsyncTask<Void, Void, Void> {
        String websiteTitle, websiteDescription;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(MenuPage.this);
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                // Connect to website
                //Document document = Jsoup.connect(URL).get();
                Document document = Jsoup.connect(URL).get();
                // Get the html document title
                websiteTitle = document.title();
                System.out.println("DOCUMENT TITLE: " + websiteTitle);
                Elements description = document.select("meta[name=description]");
                // Locate the content attribute
                websiteDescription = description.attr("content");

                MalottWebScraper malottScrappy = new MalottWebScraper(document);


            } catch (IOException e) {
                System.out.println("STACK TRACE THINGY");
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Set title into TextView
            //TextView txttitle = (TextView) findViewById(R.id.txtData);
           // txttitle.setText(websiteTitle + "\n" + websiteDescription);
            System.out.println("I did that thing you wanted me to do!!!");
            mProgressDialog.dismiss();
        }
    }
}
