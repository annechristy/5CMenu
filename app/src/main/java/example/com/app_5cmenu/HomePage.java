package example.com.app_5cmenu;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Calendar;


public class HomePage extends Activity implements View.OnClickListener {

    private static final String URL = "https://aspc.pomona.edu/menu/";
    ProgressDialog mProgressDialog;

    DataCollector dataCollector;


    TextView mainTextView;
    Button firstButton;
    Button secondButton;
    Button thirdButton;
    Button fourthButton;
    Button fifthButton;
    Button sixthButton;
    Button seventhButton;

    Intent goToMenu_Intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        // 1. Access the TextView defined in layout XML
        // and then set its text
        mainTextView = (TextView) findViewById(R.id.main_textview);
        //mainTextView.setText("Welcome to the 5C Menu App!");

        // 2. Access the Button(s) defined in layout XML
        // and listen for it here
        firstButton = (Button) findViewById(R.id.first_button);
        firstButton.setOnClickListener(this);
        secondButton = (Button) findViewById(R.id.second_button);
        secondButton.setOnClickListener(this);
        thirdButton = (Button) findViewById(R.id.third_button);
        thirdButton.setOnClickListener(this);
        fourthButton = (Button) findViewById(R.id.fourth_button);
        fourthButton.setOnClickListener(this);
        fifthButton = (Button) findViewById(R.id.fifth_button);
        fifthButton.setOnClickListener(this);
        sixthButton = (Button) findViewById(R.id.sixth_button);
        sixthButton.setOnClickListener(this);
        seventhButton = (Button) findViewById(R.id.seventh_button);
        seventhButton.setOnClickListener(this);


        dataCollector = new DataCollector().getInstance();

        System.out.println("hasTodaysData? " + dataCollector.hasTodaysData());
        if(!dataCollector.hasTodaysData()) {
            new FetchWebsiteData().execute();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
       /* int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);*/
        return false;
    }

    @Override
    public void onClick(View view) {

        switch(view.getId())
        {
            case R.id.first_button:
                // go to the hoch menu
                goToMenu_Intent = new Intent(this, MenuPage.class);
                goToMenu_Intent.putExtra("hall_data", "Hoch-Shanahan");
                goToMenu_Intent.putExtra("hall_data_num", 1);
                startActivity(goToMenu_Intent);
                break;
            case R.id.second_button:
                // go to the hoch menu
                goToMenu_Intent = new Intent(this, MenuPage.class);
                goToMenu_Intent.putExtra("hall_data", "Malott Commons");
                goToMenu_Intent.putExtra("hall_data_num", 2);
                startActivity(goToMenu_Intent);
                break;
            case R.id.third_button:
                // go to the hoch menu
                goToMenu_Intent = new Intent(this, MenuPage.class);
                goToMenu_Intent.putExtra("hall_data", "Collins");
                goToMenu_Intent.putExtra("hall_data_num", 3);
                startActivity(goToMenu_Intent);
                break;
            case R.id.fourth_button:
                // go to the hoch menu
                goToMenu_Intent = new Intent(this, MenuPage.class);
                goToMenu_Intent.putExtra("hall_data", "McConnell");
                goToMenu_Intent.putExtra("hall_data_num", 4);
                startActivity(goToMenu_Intent);
                break;
            case R.id.fifth_button:
                // go to the hoch menu
                goToMenu_Intent = new Intent(this, MenuPage.class);
                goToMenu_Intent.putExtra("hall_data", "Frank");
                goToMenu_Intent.putExtra("hall_data_num", 5);
                startActivity(goToMenu_Intent);
                break;
            case R.id.sixth_button:
                // go to the hoch menu
                goToMenu_Intent = new Intent(this, MenuPage.class);
                goToMenu_Intent.putExtra("hall_data", "Frary");
                goToMenu_Intent.putExtra("hall_data_num", 6);
                startActivity(goToMenu_Intent);
                break;
            case R.id.seventh_button:
                // go to the hoch menu
                goToMenu_Intent = new Intent(this, MenuPage.class);
                goToMenu_Intent.putExtra("hall_data", "Oldenborg");
                goToMenu_Intent.putExtra("hall_data_num", 7);
                startActivity(goToMenu_Intent);
                break;

        }
    }

    public class FetchWebsiteData extends AsyncTask<Void, Void, Void> {
        String websiteTitle, websiteDescription;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(HomePage.this);
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                // Connect to website
                Document document = Jsoup.connect(URL).get();

                dataCollector.setDoc(document);
                dataCollector.load();
                System.out.println("HOMEPAGE IS CALLING DATACOLLECTOR");
                System.out.println("DATACOLLECTOR.HOCHBREAKFAST: " + DataCollector.hochBreakfast);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            mProgressDialog.dismiss();
        }
    }
}
