package entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Entity
@Table
public class News {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment") // аннотация spring
    private int id;
    private String title;
    private String newsText;

    // раз дата придет строчкой из формы, то ее нужно конвертировать. поэтому используется аннотация. Это возможнотсь спринга
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") //T - это разделитель для форматирования, через пробел нельзя
    private LocalDateTime newsDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNewsText() {
        return newsText;
    }

    public void setNewsText(String newsText) {
        this.newsText = newsText;
    }

    public LocalDateTime getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(LocalDateTime newsDate) {
        this.newsDate = newsDate;
    }


}
