package pl.project.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.student.dao.AddressRepository;
import pl.project.student.entity.Address;
import pl.project.student.entity.Student;

import java.util.List;
import java.util.Optional;

/**
 * Created by A.Wójcik on 15.12.2019.
 */
@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(long id) {
        Optional<Address> result = addressRepository.findById(id);
        Address address = null;

        if(result.isPresent()) {
            address = result.get();
        } else {
            throw new RuntimeException("Could not find the id" + id);
        }
        return address;
    }

    @Override
    public Address save(Address address) {
        addressRepository.save(address);

        return address;
    }

    @Override
    public void deleteById(long id) {
        addressRepository.deleteById(id);

    }

}
