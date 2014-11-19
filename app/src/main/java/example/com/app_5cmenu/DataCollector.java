package example.com.app_5cmenu;

import org.jsoup.nodes.Document;

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

    Calendar cal;
    int month = Calendar.MONTH;
    int dayOfMonth = Calendar.DAY_OF_MONTH;
    int dayOfWeek = Calendar.DAY_OF_WEEK;
    int year = Calendar.YEAR;

    int lastLoadMonth;
    int lastLoadDayOfMonth;


    public static String[] defaultMenu = new String[1];


    ASPCWebScraper ASPCScraper = new ASPCWebScraper();

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



    // For example, OldenborgBrunch on would be hall = 7, meal = 4
    public void addItemsToArray(ArrayList<String> inputArray, int hall, int meal) {
        ArrayList<String> tempArray = ASPCScraper.parse(hall, meal);
        int i;
        int testLength = tempArray.size();
        String current_element;
        for (i = 0; i < testLength; i++) {
            current_element = tempArray.get(i);
            inputArray.add(current_element);
        }
    }




    public void load() {

        String title = doc.title();
        System.out.println("This is the website title; " + title);
        System.out.println("dayOfWeek: " + dayOfWeek);
        System.out.println("dayOfMonth: " + dayOfMonth);
        System.out.println("month: " + month);
        System.out.println("year: " + year);

        if(dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY) {
            // weekend: load brunch & dinner
            hochDinner.add("This is the dinner string21");
            malottDinner.add("This is the dinner string22");
            mcconnellDinner.add("This is the dinner string23");
            collinsDinner.add("This is the dinner string24");
            frankDinner.add("This is the dinner string25");
            fraryDinner.add("This is the dinner string26");
            oldenborgDinner.add("This is the dinner string27");

            hochBrunch.add("This is the dinner string28");
            malottBrunch.add("This is the dinner string29");
            mcconnellBrunch.add("This is the dinner string30");
            collinsBrunch.add("This is the dinner string31");
            frankBrunch.add("This is the dinner string32");
            fraryBrunch.add("This is the dinner string33");
            //oldenborgBrunch.add("This is the dinner string34");
            //oldenborgBrunch.add("This is the dinner string35");

            // maybe we can't add the whole array at once??
            //ArrayList<String> testArray = ASPCScraper.parse(7, 4);
            //System.out.println("TEST ARRAY: " + testArray);
            //int i;
            //int testLength = testArray.size();
            //String current_element;
            //for (i = 0; i < testLength; i++) {
            //    current_element = testArray.get(i);
            //    oldenborgBrunch.add(current_element);
            //}
            //oldenborgBrunch.add("This is the Oldenborg Brunch String");

            // Use helper instead!
            addItemsToArray(oldenborgBrunch, 7, 4);

        } else {
            hochBreakfast.add("This is the BREAKFAST string");
            malottBreakfast.add("This is the dinner string1");
            mcconnellBreakfast.add("This is the dinner string2");
            collinsBreakfast.add("This is the dinner string3");
            frankBreakfast.add("This is the dinner string4");
            fraryBreakfast.add("This is the dinner string5");
            oldenborgBreakfast.add("This is the dinner string6");

            hochLunch.add("This is the LUNCH string7");
            malottLunch.add("This is the dinner string8");
            mcconnellLunch.add("This is the dinner string9");
            collinsLunch.add("This is the dinner string10");
            frankLunch.add("This is the dinner string11");
            fraryLunch.add("This is the dinner string12");
            oldenborgLunch.add("This is the dinner string13");

            hochDinner.add("This is the DINNER string14");
            malottDinner.add("This is the dinner string15");
            mcconnellDinner.add("This is the dinner string16");
            collinsDinner.add("This is the dinner string17");
            frankDinner.add("This is the dinner string18");
            fraryDinner.add("This is the dinner string19");
            oldenborgDinner.add("This is the dinner string20");

        }
        this.setDataLoad();
        System.out.println("hochBrunch: " + hochBrunch);
    }
}
