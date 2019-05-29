package com.example.parseserver.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@EnableScheduling //запуск по расписанию
@Component //объект создается автоматически
public class Parser {

    @Autowired //свойство создается автматом
    private ParserConfig config;

    @Autowired
    private ApplicationContext context; // получить все объекты, которые там созданы

    @Autowired
    private TaskExecutor taskExecutor;

    @Scheduled(fixedRate = 60000)
    //@Bean //запустится один раз, вместо этого делаем @EnableScheduling + @Scheduled у метода
    public void start() throws IOException {
        System.out.println("Start...");
        Document document = Jsoup.connect(config.getLink()).get(); //получаем ссылку и считываем весь html
        // и передаем его в document

        Elements elements = document.select(".course-item a"); // используем CSS select
        //из блока .course-item берем ссылку а

        for (Element element : elements) {
            System.out.println(element.absUrl("href")); //передаем атрибут и получаем ссылку на основе текста атрибута

            ParserThread thread = context.getBean(ParserThread.class);
            thread.setLink(element.absUrl("href"));

            taskExecutor.execute(thread);

        }
    }

}
