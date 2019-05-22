package repositories;

import entity.News;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class NewsRepository {
    private EntityManager entityManager;

    public NewsRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addNews(News news){
        entityManager.getTransaction().begin();
        entityManager.persist(news);
        entityManager.getTransaction().commit();
    }

    public News getById(int id){
        return entityManager.find(News.class, id);
    }

    public List<News>  getAllNews(){
        TypedQuery<News> query = entityManager.createQuery("SELECT b FROM News b", News.class);
        return query.getResultList();
    }


}
