package ru.matveev.demo.controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


import ru.matveev.demo.entity.News;
import ru.matveev.demo.entity.RssBean;
import ru.matveev.demo.repositories.RssBeanRepository;


@Controller
public class RssController {
    @Autowired
    private RssBeanRepository rssBeanRepository;


    private URL rssUrl; ;
    private List<RssBean> rssList = null;


    //    @RequestMapping("/getRssReader")
    @RequestMapping(value = "/rssReader" , method = RequestMethod.GET)
    public String getRssReader(@ModelAttribute RssBean event, Model model) {

        rssList = new ArrayList<RssBean>();

        try {
            System.out.println("hello!");
//           rssUrl = new URL("http://www.springcome.me/?feed=rss2");
            rssUrl = new URL("http://feeds.bbci.co.uk/news/world/rss.xml");

            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(rssUrl.openStream());

            NodeList items = doc.getElementsByTagName("item");
            for (int i = 0; i < items.getLength(); i++) {
                Element item = (Element) items.item(i);
                RssBean rss = new RssBean();
                rss.setTitle(getValue(item, "title"));
                rss.setDescription(getValue(item, "description"));
                rss.setLink(getValue(item, "link"));
                rssList.add(rss);

                model.addAttribute("rss", new RssBean());

                rssBeanRepository.save(rss);

                System.out.println(rss.getTitle() +"         " + rss.getDescription() +"         " + rss.getLink());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("rss", rssList);

//        return "rss/rssReader";
        return "rssReader";



    }

    private String getValue(Element parent, String nodeName) {
        return parent.getElementsByTagName(nodeName).item(0).getFirstChild().toString();
    }
}
