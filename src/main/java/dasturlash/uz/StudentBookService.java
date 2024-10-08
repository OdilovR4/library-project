package dasturlash.uz;

import dasturlash.uz.exceptions.StudentBadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
        validateId(studentId, bookId);
        StudentBookDTO studentBookDTO = new StudentBookDTO();
        studentBookDTO.setStudentId(studentId);
        studentBookDTO.setBookId(bookId);
        studentBookDTO.setCreated_date(LocalDateTime.now());
        studentBookList.add(studentBookDTO);
        return studentBookDTO;
    }

    public List<StudentBookDTO> getAll() {
        return studentBookList;
    }


    public void validateId(String studentId, String bookId) {
        StudentDTO studentDTO = studentService.getById(studentId);
        BookDTO bookDTO = bookService.getById(bookId);
    }


    public StudentBookDTO returning(String studentId, String bookId) {
        for (StudentBookDTO studentBookDTO : studentBookList) {
            if (studentBookDTO.getStudentId().equals(studentId) && studentBookDTO.getBookId().equals(bookId)) {
                studentBookDTO.setReturned_date(LocalDateTime.now());
                studentBookDTO.setStatus(Status.RETURNED);
                return studentBookDTO;
            }
        }
        throw new StudentBadException("id not found");
    }

    public List<BookDTO> getBookSByStudentId(String studentId) {
        List<BookDTO> bookList = new ArrayList<>();
        for (StudentBookDTO studentBookDTO : studentBookList) {
            if (studentBookDTO.getStudentId().equals(studentId)) {
                BookDTO bookDTO = bookService.getById(studentBookDTO.getBookId());
                bookList.add(bookDTO);
            }
        }
        if (bookList.isEmpty()) {
            throw new StudentBadException("Books not found");
        }
        return bookList;
    }

    public List<StudentDTO> getStudentsByBookId(String bookId) {
        List<StudentDTO> studentList = new ArrayList<>();
        for (StudentBookDTO studentBookDTO : studentBookList) {
            if (studentBookDTO.getBookId().equals(bookId)) {
                StudentDTO studentDTO = studentService.getById(studentBookDTO.getStudentId());
                studentList.add(studentDTO);
            }
        }

        if (studentList.isEmpty()) {
            throw new StudentBadException("Students not found");
        }
        return studentList;
    }

    public String getStudentBookById(String id) {
        String result = null;
        for (StudentBookDTO studentBookDTO : studentBookList) {
            if (studentBookDTO.getId().equals(id)) {
                BookDTO bd = bookService.getById(studentBookDTO.getBookId());
                StudentDTO sd = studentService.getById(studentBookDTO.getStudentId());
                result = "id " + id + ",\n"
                        + "student {" + sd.getId() + ", " + sd.getName() + ", " + sd.getSurname() + " },\n"
                        + "book {" + bd.getId() + ", " + bd.getTitle() + " },\n"
                        + "created_date " + studentBookDTO.getCreated_date() + ", \n"
                        + "status " + studentBookDTO.getStatus() + ", \n"
                        + "returned_date " + studentBookDTO.getReturned_date();
            }
        }
        if (result == null) {
            throw new StudentBadException("id not found");
        }
        return result;
    }
}
