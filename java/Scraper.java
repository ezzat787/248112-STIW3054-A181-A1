import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Scraper {


    public static List<Data> ListAll() {

    try {
        Document document = Jsoup.connect("https://ms.wikipedia.org/wiki/Malaysia").get();

        Elements table = document.getElementsByClass("wikitable");

        Elements s = table.get(1).getElementsByClass("wikitable");

        Elements colum1 = s.select("th");

        Elements colum2 = s.select("td");

        List<Data> datalist = new ArrayList<Data>();

        for (int i = 0; i < colum1.size(); i++) {

            datalist.add(new Data("" + colum1.get(i).text(), "" + colum2.get(i).text()));

        }

        System.out.println("extracting data in progress.....\n");
        Thread.sleep(4000);

        for(Data data : datalist) {
           System.out.println(data.getCol1()+"   :   "+data.getCol2());
       }

       return datalist;

    } catch (IOException e) {
        e.printStackTrace();

    } catch (InterruptedException e) {
        e.printStackTrace();
    }
        System.out.println("data successfully extracted ");
return  null;

}
}
