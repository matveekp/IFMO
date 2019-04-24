package dateTime;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.*;

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

        List<LocalDate> localDateList = new ArrayList<>();

        LocalTime timeNow = LocalTime.now();
        System.out.println(timeNow.getHour() + ":" + timeNow.getMinute());

        int hours = LocalTime.parse("06:15").getHour();

        System.out.println(LocalDateTime.now().getMonth().getDisplayName(TextStyle.FULL, Locale.CHINA));


        LocalDate startDate = LocalDate.parse("2016-04-12");
        LocalDate finaleDate = startDate.plus(Period.ofMonths(15));

        System.out.println(Period.between(startDate, finaleDate).getMonths());


        long between2 = ChronoUnit.DAYS.between(startDate, finaleDate);

        System.out.println(between2);


        System.out.println(finaleDate.compareTo(startDate));


        Set<String> allZones = ZoneId.getAvailableZoneIds();
        ZoneId zoneId = ZoneId.of("America/Cuiaba");


    }


}

