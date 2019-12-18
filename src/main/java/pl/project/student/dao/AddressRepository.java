package pl.project.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.student.entity.Address;

/**
 * Created by A.Wójcik on 15.12.2019.
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long>, AddressRepositoryCustom{
}
