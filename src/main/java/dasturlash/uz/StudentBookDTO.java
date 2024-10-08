package dasturlash.uz;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class StudentBookDTO {
    private String id = UUID.randomUUID().toString();
    private String bookId;
    private String studentId;
    private Status status = Status.TAKEN;
    private LocalDateTime created_date;
    private LocalDateTime returned_date;
}
