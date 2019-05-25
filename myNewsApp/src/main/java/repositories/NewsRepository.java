package repositories;

import entity.News;
import org.springframework.data.repository.CrudRepository;


public interface NewsRepository extends CrudRepository<News, Integer> {



}
