package example.com.app_5cmenu;

/**
 * Created by Annie on 10/29/14.
 *
 * An implementation of a WebScraper that obtains meal items for the Hoch-Shanahan dining hall.
 *
 */
public class HochWebScraper implements WebScraper {

    public HochWebScraper() {
        // I don't really know what to do inside the constructor here...
    }

    @Override
    public String getWebsiteTitle() {
        return null;
    }

    @Override
    public String[] getBreakfast() {
        // this has been instatiated for testing purposes.

        String[] result = new String[2];
        result[0] = "beets";
        result[1] = "breakfast";
        return result;
    }

    @Override
    public String[] getLunch() {
        String[] result = new String[4];
        result[0] = "blueberries";
        result[1] = "yams";
        result[2] = "french fries";
        result[3] = "lunch";
        return result;
    }

    @Override
    public String[] getDinner() {
        String[] result = new String[3];
        result[0] = "MEAT!";
        result[1] = "and vegetables";
        result[2] = "dinner";
        return result;
    }

    @Override
    public String[] getBrunch() {
        String[] result = new String[2];
        result[0] = "deep fried Twinkies";
        result[1] = "brunch";
        return result;
    }
}
