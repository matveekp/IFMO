package ru.matveev.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.matveev.demo.entity.RssBean;

public interface RssBeanRepository extends CrudRepository<RssBean, Integer> {
}
