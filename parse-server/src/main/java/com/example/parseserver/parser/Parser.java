package com.example.parseserver.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component //объект создается автоматически
public class Parser {

    @Autowired //свойство создается автматом
    private ParserConfig config;

    @Bean
    public void start() throws IOException {
        System.out.println("Start...");
        Document document = Jsoup.connect(config.getLink()).get(); //получаем ссылку и считываем весь html
        // и передаем его в document

        Elements elements = document.select(".course-item a"); // используем CSS select
        //из блока .course-item берем ссылку а

        for (Element element : elements) {
            System.out.println(element.absUrl("href")); //передаем атрибут и получаем ссылку на основе текста атрибута
        }
    }

}
