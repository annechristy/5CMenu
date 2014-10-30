package example.com.app_5cmenu;

/**
 * Created by Annie on 10/29/14.
 *
 * An implementation of a WebScraper that obtains meal items for the McConnell
 * dining hall at Ptizer College.
 *
 */
public class McConnellWebScraper implements WebScraper {
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
