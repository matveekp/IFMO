package specification;

import entity.Book;
import entity.Filial;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class BooksByFilial extends AbstractSpecification<Book> {
    private String name;

    public BooksByFilial(String name) {
        this.name = name;
    }

    public Predicate toPredicate(Root<Book> bookRoot, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(bookRoot.<String>get("filial"), name);
    }
}
