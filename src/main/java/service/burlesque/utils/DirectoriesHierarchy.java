package service.burlesque.utils;

import org.springframework.context.annotation.Configuration;
import service.burlesque.service.model.TitleAndUrl;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static java.nio.file.Files.createDirectories;
import static java.nio.file.Paths.get;

@Configuration
public class DirectoriesHierarchy {

    public void createDir(String headTitle, List<TitleAndUrl> titlesAndUrls) {
        titlesAndUrls.forEach(titleAndUrl -> {
            String title = titleAndUrl.getTitle();
            try {
                createDirectories(builderPath(headTitle, title));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private Path builderPath(String headTitle, String title) {
        return get(getBasePath() + headTitle + "/" + toValidFileName(title));
    }

    private String getBasePath() {
        return "D:/Burlesque/";
    }

    private String toValidFileName(String input) {
        return input.replaceAll("[ :\\\\/*\"?|<>']", "_");
    }
}
