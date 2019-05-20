import entity.Article;
import entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class TstArticle {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("OrmExample");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Author author = new Author();
        author.setName("John");

//        entityManager.persist(author);

        for (int i = 1; i < 4; i++) {
            Article article = new Article();
            article.setTitle("Статья " + i);

            article.setAuthor(author);

            author.getArticles().add(article);

            entityManager.persist(article);
            entityManager.persist(author);

        }





        entityManager.getTransaction().commit();


//

        Author author1 = entityManager.find(Author.class, 51);
        System.out.println(author1.getName());


        List<Article> articles = entityManager.find(Author.class, 1651).getArticles();

        for (Article article : articles) {
         //   System.out.println(article.getTitle());
            article.setTitle("Новое название: " +article.getId());
        }




        entityManager.getTransaction().begin();

        entityManager.merge(author);

        entityManager.getTransaction().commit();




        entityManager.close();
        entityManagerFactory.close();



    }
}
