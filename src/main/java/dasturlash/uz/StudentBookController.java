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

    @PostMapping("")
    public ResponseEntity<StudentBookDTO> create(@RequestBody StudentBookDTO dto) {
        return ResponseEntity.ok(studentBookService.createStudentBook(dto.getStudentId(), dto.getBookId()));
    }

    @GetMapping("")
    public ResponseEntity<List<StudentBookDTO>> getAllStudentBooks() {
        return ResponseEntity.ok(studentBookService.getAll());
    }

    @PutMapping("")
    public ResponseEntity<?> returning(@RequestBody StudentBookDTO dto) {
        return ResponseEntity.ok(studentBookService.returning(dto.getStudentId(), dto.getBookId()));
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<?> getBookSByStudentId(@PathVariable("id") String studentId) {
        return ResponseEntity.ok(studentBookService.getBookSByStudentId(studentId));
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> getStudentsByBookId(@PathVariable("id") String bookId) {
        return ResponseEntity.ok(studentBookService.getStudentsByBookId(bookId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentBookById(@PathVariable String id) {
        return ResponseEntity.ok(studentBookService.getStudentBookById(id));
    }


}
