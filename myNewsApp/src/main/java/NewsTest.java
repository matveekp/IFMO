import entity.News;

import java.time.LocalDateTime;

public class NewsTest {
    public static void main(String[] args) {

        News news = new News();
        news.setNewsDate(LocalDateTime.now());
        news.setTitle("Fake news");
        news.setNewsText("It's very bad news");
    }
}
