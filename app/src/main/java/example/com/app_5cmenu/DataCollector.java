package example.com.app_5cmenu;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Annie on 10/29/14.
 *
 * This class is supposed to sit between the Meal and the raw data coming from the WebScrapers.
 *  ^ Note, this might not actually be where it is, because other classes talk to it too.
 *
 * A Meal can take the data directly from a WebScraper, however, we decided to add this class,
 * so that it can load the data once each day, instead of each time the user selects a dining hall.
 *
 * It may be difficult to get a cron job working on a phone, although some google searches suggest
 * that an SchedulerManager might work.
 *
 * This class should have a way to know whether it already has the new data or not, and it should
 * load and store the new data if it does not. The idea is to get the app to call the Web Scrapers
 * ONLY once a day (Or, if we can't get a scheduler to work, then ONLY once each time the app is
 * opened.) <-- this is probably all it will do to start with anyway.
 *
 * That means that DataCollector should actually be called by the home page's onCreate() method
 * to start.
 *
 * A REFRESH button might be a good idea for the future too...food for thought.
 */
public class DataCollector {

    // This is a "Singleton" class.
    private static DataCollector instance = null;

    Document doc;

    Calendar cal;
    int month = cal.MONTH;
    int dayOfMonth = cal.DAY_OF_MONTH;
    int dayOfWeek = cal.DAY_OF_WEEK;

    int lastLoadMonth;
    int lastLoadDayOfMonth;


    public static String[] defaultMenu = new String[1];

    HochWebScraper hochScraper = new HochWebScraper();
    //MalottWebScraper malottScraper = new MalottWebScraper();
    //OldenborgWebScraper oldenborgScraper = new OldenborgWebScraper();
    //      .
    //      .
    //      .


    public static ArrayList<String> hochBreakfast = new ArrayList<String>();
    public static ArrayList<String> hochLunch = new ArrayList<String>();
    public static ArrayList<String> hochDinner = new ArrayList<String>();
    public static ArrayList<String> hochBrunch = new ArrayList<String>();

    public static ArrayList<String> malottBreakfast = new ArrayList<String>();
    public static ArrayList<String> malottLunch = new ArrayList<String>();
    public static ArrayList<String> malottDinner = new ArrayList<String>();
    public static ArrayList<String> malottBrunch = new ArrayList<String>();

    public static ArrayList<String> mcconnellBreakfast = new ArrayList<String>();
    public static ArrayList<String> mcconnellLunch = new ArrayList<String>();
    public static ArrayList<String> mcconnellDinner = new ArrayList<String>();
    public static ArrayList<String> mcconnellBrunch = new ArrayList<String>();

    public static ArrayList<String> collinsBreakfast = new ArrayList<String>();
    public static ArrayList<String> collinsLunch = new ArrayList<String>();
    public static ArrayList<String> collinsDinner = new ArrayList<String>();
    public static ArrayList<String> collinsBrunch = new ArrayList<String>();

    public static ArrayList<String> frankBreakfast = new ArrayList<String>();
    public static ArrayList<String> frankLunch = new ArrayList<String>();
    public static ArrayList<String> frankDinner = new ArrayList<String>();
    public static ArrayList<String> frankBrunch = new ArrayList<String>();

    public static ArrayList<String> fraryBreakfast = new ArrayList<String>();
    public static ArrayList<String> fraryLunch = new ArrayList<String>();
    public static ArrayList<String> fraryDinner = new ArrayList<String>();
    public static ArrayList<String> fraryBrunch = new ArrayList<String>();

    public static ArrayList<String> oldenborgBreakfast = new ArrayList<String>();
    public static ArrayList<String> oldenborgLunch = new ArrayList<String>();
    public static ArrayList<String> oldenborgDinner = new ArrayList<String>();
    public static ArrayList<String> oldenborgBrunch = new ArrayList<String>();

    //      .
    //      .
    //      .


    protected DataCollector() {
        // Exists only to defeat instantiation.
    }

    public static DataCollector getInstance() {
        if (instance == null) {
            instance = new DataCollector();
        }
        return instance;
    }

    public void setDoc(Document document) {
        doc = document;
    }

    public boolean hasTodaysData() {
        if(lastLoadMonth == month && lastLoadDayOfMonth == dayOfMonth) {
            return true;
        }
        return false;
    }

    public void setDataLoad() {
        lastLoadDayOfMonth = dayOfMonth;
        lastLoadMonth = month;
    }

    public void load() {

        String title = doc.title();
        System.out.println("This is the website title; " + title);

        if(dayOfWeek == cal.SUNDAY || dayOfWeek == cal.SATURDAY) {
            // weekend: load brunch & dinner
            hochDinner.add("This is the dinner string");
            malottDinner.add("This is the dinner string");
            mcconnellDinner.add("This is the dinner string");
            collinsDinner.add("This is the dinner string");
            frankDinner.add("This is the dinner string");
            fraryDinner.add("This is the dinner string");
            oldenborgDinner.add("This is the dinner string");

            hochBrunch.add("This is the dinner string");
            malottBrunch.add("This is the dinner string");
            mcconnellBrunch.add("This is the dinner string");
            collinsBrunch.add("This is the dinner string");
            frankBrunch.add("This is the dinner string");
            fraryBrunch.add("This is the dinner string");
            oldenborgBrunch.add("This is the dinner string");
        } else {
            hochBreakfast.add("This is the dinner string");
            malottBreakfast.add("This is the dinner string");
            mcconnellBreakfast.add("This is the dinner string");
            collinsBreakfast.add("This is the dinner string");
            frankBreakfast.add("This is the dinner string");
            fraryBreakfast.add("This is the dinner string");
            oldenborgBreakfast.add("This is the dinner string");

            hochLunch.add("This is the dinner string");
            malottLunch.add("This is the dinner string");
            mcconnellLunch.add("This is the dinner string");
            collinsLunch.add("This is the dinner string");
            frankLunch.add("This is the dinner string");
            fraryLunch.add("This is the dinner string");
            oldenborgLunch.add("This is the dinner string");

            hochDinner.add("This is the dinner string");
            malottDinner.add("This is the dinner string");
            mcconnellDinner.add("This is the dinner string");
            collinsDinner.add("This is the dinner string");
            frankDinner.add("This is the dinner string");
            fraryDinner.add("This is the dinner string");
            oldenborgDinner.add("This is the dinner string");

        }
        this.setDataLoad();
    }



}
