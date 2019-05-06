package logging;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

public class LoggedExample {

    private static final Logger LOGGER = Logger.getLogger(LoggedExample.class.getName());

    static {


        LOGGER.setLevel(Level.ALL);
        try {

            // логирование в xml файл
            LOGGER.addHandler(new FileHandler("loggedExample.log.xml"));

//        вывод в виде простого текста

            FileHandler fileHandler = new FileHandler("loggedExample.log");
//            fileHandler.setFormatter(new SimpleFormatter());

            fileHandler.setFormatter(new CusstomFormatter());

            LOGGER.addHandler(fileHandler);


        } catch (IOException e) {
            LOGGER.warning("FileHandler не доступен");
        }


    }


    public static void main(String[] args) {


        LOGGER.info("Hello");


    }
}


class CusstomFormatter extends Formatter {

    private final static ThreadLocal<DateFormat> dateFormat = new ThreadLocal<DateFormat>() {

        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };


    @Override
    public String format(LogRecord record) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[').append(formateDate(record.getMillis())).append(']')

        .append('[').append(record.getLevel()).append(']')
                .append('[').append(record.getSourceClassName())
                .append('.').append(record.getSourceMethodName()).append(']')
                .append(" - ").append(record.getMessage());


        return stringBuilder.toString();


    }

    private String formateDate(long millis){
        return dateFormat.get().format(new Date(millis));
    }


}

