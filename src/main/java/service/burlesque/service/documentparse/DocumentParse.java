package service.burlesque.service.documentparse;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import service.burlesque.connection.Connection;
import service.burlesque.service.model.TitleAndUrl;

import java.io.IOException;
import java.util.*;

import static java.util.Objects.requireNonNull;
import static org.jsoup.Jsoup.connect;
import static service.burlesque.utils.Thesaurus.BASE_URL;
import static service.burlesque.utils.Thesaurus.ITEM_BASE_URL;

@Service
public class DocumentParse {
    private final Connection connection;

    private Map<String, List<TitleAndUrl>> map = new LinkedHashMap<>();

    public DocumentParse(Connection connection) {
        this.connection = connection;
    }

    public Document getDocument(String itemUrl) {
        try {
            return connect(BASE_URL + itemUrl)
                    .cookies(connection.getCookies())
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Document getDocumentItemBaseUrl() {
        return getDocument(ITEM_BASE_URL);
    }

    public String getHeadTitle(Document document) {
        System.out.println("Head: " + document.title());
        return document.title();
    }

    public List<TitleAndUrl> getTitles() {
        getHeadTitle(getDocumentItemBaseUrl());

        //Получаем titlesAndUrls базовой страницы
        List<TitleAndUrl> titlesAndUrls = getTitlesAndUrls(getDocumentItemBaseUrl());
        titlesAndUrls.forEach(System.out::println);

        //Получаем titlesAndUrls дочерней страницы
        List<TitleAndUrl> titleAndUrlList = new ArrayList<>();
        for (TitleAndUrl titleAndUrl : titlesAndUrls) {
            String title = titleAndUrl.getTitle();
            String url = titleAndUrl.getUrl();

            titleAndUrlList = getTitlesAndUrls(getDocument(url));
            titleAndUrlList.forEach(System.err::println);
            map.put(title, titleAndUrlList);
        }

        return titleAndUrlList;
    }

    public List<TitleAndUrl> getTitlesAndUrls(Document document) {

        List<String> titles = new ArrayList<>();
        titles.add("stream-title");
        titles.add("link-title");

        Map<String, Elements> elementsMap = new LinkedHashMap<>();
        for (String title : titles) {
            elementsMap.put(title, getElementsTitles(document, title));
        }

        System.out.println(elementsMap.toString());

        List<TitleAndUrl> titlesAndUrls = new ArrayList<>();

        for (Map.Entry<String, Elements> entry : elementsMap.entrySet()) {
            titlesAndUrls = buildPostList(entry.getValue());
            System.out.println(entry.getKey() + entry.getValue());
        }

        return titlesAndUrls;
    }

    private List<TitleAndUrl> buildPostList(Elements elements) {
        List<TitleAndUrl> titleAndUrlList = new ArrayList<>();
        elements.forEach(element -> {
            String title = element.text();
            String url = requireNonNull(element.parent()).attr("href");
            titleAndUrlList.add(new TitleAndUrl(title, url));
        });
        return titleAndUrlList;
    }

    private Elements getElementsTitles(Document document, String el) {
        return document.getElementsByAttributeValue("class", el);
    }

    public void get_links(String url) {
        Set<String> uniqueURL = new HashSet<String>();

        Document doc = getDocumentItemBaseUrl();
        Elements links = doc.select("a");

        if (links.isEmpty()) {
            return;
        }

        links.stream().map((link) -> link.attr("abs:href")).forEachOrdered((this_url) -> {
            boolean add = uniqueURL.add(this_url);
            if (add && this_url.contains(this_url)) {
                System.out.println(this_url);
                get_links(this_url);
            }
        });
    }

}
