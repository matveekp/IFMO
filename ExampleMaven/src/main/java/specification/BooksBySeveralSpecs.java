package specification;

import entity.Book;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Calendar;
import java.util.List;

public class BooksBySeveralSpecs {

    private List<Specification> specifications;

    public BooksBySeveralSpecs(List<Specification> specifications) {
        this.specifications = specifications;
    }

    public Predicate toPredicate(Root<Book> bookRoot, CriteriaBuilder criteriaBuilder) {



        return criteriaBuilder.equal(bookRoot.<Calendar>get("addDate"), specifications);

    }

}
