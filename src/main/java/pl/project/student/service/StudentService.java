package pl.project.student.service;

import pl.project.student.entity.Student;

import java.util.List;

/**
 * Created by A.Wójcik on 12.12.2019.
 */
public interface StudentService {

    public List<Student> findAll();

    public Student findById(long id);

    public void save(Student student);

    public void deleteById(long id);


    public List<Student> sortById();
    public List<Student> sortByFirstName();
    public List<Student> sortBySecondName();
    public List<Student> sortByLastName();
    public List<Student> sortByPesel();
    public List<Student> sortByDateOfBirth();

    public List<Student> searchStudents(String searchName);


}
