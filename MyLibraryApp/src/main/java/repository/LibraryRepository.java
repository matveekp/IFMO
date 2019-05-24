package repository;


import entity.Library;
import specification.Specification;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class LibraryRepository implements Repository<Library, Integer> {
    private EntityManager entityManager;

    public LibraryRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void add(Library library) {

        // начинаем транзакцию
        entityManager.getTransaction().begin();

        // добавление в записи в бд
        entityManager.persist(library);

        // потверждаем транакцию
        entityManager.getTransaction().commit();
    }

    public void update(Library library) {
        entityManager.getTransaction().begin();
        entityManager.merge(library); // обновление существующей записи в бд
        //поиск по уникальному идентификатору

        entityManager.getTransaction().commit();
    }

    public void delete(Integer integer) {
        entityManager.getTransaction().begin();

        Library library = getByPk(integer);
        entityManager.remove(library); // удаление записи из бд


        entityManager.getTransaction().commit();
    }

    public Library getByPk(Integer integer) {
        return entityManager.find(Library.class, integer);
    }

    public List<Library> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Library> criteriaQuery = criteriaBuilder.createQuery(Library.class);
        Root<Library> root = criteriaQuery.from(Library.class);
        criteriaQuery.select(root); // получили строчку запроса

        // получаем объект запроса
        TypedQuery<Library> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Library> libraries = typedQuery.getResultList();


        return libraries;
    }

    public List<Library> getBySpecification(Specification spec) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Library> criteriaQuery = criteriaBuilder.createQuery(spec.getType());

        Root<Library> root = criteriaQuery.from(spec.getType());

        Predicate condition = spec.toPredicate(root, criteriaBuilder);
        criteriaQuery.where(condition);



        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
