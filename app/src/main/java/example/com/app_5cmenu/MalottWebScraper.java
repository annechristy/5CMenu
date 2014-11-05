package example.com.app_5cmenu;

import java.util.ArrayList;
//import android.app.Activity;
//import android.app.ProgressDialog;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Annie on 10/29/14.
 *
 * An implementation of a WebScraper that obtains meal items for the Malott Dining Commons
 * at Scripps College.
 *
 */
public class MalottWebScraper /*implements WebScraper*/ {
    Document doc;

    static ArrayList<String> breakfast = new ArrayList<String>();
    static ArrayList<String> brunch = new ArrayList<String>();
    static ArrayList<String> lunch = new ArrayList<String>();
    static ArrayList<String> dinner = new ArrayList<String>();

    public MalottWebScraper(Document document) {
        doc = document;
        // Can I get jsoup to parse the doc here?
        String title = doc.title();
        System.out.println("THIS IS THE TITLE AS GOTTEN BY THE MALLOTT WEB SCRAPER CLASS!!!!!" + title);

        this.setBreakfast();
        this.setBrunch();
        this.setLunch();
        this.setDinner();
    }

    //@Override
    public String getWebsiteTitle() {

        return null;
    }

    public void setBreakfast() {

        Elements listTags = doc.select("ul li");
        for (Element item : listTags) {
            System.out.println("ITEM TEXT: " + item.text());
            breakfast.add(item.text());
        }

        // as you get the items from the website, add them to breakfast with breakfast.add()
    }

    public void setBrunch() {
        // as you get the items from the website, add them to breakfast with breakfast.add()
    }

    public void setLunch() {
        // as you get the items from the website, add them to breakfast with breakfast.add()
    }

    public void setDinner() {
        // as you get the items from the website, add them to breakfast with breakfast.add()
        Elements listTags = doc.select("ul li");
        for (Element item : listTags) {
            //System.out.println("ITEM TEXT: " + item.text());
            dinner.add(item.text().toString());
        }
    }

    //@Override
    public static String[] getBreakfast() {

        String[] breakfastArr = new String[breakfast.size()];
        breakfastArr = breakfast.toArray(breakfastArr);
        return breakfastArr;
    }

    //@Override
    public static String[] getLunch() {

        String[] lunchArr = new String[lunch.size()];
        lunchArr = lunch.toArray(lunchArr);
        return lunchArr;
    }

   // @Override
    public static String[] getDinner() {

        String[] dinnerArr = new String[dinner.size()];
        dinnerArr = dinner.toArray(dinnerArr);
        System.out.println("Mallott dinner array: " + dinnerArr);
        return dinnerArr;
    }

   // @Override
    public static String[] getBrunch() {

        String[] brunchArr = new String[brunch.size()];
        brunchArr = breakfast.toArray(brunchArr);
        return brunchArr;
    }
}
