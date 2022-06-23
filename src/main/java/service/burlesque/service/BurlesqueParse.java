package service.burlesque.service;

import org.springframework.stereotype.Service;
import service.burlesque.service.documentparse.DocumentParse;
import service.burlesque.utils.DirectoriesHierarchy;

import static service.burlesque.utils.Thesaurus.BASE_URL;

@Service
public class BurlesqueParse {
    private DocumentParse documentParse;
    private DirectoriesHierarchy directoriesHierarchy;

    public BurlesqueParse(DocumentParse documentParse, DirectoriesHierarchy directoriesHierarchy) {
        this.documentParse = documentParse;
        this.directoriesHierarchy = directoriesHierarchy;
    }

    public void getPage() {
        documentParse.get_links(BASE_URL);
        //documentParse.getTitles();

        //directoriesHierarchy.createDir(headTitle, titlesAndUrls);
    }
}