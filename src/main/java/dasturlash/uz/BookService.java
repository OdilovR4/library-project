package dasturlash.uz;

import dasturlash.uz.exceptions.BookBadException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Service
public class BookService {

    private List<BookDTO> bookList = new LinkedList<>();

    public ResponseEntity<BookDTO> add(BookDTO bookDto) {
        validate(bookDto);
        bookList.add(bookDto);
        return ResponseEntity.ok(bookDto);
    }

    public void validate(BookDTO bookDto) {
        if (bookDto.getAuthor() == null || bookDto.getAuthor().isBlank()) {
            throw new BookBadException("Auhtor is required");
        }

        if (bookDto.getTitle() == null || bookDto.getTitle().isBlank()) {
            throw new BookBadException("Title is required");
        }
    }

    public List<BookDTO> getAll() {
        return bookList;
    }

    public BookDTO getById(String id) {
        for (BookDTO bookDto : bookList) {
            if (bookDto.getId().equals(id)) {
                return bookDto;
            }
        }
        throw new BookBadException("Book not found");
    }

    public boolean delete(String id) {
        for (BookDTO bookDto : bookList) {
            if (bookDto.getId().equals(id)) {
                bookList.remove(bookDto);
                return true;
            }
        }
        throw new BookBadException("Book of this id not found");
    }

    public boolean update(String id, BookDTO bookDto) {
        for (BookDTO bookDto1 : bookList) {
            if (bookDto1.getId().equals(id)) {
                bookDto1.setTitle(bookDto.getTitle());
                bookDto1.setAuthor(bookDto.getAuthor());
                bookDto1.setPublished_year(LocalDate.now());
                return true;
            }
        }
        throw new BookBadException("Book not updated");
    }
}
