package pl.project.student.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import pl.project.student.entity.Address;
import pl.project.student.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

/**
 * Created by A.Wójcik on 15.12.2019.
 */
@Repository
public class AddressRepositoryImpl implements AddressRepositoryCustom {

    EntityManager manager;

    @Autowired
    public AddressRepositoryImpl(EntityManager manager) {
        this.manager = manager;
    }


}
