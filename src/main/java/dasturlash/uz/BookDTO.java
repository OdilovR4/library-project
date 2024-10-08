package dasturlash.uz;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class BookDTO {
    private String id;
    private String title;
    private String author;
    private LocalDate published_year = LocalDate.now();
}
