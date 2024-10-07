package dasturlash.uz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentService studentService;

    @PostMapping("")
    public ResponseEntity<?>create(@RequestBody StudentDTO studentDTO) {
        return ResponseEntity.ok(studentService.add(studentDTO));
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAll() {
        List<StudentDTO> studentDTO = studentService.getAll();
        return ResponseEntity.ok(studentDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>get(@PathVariable String id) {
        return ResponseEntity.ok(studentService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable String id) {
        return ResponseEntity.ok(studentService.delete(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable String id, @RequestBody StudentDTO studentDTO) {
        return ResponseEntity.ok(studentService.update(id,studentDTO));
    }

}
