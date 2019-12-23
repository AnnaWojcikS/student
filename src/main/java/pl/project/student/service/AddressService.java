package pl.project.student.service;

import pl.project.student.entity.Address;
import pl.project.student.entity.Student;

import java.util.List;

/**
 * Created by A.Wójcik on 15.12.2019.
 */
public interface AddressService {

    public List<Address> findAll();

    public Address findById(long id);

    public Address save(Address address);

    public void deleteById(long id);

    //public List<Address> findByStudent(Student student);
}
