package example.com.app_5cmenu;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by Annie on 11/5/14.
 */
public class ASPCScraper {

    Document doc;

    public ASPCScraper(Document document) {
        doc = document;

    }

    public ArrayList<String> parse(int hall, int meal) {
        ArrayList<String> result = new ArrayList<String>();

        Elements menutable = doc.select("table#menu_table");

        switch(hall) {
            case 1: // hoch
                Elements hochMenu = menutable.select("tr#frank_menu");
                switch(meal) {
                    case 1: // breakfast

                        Elements ul = hochMenu.select("td:contains(Breakfast) > ul");
                        Elements li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }

                }
        }

        /*
        ArrayList<String> myArrayList = new ArrayList<String>();


        Elements frank = halls.select("tr#frank_menu");

        //Elements frankLunch = frank.select("span:contains(Lunch)");
        Elements lunch = frank.select("td:contains(Lunch) > ul");
        //System.out.println("Elements: " + lunch);

        Elements li = lunch.select("li");


        for (Element e : li) {
            myArrayList.add(e.text());
        }

        System.out.println(myArrayList.toString());

        //String thisString = doc.title();
        //System.out.println("title : " + thisString);
        */

        return result;
    }

}
