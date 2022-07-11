/*
package app.burlesqueservice.service.documentparse;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import app.burlesqueservice.connection.Connection;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.jsoup.Jsoup.connect;

public class ReadAllLinks {
    public static Set<String> uniqueURL = new HashSet<String>();
    public static String my_site;

    public Document getDocument(String url) {
        Connection connection = new Connection();
        try {
            return connect(url)
                    .cookies(connection.getCookies())
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        ReadAllLinks obj = new ReadAllLinks();
        my_site = "burlesque-school.ru";
        try {
            obj.get_links("https://burlesque-school.ru");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void get_links(String url) throws IOException {
        Document doc = getDocument(url);
        Elements links = doc.select("a");

        if (links.isEmpty()) {
            return;
        }

        links.stream().map((link) -> link.attr("abs:href")).forEachOrdered((this_url) -> {
            boolean add = uniqueURL.add(this_url);
            if (add && this_url.contains(my_site)) {
                System.out.println(this_url);
                try {
                    get_links(this_url);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
*/
