package specification;

import entity.Book;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Calendar;

public class BookByLastYear extends AbstractSpecification<Book> {

    private Calendar currDate;


    public BookByLastYear() {
        this.currDate = Calendar.getInstance();

    }

    public Predicate toPredicate(Root<Book> bookRoot, CriteriaBuilder criteriaBuilder) {

        Calendar prevYear = Calendar.getInstance();
        prevYear.add(Calendar.YEAR, -1);


        return criteriaBuilder.between(bookRoot.<Calendar>get("addDate"), prevYear, currDate);


        // return criteriaBuilder.
    }

}
