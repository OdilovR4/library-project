package dasturlash.uz;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class StudentBookDTO {
    private String id = UUID.randomUUID().toString();
    private BookDTO book;
    private StudentDTO student;
    private Status status = Status.TAKEN;
    private LocalDate created_date;
    private LocalDate returned_date;
}
