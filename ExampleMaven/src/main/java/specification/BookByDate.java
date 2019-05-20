package specification;

import entity.Book;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Calendar;

public class BookByDate extends AbstractSpecification<Book> {

    private Calendar calendar;

    public BookByDate(Calendar calendar) {
        this.calendar = calendar;
    }

    public Predicate toPredicate(Root<Book> bookRoot, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.greaterThanOrEqualTo(bookRoot.<Calendar>get("addDate"), calendar);


   // return criteriaBuilder.
    }

}
