package ru.matveev.demo.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


import ru.matveev.demo.entity.RssBean;


@Controller
@RequestMapping("/rss")
public class RssController {

    private URL rssUrl = null;
    private List<RssBean> rssList = null;

//    @RequestMapping("/getRssReader")
    @RequestMapping(value = "/getRssReader" , method = RequestMethod.GET)
    public String getRssReader(HttpServletRequest request, HttpServletResponse response) {
        rssList = new ArrayList<RssBean>();
        try {
            rssUrl = new URL("http://www.springcome.me/?feed=rss2");

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
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("rss", rssList);

        return "rss/rssReader";
    }

    private String getValue(Element parent, String nodeName) {
        return parent.getElementsByTagName(nodeName).item(0).getFirstChild().toString();
    }
}
