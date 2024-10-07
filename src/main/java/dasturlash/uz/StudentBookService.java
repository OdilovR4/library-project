package dasturlash.uz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Service
public class StudentBookService {

    @Autowired
    private StudentService studentService;
    @Autowired
    private BookService bookService;
    private List<StudentBookDTO> studentBookList = new LinkedList<>();
    public StudentBookDTO createStudentBook(String studentId, String bookId) {
        StudentDTO studentDTO = studentService.getById(studentId);
        BookDTO bookDTO = bookService.getById(bookId);
        studentService.validate(studentDTO);
        bookService.validate(bookDTO);
        StudentBookDTO studentBookDTO = new StudentBookDTO();
        studentBookDTO.setStudent(studentDTO);
        studentBookDTO.setBook(bookDTO);
        studentBookDTO.setCreated_date(LocalDate.now());
        studentBookList.add(studentBookDTO);
        return studentBookDTO;
    }


    public List<StudentBookDTO> getAll() {
        return studentBookList;
    }
}
