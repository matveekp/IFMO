package servlets;

import entity.News;
import repositories.NewsRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "ReadNewsServlet",
        urlPatterns = "/readnews"
)
public class ReadNewsServlet extends HttpServlet {
    private NewsRepository newsRepository;

    public ReadNewsServlet() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("OrmExample");
        newsRepository = new NewsRepository(factory.createEntityManager());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        News news = newsRepository.getById(id);

        RequestDispatcher view = req.getRequestDispatcher("readnews.jsp");
        req.setAttribute("news", news);
        view.forward(req, resp);


    }
}
