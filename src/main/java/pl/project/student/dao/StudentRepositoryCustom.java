package pl.project.student.dao;

import org.springframework.stereotype.Repository;
import pl.project.student.entity.Student;

import java.util.List;

/**
 * Created by A.Wójcik on 12.12.2019.
 */
@Repository
public interface StudentRepositoryCustom {

    public List<Student> sortById();
    public List<Student> sortByFirstName();
    public List<Student> sortBySecondName();
    public List<Student> sortByLastName();
    public List<Student> sortByPesel();
    public List<Student> sortByDateOfBirth();
    public List<Student> searchStudents(String searchName);

}
