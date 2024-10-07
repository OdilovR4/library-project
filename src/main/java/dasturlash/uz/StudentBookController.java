package dasturlash.uz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student_book")
public class StudentBookController {

    @Autowired
    private StudentBookService studentBookService;
    @PostMapping("/{id}/{id}")
    public ResponseEntity<StudentBookDTO>create(@PathVariable String studentId, @PathVariable String bookId) {
        return ResponseEntity.ok(studentBookService.createStudentBook(studentId,bookId));
    }

    @GetMapping("")
    public List<StudentBookDTO> getAllStudentBooks() {
        return studentBookService.getAll();
    }

}
