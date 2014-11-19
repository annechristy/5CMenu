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
    ASPCScraper aspc;

    Calendar cal;
    int month = Calendar.MONTH;
    int dayOfMonth = Calendar.DAY_OF_MONTH;
    int dayOfWeek = Calendar.DAY_OF_WEEK;
    int year = Calendar.YEAR;

    int lastLoadMonth;
    int lastLoadDayOfMonth;

    public static String[] testHochDinnerArr;


<<<<<<< HEAD

    ASPCWebScraper ASPCScraper = new ASPCWebScraper();

    HochWebScraper hochScraper = new HochWebScraper();
    //MalottWebScraper malottScraper = new MalottWebScraper();
    //OldenborgWebScraper oldenborgScraper = new OldenborgWebScraper();
    //      .
    //      .
    //      .
=======
    public static String[] hochBreakfast;
    public static String[] hochLunch;
    public static String[] hochDinner;
    public static String[] hochBrunch;
>>>>>>> ea06ad12e27cec6385800cb10474eee234ffa4e7

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
    }

    public boolean hasTodaysData() {
        if(lastLoadMonth == month && lastLoadDayOfMonth == dayOfMonth) {
            return true;
        }
        return false;
    }

    // sets date values on a load so we know if we have already scraped the website that day.
    public void setDataLoad() {
        lastLoadDayOfMonth = dayOfMonth;
        lastLoadMonth = month;
    }

<<<<<<< HEAD


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




=======
    private String[] parseMeal(int hall, int meal) {
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
                System.out.println("oldenborg_menu");
                break;
        }

        switch(meal) {
            case 1: mealStr = "Breakfast";
                break;
            case 2: mealStr = "Lunch";
                break;
            case 3: mealStr = "Dinner";
                System.out.println("Dinner");
                break;
            case 4: mealStr = "Brunch";
                break;
        }

        Elements menutable = doc.select("table#menu_table");
        Elements hochMenu = menutable.select("tr#" + aspc_hallid);
        Elements ul = hochMenu.select("td:contains(" + mealStr + ") > ul");
        Elements li = ul.select("li");
        System.out.println("THE MENU ITEMS:");

        // Scan once for the number of items.
        int numitems = 0;
        for (Element e : li) {
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
>>>>>>> ea06ad12e27cec6385800cb10474eee234ffa4e7
    public void load() {


        String title = doc.title();
        System.out.println("This is the website title; " + title);
        System.out.println("dayOfWeek: " + dayOfWeek);
        System.out.println("dayOfMonth: " + dayOfMonth);
        System.out.println("month: " + month);
        System.out.println("year: " + year);

<<<<<<< HEAD
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
=======

        if(dayOfWeek == cal.SUNDAY || dayOfWeek == cal.SATURDAY) {
            // weekend: load brunch & dinner
            hochDinner = this.parseMeal(1,3);
            malottDinner = this.parseMeal(2,3);
            mcconnellDinner = this.parseMeal(4,3);
            collinsDinner = this.parseMeal(3,3);
            frankDinner = this.parseMeal(5,3);
            fraryDinner = this.parseMeal(6,3);
            oldenborgDinner = this.parseMeal(7,3);

            hochBrunch = this.parseMeal(1,3);
            malottBrunch = this.parseMeal(2,3);
            mcconnellBrunch = this.parseMeal(4,3);
            collinsBrunch = this.parseMeal(3,3);
            frankBrunch = this.parseMeal(5,3);
            fraryBrunch = this.parseMeal(6,3);
            oldenborgBrunch = this.parseMeal(7,3);
        } else {
            hochBreakfast = this.parseMeal(1,3);
            malottBreakfast = this.parseMeal(2,3);
            mcconnellBreakfast = this.parseMeal(4,3);
            collinsBreakfast = this.parseMeal(3,3);
            frankBreakfast = this.parseMeal(5,3);
            fraryBreakfast = this.parseMeal(6,3);
            oldenborgBreakfast = this.parseMeal(7,3);

            hochLunch = this.parseMeal(1,3);
            malottLunch = this.parseMeal(2,3);
            mcconnellLunch = this.parseMeal(4,3);
            collinsLunch = this.parseMeal(3,3);
            frankLunch = this.parseMeal(5,3);
            fraryLunch = this.parseMeal(6,3);
            oldenborgLunch = this.parseMeal(7,3);

            hochDinner = this.parseMeal(1,3);
            malottDinner = this.parseMeal(2,3);
            mcconnellDinner = this.parseMeal(4,3);
            collinsDinner = this.parseMeal(3,3);
            frankDinner = this.parseMeal(5,3);
            fraryDinner = this.parseMeal(6,3);
            oldenborgDinner = this.parseMeal(7,3);
>>>>>>> ea06ad12e27cec6385800cb10474eee234ffa4e7

        }
        this.setDataLoad();
        System.out.println("hochBrunch: " + hochBrunch);
    }
}
