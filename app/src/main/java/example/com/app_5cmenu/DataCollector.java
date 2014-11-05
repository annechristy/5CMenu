package example.com.app_5cmenu;

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
    public static String[] defaultMenu = new String[1];

    HochWebScraper hochScraper = new HochWebScraper();
    //MalottWebScraper malottScraper = new MalottWebScraper();
    //OldenborgWebScraper oldenborgScraper = new OldenborgWebScraper();
    //      .
    //      .
    //      .


    public static String[] hochBreakfast;
    public static String[] hochBrunch;
    public static String[] hochLunch;
    public static String[] hochDinner;

    String[] malottBreakfast;
    String[] malottBrunch;
    String[] malottLunch;
    String[] malottDinner;

    //      .
    //      .
    //      .


    public DataCollector() {
        defaultMenu[0] = "No Menu";

        hochBreakfast = hochScraper.getBreakfast();
        hochBrunch = hochScraper.getBrunch();
        hochLunch = hochScraper.getLunch();
        hochDinner = hochScraper.getDinner();
    }



}
