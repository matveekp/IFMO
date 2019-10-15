import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class UnitTest {

//    @BeforeAll
//        //необязательный метод
//    void  beforAll() {
//        System.out.println("вызывается перед выполнением всех тестов");
//    }
//
//    @BeforeEach
//        //необязательный метод
//    void beforeEach() {
//        System.out.println("вызывается перед выполнением каждого теста");
//    }

//    @AfterAll после выполнения всех тестов
//    @AfterEach после выполнения каждого теста

    @DisplayName("Test Name: equalsUnit") //задает имя теста для вывода
    @Test
    void equalsUnit() throws Exception {
        Unit unit1 = new Unit(10, 10);
        Unit unit2 = new Unit(10, 10);

//        assertSame(unit1, unit2); //проверяет ссылки

        assertEquals(unit1, unit2); // ссылки не проверяет, только свойства. Чтобы были равны объекты, переопределяем equals и hashcode

    }

    @Test
    void getHealth() throws Exception {
        Unit unit1 = new Unit(20, 30);
        final Unit unit2 = new Unit(30, 30);

        assertEquals(20, unit1.getHealth());
        assertEquals(30, unit2.getHealth());

        // объединение ассертов. Считается пройденным когда все внутри успешно
        assertAll("health",
                () -> assertEquals(20, unit1.getHealth()),
                () -> assertEquals(30, unit2.getHealth())

        );

    }

    @RepeatedTest(3)
    void changeHealth() throws Exception {
        Unit unit = new Unit(40, 40);
        unit.addHealth(10);
        assertEquals(50, unit.getHealth());

        unit.minusHealth(10);
        assertEquals(40, unit.getHealth());
    }

    @Test
    void throwExceptionIfNegativeOrZero() {
        // проверяем выбрасываются ли исключения
        assertAll("units",
                () -> assertThrows(Exception.class, () -> new Unit(-30, 20)),
                () -> assertThrows(Exception.class, () -> new Unit(30, 0)),
                () -> assertThrows(Exception.class, () -> new Unit(0, 20)),
                () -> assertThrows(Exception.class, () -> new Unit(0, -20))
        );
    }

    @Disabled // при запуске тестирования всех классов метод будет проигнорирован
    @Test
    void ignoredTest() {
        System.out.println("ignoredTest");
    }

    @ParameterizedTest
    @MethodSource("units")
        // задается имя метода, который будет возврщать юнитов 1 и 2  ( См. ниже метод, он возвращает юнитов)
    void attackOther(Unit unit1, Unit unit2) {


        unit1.attack(unit2);
        System.out.println(unit2.getHealth());
    }

    private static Unit[][] units() throws Exception {

        return new Unit[][]{
                {new Unit(1, 4), new Unit(2, 6)}
        };
    }

    // --------------

//    @ParameterizedTest
//    @ValueSource(strings = {"qwewqewq", "asdsadsad". "zxcxzcxz"})
//    void stringTest(String data){
//        assertTrue(someVoid(data));
//    }

   // метод будет выполняться только на указанных системах
//   @EnabledOnOs({OS.LINUX, OS.MAC})
//    @DisabledOnOs({OS.AIX})

    //
//    @EnabledOnJre({JRE.JAVA_8})
//    @DisabledOnJre({JRE.JAVA_13})

}
