package example.com.app_5cmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class HomePage extends Activity implements View.OnClickListener {

    TextView mainTextView;
    Button firstButton;
    Button secondButton;
    Button thirdButton;
    Button fourthButton;
    Button fifthButton;
    Button sixthButton;
    Button seventhButton;

    Intent goToHochMenu_Intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        // 1. Access the TextView defined in layout XML
        // and then set its text
        mainTextView = (TextView) findViewById(R.id.main_textview);
        mainTextView.setText("Welcome to the 5C Menu App!");

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
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        // Test the Button
        mainTextView.setText("Button pressed!");
        goToHochMenu_Intent = new Intent(this, MenuPage.class);
        startActivity(goToHochMenu_Intent);
    }
}
