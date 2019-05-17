import entity.Article;
import entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TstArticle {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("OrmExample");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Author author = new Author();
        author.setName("Bob");

//        entityManager.persist(author);

        for (int i = 1; i < 4; i++) {
            Article article = new Article();
            article.setTitle("Статья " + i);
            article.setAuthor(author);


            entityManager.persist(article);

            entityManager.persist(author);

        }





        entityManager.getTransaction().commit();




        Author author1 = entityManager.find(Author.class, 252);
        System.out.println(author1.getName());


        List<Article> articles = entityManager.find(Author.class, 252).getArticles();

        for (Article article : articles) {
            System.out.println(article.getTitle());
        }









        entityManager.close();
        entityManagerFactory.close();



    }
}
