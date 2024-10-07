package dasturlash.uz;

import dasturlash.uz.exceptions.BookBadException;
import dasturlash.uz.exceptions.StudentBadException;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class StudentService {
    private List<StudentDTO> studentList = new LinkedList<>();
    public boolean add(StudentDTO studentDTO) {
        validate(studentDTO);
        return studentList.add(studentDTO);
    }

    public List<StudentDTO> getAll() {
        return studentList;
    }

    public StudentDTO getById(String id) {
        for (StudentDTO studentDTO : studentList) {
            if (studentDTO.getId().equals(id)) {
                return studentDTO;
            }
        }
        throw new StudentBadException("Student not found");
    }

    public boolean delete(String id) {
        for (StudentDTO studentDTO : studentList) {
            if (studentDTO.getId().equals(id)) {
                studentList.remove(studentDTO);
                return true;
            }
        }
        throw new StudentBadException("Student of this id not found");
    }

    public boolean update(String id, StudentDTO studentDTO) {
        for (StudentDTO studentDTO1: studentList) {
            if (studentDTO1.getId().equals(id)) {
                studentDTO1.setName(studentDTO.getName());
                studentDTO1.setSurname(studentDTO.getSurname());
                studentDTO1.setPhone(studentDTO.getPhone());
                return true;
            }
        }
        throw new StudentBadException("Student not updated");
    }

    public void validate(StudentDTO studentDTO) {
        if (studentDTO.getName() == null || studentDTO.getName().isBlank()) {
            throw new StudentBadException("Name is required");
        }

        if (studentDTO.getSurname() == null || studentDTO.getSurname().isBlank()) {
            throw new StudentBadException("Surname is required");
        }

        if (studentDTO.getPhone() == null || studentDTO.getPhone().isBlank()) {
            throw new StudentBadException("Phone is required");
        }

    }
}
