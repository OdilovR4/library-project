package dasturlash.uz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RequestMapping(value = "/book")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody BookDTO bookDto) {
            bookDto.setId(UUID.randomUUID().toString());
            return ResponseEntity.ok(bookService.add(bookDto));
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAll() {
        List<BookDTO> books = bookService.getAll();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        return ResponseEntity.ok(bookService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return ResponseEntity.ok(bookService.delete(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody BookDTO bookDto) {
        return ResponseEntity.ok(bookService.update(id,bookDto));
    }







}

