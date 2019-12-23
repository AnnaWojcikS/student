package pl.project.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.student.entity.Address;
import pl.project.student.entity.Student;
import pl.project.student.dao.StudentRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by A.Wójcik on 12.12.2019.
 */
@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private AddressService addressService;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(long id) {
        Optional<Student> result = studentRepository.findById(id);
        Student student = null;

        if(result.isPresent()) {
            student = result.get();
        } else {
            throw new RuntimeException("Could not find the id" + id);
        }
        return student;
    }

    @Override
    public Student save(Student student) {
       /* if(student != null) {
            if(student.getAddresses() != null) {
                student.getAddresses().forEach(address -> {
                    if(address.getAddressType() == null) {
                        throw new RuntimeException("Address Type is required.");
                    } if (address.getId() == null) {
                        Address newAddress = addressService.save(address);
                        address.setId(newAddress.getId());
                    }
                });
            }
        }*/
        studentRepository.save(student);
        return student;
    }

    @Override
    public void deleteById(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> sortById() {
        return studentRepository.sortById();
    }

    @Override
    public List<Student> sortByFirstName() {
        return studentRepository.sortByFirstName();
    }

    @Override
    public List<Student> sortBySecondName() {
        return studentRepository.sortBySecondName();
    }

    @Override
    public List<Student> sortByLastName() {
        return studentRepository.sortByLastName();
    }

    @Override
    public List<Student> sortByPesel() {
        return studentRepository.sortByPesel();
    }

    @Override
    public List<Student> sortByDateOfBirth() {
        return studentRepository.sortByDateOfBirth();
    }

    @Override
    public List<Student> searchStudents(String searchName) {
        return studentRepository.searchStudents(searchName);
    }



}
