package example.com.app_5cmenu;

/**
 * Created by Annie on 10/29/14.
 *
 *  An interface for the web scraping components of the app. This will allow us to scrape different
 *  websites, but still access the data in the same way no matter which website it came from.
 *
 *  The interface is designed with the intent of collecting one day's worth of meals from one
 *  dining hall. So, we should have a scraper for each dining hall implementing this interface.
 *
 * I would suggest that each implementation should search the ASPC website first. For now, if
 * they don't have a menu, we can just return a String array containing a single item, "no menu."
 * In the future, it might be a good idea for the scrapers to have contingency plans, so they can
 * try the other websites if the ASPC website doesn't have a menu. This should provide a suitable
 * front-end while we get those scrapers running though.
 *
 * The ASPC site is: https://aspc.pomona.edu/menu/
 */
public interface WebScraper {

    // Constant declarations, if any needed, go here.

    // Method Signatures

    /*
     * Return the title of the website, according to the html.
     */
    String getWebsiteTitle();


    /*
     * Find all the breakfast items and put them in an array of Strings, with each
     * item being in a different index. If a menu cannot be found at all, return a
     */
    String[] getBreakfast();


    /*
     * Find all the lunch items and put them in an array of Strings, with each
     * item being in a different index.
     */
    String[] getLunch();


    /*
     * Find all the dinner items and put them in an array of Strings, with each
     * item being in a different index.
     */
    String[] getDinner();


    /*
     * Find all the brunch items and put them in an array of Strings, with each
     * item being in a different index.
     */
    String[] getBrunch();

}

