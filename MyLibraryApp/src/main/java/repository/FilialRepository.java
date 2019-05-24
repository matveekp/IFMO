package repository;

import entity.Filial;
import specification.Specification;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class FilialRepository implements Repository<Filial, Integer> {

    private EntityManager entityManager;

    public FilialRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void add(Filial filial) {
        // начинаем транзакцию
        entityManager.getTransaction().begin();

        // добавление в записи в бд
        entityManager.persist(filial);

        // потверждаем транакцию
        entityManager.getTransaction().commit();
    }

    public void update(Filial filial) {
        entityManager.getTransaction().begin();
        entityManager.merge(filial); // обновление существующей записи в бд
        //поиск по уникальному идентификатору

        entityManager.getTransaction().commit();
    }

    public void delete(Integer integer) {
        entityManager.getTransaction().begin();

        Filial filial = getByPk(integer);
        entityManager.remove(filial); // удаление записи из бд


        entityManager.getTransaction().commit();
    }

    public Filial getByPk(Integer integer) {
        return entityManager.find(Filial.class, integer);
    }

    public List<Filial> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Filial> criteriaQuery = criteriaBuilder.createQuery(Filial.class);
        Root<Filial> root = criteriaQuery.from(Filial.class);
        criteriaQuery.select(root); // получили строчку запроса

        // получаем объект запроса
        TypedQuery<Filial> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Filial> filials = typedQuery.getResultList();


        return filials;
    }

    public List<Filial> getBySpecification(Specification spec) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Filial> criteriaQuery = criteriaBuilder.createQuery(spec.getType());

        Root<Filial> root = criteriaQuery.from(spec.getType());

        Predicate condition = spec.toPredicate(root, criteriaBuilder);
        criteriaQuery.where(condition);



        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
