package repository;

import entity.Book;
import specification.Specification;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;


public class BookRepository implements Repository<Book, Integer> {
    // integer - потому что у нас поле с аннотацией @Id - типа int
    private EntityManager entityManager;

    // изодя из паттера инъекция зависимостей, мы не должны создавать entity manager вручную, а
    // передавать его через конструктор
    public BookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void add(Book book) {
        // начинаем транзакцию
        entityManager.getTransaction().begin();

        // добавление в записи в бд
        entityManager.persist(book);

        // потверждаем транакцию
        entityManager.getTransaction().commit();
    }

    public void update(Book book) {

        entityManager.getTransaction().begin();
        entityManager.merge(book); // обновление существующей записи в бд
        //поиск по уникальному идентификатору

        entityManager.getTransaction().commit();
    }

    public void delete(Integer integer) {
        entityManager.getTransaction().begin();

        Book book = getByPk(integer);
        entityManager.remove(book); // удаление записи из бд


        entityManager.getTransaction().commit();
    }

    // получение одной записи
    public Book getByPk(Integer integer) {

        return entityManager.find(Book.class, integer);
    }

    public List<Book> getAll() {
        // 1 named query

//        TypedQuery<Book> query  = entityManager.createNamedQuery("Book.findAll", Book.class);
//        List<Book> books = query.getResultList();
//        List<Book> books = query.getResultStream();
//        List<Book> books = query.getSingleResult(); - вернет одну книгу


        // 2 вариант - JPQL
        // запросы прописываются прямо здесь
//        Query<Book> можно использовать также как и TypedQuery
//        Query query = entityManager.createQuery("SELECT b from Book b");
//        List<Book> books = query.getResultList();


        // 3 вариант - Criteria API
        // нет никаких запросов, только методы
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);
        criteriaQuery.select(root); // получили строчку запроса

        // получаем объект запроса
        TypedQuery<Book> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Book> books = typedQuery.getResultList();


        return books;
    }



    public Book getByTitle(String title) {
//        1. Named query
//        TypedQuery<Book> query = entityManager.createNamedQuery("Book.findByTitle", Book.class );
//        query.setParameter("title", title); // установка значения для параметра.
//        // это не имя столбца, это то что в классе Book в аннотации в запросе -    :title
//
//        Book book = query.getSingleResult();
//
        // 2. JPQL
//        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b where b.title = :title", Book.class);
//        query.setParameter("title", title);
//        Book book = query.getSingleResult();
//        return book;

        // 3. Criteria API
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> query = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);

        query.select(root);

        Predicate condition = criteriaBuilder.equal(root.<String>get("title"), title); // получаем значение из таблицы и сравниваем его
        query.select(root).where(condition); // сформировали строчку "SELECT b FROM Book b where title = " + title

        TypedQuery<Book> typedQuery = entityManager.createQuery(query);

        Book book = typedQuery.getSingleResult();

        return book;
    }



    public List<Book> getBySpecification(Specification spec) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(spec.getType());

        Root<Book> root = criteriaQuery.from(spec.getType());

        Predicate condition = spec.toPredicate(root, criteriaBuilder);
        criteriaQuery.where(condition);



        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
