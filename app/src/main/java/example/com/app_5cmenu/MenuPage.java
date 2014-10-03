package example.com.app_5cmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;


public class MenuPage extends Activity {


    TextView DiningHallTextView;

    ListView hochMealListView;

    int numMenuItems = 15;
    String[] menuItemsArray = new String[numMenuItems];
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);

        // Set the food in the ListView
        this.setMenuItemsArray();

        // Use these to dynamically change text views
        DiningHallTextView = (TextView) findViewById(R.id.hoch_textview);
        DiningHallTextView.setText("Hoch-Shanahan");


        // initialize the adapter
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menuItemsArray);
        hochMealListView= (ListView) findViewById(R.id.hoch_breakfast_listview);


        hochMealListView.setAdapter(adapter);

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
