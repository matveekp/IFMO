package repository;


import specification.Specification;

import java.util.List;

public interface Repository<T, PK> {

    void add(T t); //добавление в бд
    void update(T t); // обновление записи в бд
    void delete(PK pk); // удаление записи в бд по первичному ключу
    T getByPk(PK pk); // получение записи по идентификатору (PK)
    List<T> getAll(); // получение всех записей
    List<T> getBySpecification(Specification spec); // передаем объект критерия поиска


}
