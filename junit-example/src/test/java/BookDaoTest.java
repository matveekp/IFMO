import mockito.Book;
import mockito.BookDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookDaoTest {

    @Mock
    BookDao bookDao;

    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getBookByIdTest(){
        // определение поведения bookDao

        Mockito.when(bookDao.getBookById(1)).thenReturn(new Book("Азбука", 123));

        final Book book = bookDao.getBookById(1);

        assertAll("book",
                ()-> assertEquals("Азбука", book.getTitle()),
                ()-> assertEquals(123, book.getPageCount())

                );


        //метод verify позволяет проверить, была ли выполнена проверка с определенными параметрами
        verify(bookDao).getBookById(1);
        verify(bookDao, atLeast(1)).getBookById(1);
        verify(bookDao, never()).getBookById(34);


        // это все на заглушках тестируется

    }


    @Test
    public void testList(){
        List<Integer> integerList = new ArrayList<>();
        List<Integer> spyList = spy(integerList);

        spyList.add(23); // добавляем числа
        spyList.add(12);

        verify(spyList).add(23); //проверяем добавлялись ли числа
        verify(spyList).add(12);

        assertEquals(2, spyList.size());


    }








}
