package dasturlash.uz;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BookDTO {
    private String id;
    private String title;
    private String author;
    private LocalDate published_year = LocalDate.now();
    private StudentDTO student;
}
