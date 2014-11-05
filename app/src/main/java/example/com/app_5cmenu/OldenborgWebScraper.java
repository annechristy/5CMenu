package example.com.app_5cmenu;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;




/**
 * Created by Annie on 10/29/14.
 *
 * An implementation of a WebScraper that obtains meal items for Oldenborg dining hall on Pomona.
 *
 */
public class OldenborgWebScraper extends Activity implements WebScraper {
    //FetchWebsiteData websiteGetter = new FetchWebsiteData();

    private static final String URL = "https://aspc.pomona.edu/menu/";
    ProgressDialog mProgressDialog;

    //websiteGetter.execute();



    @Override
    public void onCreate(Bundle savedInstanceState) {
        System.out.println("CREATING AN OLDENBORG SCRAPER!!!!!!!!!!!!!");
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //Button btnFetchData = (Button) findViewById(R.id.btnData);

        new FetchWebsiteData().execute();
        /*
        btnFetchData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                System.out.println("Button Clicked!!!");
                new FetchWebsiteData().execute();
            }
        }); */

    }

    private class FetchWebsiteData extends AsyncTask<Void, Void, Void> {
        String websiteTitle, websiteDescription;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();}
/*            mProgressDialog = new ProgressDialog(OldenborgWebScraper.this);
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }
*/
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
            } catch (IOException e) {
                System.out.println("STACK TRACE THINGY");
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {System.out.println("done.");} /*
            // Set title into TextView
            //TextView txttitle = (TextView) findViewById(R.id.txtData);
            //txttitle.setText(websiteTitle + "\n" + websiteDescription);
            System.out.println("output");
            //mProgressDialog.dismiss();
        }*/
    }







    @Override
    public String getWebsiteTitle() {

        return null;
    }

    @Override
    public String[] getBreakfast() {
        return new String[0];
    }

    @Override
    public String[] getLunch() {
        return new String[0];
    }

    @Override
    public String[] getDinner() {
        return new String[0];
    }

    @Override
    public String[] getBrunch() {
        return new String[0];
    }
}



