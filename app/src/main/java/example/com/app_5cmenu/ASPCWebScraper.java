package example.com.app_5cmenu;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.lang.String;
import java.util.ArrayList;

import java.io.IOException;


/**
 * Created by Annie on 11/5/14.
 */
public class ASPCWebScraper {

    Document doc;
    private static final String URL = "https://aspc.pomona.edu/menu/";

    public ASPCWebScraper() {
        try {
            doc = Jsoup.connect(URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public ArrayList<String> parse(int hall, int meal) {
        ArrayList<String> result = new ArrayList<String>();

        Elements menutable = doc.select("table#menu_table");

        Elements ul;
        Elements li;

        switch(hall) {
            case 1: // hoch
                Elements hochMenu = menutable.select("tr#mudd_menu");
                switch(meal) {
                    case 1: // breakfast

                        ul = hochMenu.select("td:contains(Breakfast) > ul");
                        li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }
                        System.out.println("hoch breakfast: " + result);
                    case 2: // lunch

                        ul = hochMenu.select("td:contains(Lunch) > ul");
                        li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }
                    case 3: // dinner

                        ul = hochMenu.select("td:contains(Dinner) > ul");
                        li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }
                    case 4: // brunch

                        ul = hochMenu.select("td:contains(Brunch) > ul");
                        li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }

                }

            case 2: // mallott
                Elements mallottMenu = menutable.select("tr#scripps_menu");
                switch(meal) {
                    case 1: // breakfast

                        ul = mallottMenu.select("td:contains(Breakfast) > ul");
                        li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }
                        System.out.println("mallotMenu breakfast: " + result);
                    case 2: // lunch

                        ul = mallottMenu.select("td:contains(Lunch) > ul");
                        li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }
                    case 3: // dinner

                        ul = mallottMenu.select("td:contains(Dinner) > ul");
                        li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }
                    case 4: // brunch

                        ul = mallottMenu.select("td:contains(Brunch) > ul");
                        li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }

                }

            case 3: // collins
                Elements collinsMenu = menutable.select("tr#cmc_menu");
                switch(meal) {
                    case 1: // breakfast

                        ul = collinsMenu.select("td:contains(Breakfast) > ul");
                        li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }
                        System.out.println("collinsMenu breakfast: " + result);
                    case 2: // lunch

                        ul = collinsMenu.select("td:contains(Lunch) > ul");
                        li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }
                    case 3: // dinner

                        ul = collinsMenu.select("td:contains(Dinner) > ul");
                        li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }
                    case 4: // brunch

                        ul = collinsMenu.select("td:contains(Brunch) > ul");
                        li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }

                }

            case 4: // mcconnell
                Elements mcconnellMenu = menutable.select("tr#pitzer_menu");
                switch(meal) {
                    case 1: // breakfast

                        ul = mcconnellMenu.select("td:contains(Breakfast) > ul");
                        li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }
                        System.out.println("mcconnellMenu breakfast: " + result);
                    case 2: // lunch

                        ul = mcconnellMenu.select("td:contains(Lunch) > ul");
                        li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }
                    case 3: // dinner

                        ul = mcconnellMenu.select("td:contains(Dinner) > ul");
                        li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }
                    case 4: // brunch

                        ul = mcconnellMenu.select("td:contains(Brunch) > ul");
                        li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }

                }

            case 5: // frank
                Elements frankMenu = menutable.select("tr#frank_menu");
                switch(meal) {
                    case 1: // breakfast

                        ul = frankMenu.select("td:contains(Breakfast) > ul");
                        li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }
                        System.out.println("frankMenu breakfast: " + result);
                    case 2: // lunch

                        ul = frankMenu.select("td:contains(Lunch) > ul");
                        li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }
                    case 3: // dinner

                        ul = frankMenu.select("td:contains(Dinner) > ul");
                        li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }
                    case 4: // brunch

                        ul = frankMenu.select("td:contains(Brunch) > ul");
                        li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }

                }

            case 6: // frary
                Elements fraryMenu = menutable.select("tr#frary_menu");
                switch(meal) {
                    case 1: // breakfast

                        ul = fraryMenu.select("td:contains(Breakfast) > ul");
                        li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }
                        System.out.println("fraryMenu breakfast: " + result);
                    case 2: // lunch

                        ul = fraryMenu.select("td:contains(Lunch) > ul");
                        li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }
                    case 3: // dinner

                        ul = fraryMenu.select("td:contains(Dinner) > ul");
                        li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }
                    case 4: // brunch

                        ul = fraryMenu.select("td:contains(Brunch) > ul");
                        li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }

                }

            case 7: // oldenborg
                Elements oldenborgMenu = menutable.select("tr#oldenborg_menu");
                switch(meal) {
                    case 1: // breakfast

                        ul = oldenborgMenu.select("td:contains(Breakfast) > ul");
                        li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }
                        System.out.println("oldenborgMenu breakfast: " + result);
                    case 2: // lunch

                        ul = oldenborgMenu.select("td:contains(Lunch) > ul");
                        li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }
                    case 3: // dinner

                        ul = oldenborgMenu.select("td:contains(Dinner) > ul");
                        li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }
                    case 4: // brunch

                        ul = oldenborgMenu.select("td:contains(Brunch) > ul");
                        li = ul.select("li");
                        for (Element e : li) {
                            result.add(e.text());
                        }

                }
        }


        /*ArrayList<String> myArrayList = new ArrayList<String>();


        Elements frank = halls.select("tr#frank_menu");

        //Elements frankLunch = frank.select("span:contains(Lunch)");
        Elements lunch = frank.select("td:contains(Lunch) > ul");
        //System.out.println("Elements: " + lunch);

        Elements li = lunch.select("li");


        for (Element e : li) {
            myArrayList.add(e.text());
        }

        System.out.println(myArrayList.toString());

        String thisString = doc.title();
        System.out.println("title : " + thisString);*/



        /*ArrayList<String> result = new ArrayList<String>();
        Elements hochMenu = halls.select("tr#hoch_menu");
        Elements menutable = doc.select("table#menu_table");

        Elements ul = hochMenu.select("td:contains(Breakfast) > ul");
        Elements li = ul.select("li");
        for (Element e : li) {
            result.add(e.text());
        }
        System.out.println("hoch breakfast: " + result);*/

        return result;
    }

}