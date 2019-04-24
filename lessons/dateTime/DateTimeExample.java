package dateTime;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTimeExample {

    public static void main(String[] args) {
        Date date = new Date();
        Date other = new Date();
        System.out.println(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("День: dd Месяц: MM Год: yyyy HH:mm");
        System.out.println(simpleDateFormat.format(date));


        Calendar calendar = new GregorianCalendar();
        Calendar calendar1 = new GregorianCalendar(2019, Calendar.APRIL, 12);

        //увеличение
        calendar.add(Calendar.DAY_OF_MONTH, 2);

        //уменьшение
        calendar1.add(Calendar.MONTH, -3);


        System.out.println(calendar.get(Calendar.HOUR) + calendar.get(Calendar.MINUTE));


        //Java 8 Date Time API

//        LocalDate, LocalTime, LocalDateTime, Period, Duration

        LocalDate localDate = LocalDate.now();

        System.out.println(localDate.getDayOfWeek());


        LocalDateTime localDateTime = LocalDateTime.now();


        LocalDate someDate = LocalDate.of(2019, Month.APRIL, 16);

        System.out.println(someDate);


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

        String strDate = "14/04/2018";

        LocalDate parseDate = LocalDate.parse(strDate, dateTimeFormatter);

      //  System.out.println(dateTimeFormatter.format(parseDate));

        System.out.println(parseDate);

        System.out.println(parseDate.minusDays(5));
    }
}
