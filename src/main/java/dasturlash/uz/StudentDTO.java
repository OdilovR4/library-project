package dasturlash.uz;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class StudentDTO {
    private String id = UUID.randomUUID().toString();
    private String name;
    private String surname;
    private String phone;
    private LocalDate created_date = LocalDate.now();
    private BookDTO book;
}
