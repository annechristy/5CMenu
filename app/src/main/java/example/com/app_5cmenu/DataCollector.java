package example.com.app_5cmenu;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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
    ASPCScraper aspc;
    MealTime mealTime = new MealTime();


    Calendar cal;
    int month = Calendar.MONTH;
    int dayOfMonth = Calendar.DAY_OF_MONTH;
    int dayOfWeek = Calendar.DAY_OF_WEEK;
    int year = Calendar.YEAR;


    String nowTime = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());



    int lastLoadMonth;
    int lastLoadDayOfMonth;


    public static String[] hochBreakfast;
    public static String[] hochLunch;
    public static String[] hochDinner;
    public static String[] hochBrunch;

    public static String[] malottBreakfast;
    public static String[] malottLunch;
    public static String[] malottDinner;
    public static String[] malottBrunch;

    public static String[] mcconnellBreakfast;
    public static String[] mcconnellLunch;
    public static String[] mcconnellDinner;
    public static String[] mcconnellBrunch;

    public static String[] collinsBreakfast;
    public static String[] collinsLunch;
    public static String[] collinsDinner;
    public static String[] collinsBrunch;

    public static String[] frankBreakfast;
    public static String[] frankLunch;
    public static String[] frankDinner;
    public static String[] frankBrunch;

    public static String[] fraryBreakfast;
    public static String[] fraryLunch;
    public static String[] fraryDinner;
    public static String[] fraryBrunch;

    public static String[] oldenborgBreakfast;
    public static String[] oldenborgLunch;
    public static String[] oldenborgDinner;
    public static String[] oldenborgBrunch;




    protected DataCollector() {
        // Exists only to defeat instantiation.
    }



    // Creates the Singleton Class

    public static DataCollector getInstance() {
        if (instance == null) {
            instance = new DataCollector();
        }
        return instance;
    }


    // Grab an HTML document for parsing.
    public void setDoc(Document document) {
        doc = document;
        aspc = new ASPCScraper(doc);
        System.out.println("nowTime: " + nowTime);
        System.out.println("Day: " + cal.DAY_OF_WEEK);

    }

    public boolean hasTodaysData() {
        return lastLoadMonth == month && lastLoadDayOfMonth == dayOfMonth;
    }

    // sets date values on a load so we know if we have already scraped the website that day.
    public void setDataLoad() {
        lastLoadDayOfMonth = dayOfMonth;
        lastLoadMonth = month;
    }


    public String[] parseMeal(int hall, int meal) {
        String aspc_hallid = "";
        String mealStr = "";

        switch(hall) {
            case 1: aspc_hallid = "mudd_menu";
                break;
            case 2: aspc_hallid = "scripps_menu";
                break;
            case 3: aspc_hallid = "cmc_menu";
                break;
            case 4: aspc_hallid = "pitzer_menu";
                break;
            case 5: aspc_hallid = "frank_menu";
                break;
            case 6: aspc_hallid = "frary_menu";
                break;
            case 7: aspc_hallid = "oldenborg_menu";
                break;
        }

        switch(meal) {
            case 1: mealStr = "Breakfast";
                break;
            case 2: mealStr = "Lunch";
                break;
            case 3: mealStr = "Dinner";
                break;
            case 4: mealStr = "Brunch";
                break;
        }

        Elements menutable = doc.select("table#menu_table");
        Elements hochMenu = menutable.select("tr#" + aspc_hallid);
        Elements ul = hochMenu.select("td:contains(" + mealStr + ") > ul");
        Elements li = ul.select("li");
        //System.out.println("THE MENU ITEMS:");

        // Scan once for the number of items.
        int numitems = 0;
        for (Element e : li) {
            System.out.println("item: " + e.text());
            numitems++;
        }

        // Scan second time for items.
        String[] resultArr = new String[numitems];
        int index = 0;
        for (Element e : li) {
            resultArr[index] = e.text();
            index++;
        }

        System.out.println("resultArr: " + resultArr[0]);
        return resultArr;
    }


        // load the data from the webscrapers into the ArrayLists

    public void load() {


        String title = doc.title();
        System.out.println("This is the website title; " + title);


        try {

            if (mealTime.day == cal.SUNDAY || mealTime.day == cal.SATURDAY) {
                // weekend: load brunch & dinner
                hochDinner = this.parseMeal(1, 3);
                malottDinner = this.parseMeal(2, 3);
                mcconnellDinner = this.parseMeal(4, 3);
                collinsDinner = this.parseMeal(3, 3);
                frankDinner = this.parseMeal(5, 3);
                fraryDinner = this.parseMeal(6, 3);
                oldenborgDinner = this.parseMeal(7, 3);

                hochBrunch = this.parseMeal(1, 4);
                malottBrunch = this.parseMeal(2, 4);
                mcconnellBrunch = this.parseMeal(4, 4);
                collinsBrunch = this.parseMeal(3, 4);
                frankBrunch = this.parseMeal(5, 4);
                fraryBrunch = this.parseMeal(6, 4);
                oldenborgBrunch = this.parseMeal(7, 4);
                System.out.println("IN WEEKEND");
                System.out.println("DAY OF THE WEEK:" + dayOfWeek);
            } else {
                System.out.println("I AM NOT IN WEEKEND");
                hochBreakfast = this.parseMeal(1, 1);
                System.out.println("HOCH BREAKFAST IN DATACOLLECTOR: " + hochBreakfast);
                malottBreakfast = this.parseMeal(2, 1);
                mcconnellBreakfast = this.parseMeal(4, 1);
                collinsBreakfast = this.parseMeal(3, 1);
                frankBreakfast = this.parseMeal(5, 1);
                fraryBreakfast = this.parseMeal(6, 1);
                oldenborgBreakfast = this.parseMeal(7, 1);

                hochLunch = this.parseMeal(1, 2);
                malottLunch = this.parseMeal(2, 2);
                mcconnellLunch = this.parseMeal(4, 2);
                collinsLunch = this.parseMeal(3, 2);
                frankLunch = this.parseMeal(5, 2);
                fraryLunch = this.parseMeal(6, 2);
                oldenborgLunch = this.parseMeal(7, 2);

                hochDinner = this.parseMeal(1, 3);
                malottDinner = this.parseMeal(2, 3);
                mcconnellDinner = this.parseMeal(4, 3);
                collinsDinner = this.parseMeal(3, 3);
                frankDinner = this.parseMeal(5, 3);
                fraryDinner = this.parseMeal(6, 3);
                oldenborgDinner = this.parseMeal(7, 3);

            }

        } catch(NullPointerException e) {
            System.out.println("NULL POINTER EXCEPTION IN DATACOLLECTOR!!!");
            e.printStackTrace();

        }


        this.setDataLoad();
        //System.out.println("hochBrunch: " + hochBrunch);
    }
}
