package pl.project.student.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.project.student.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by A.Wójcik on 12.12.2019.
 */
@Repository
public class StudentRepositoryImpl implements StudentRepositoryCustom {

    EntityManager manager;

    @Autowired
    public StudentRepositoryImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Student> sortById() {
        CriteriaBuilder cb = manager.getCriteriaBuilder();

        CriteriaQuery<Student> criteriaQuery = cb.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);
        CriteriaQuery<Student> select = criteriaQuery.select(root);
        criteriaQuery.orderBy(cb.asc(root.get("id")));

        TypedQuery<Student> query = manager.createQuery(criteriaQuery);
        return query.getResultList();

    }

    @Override
    public List<Student> sortByFirstName() {
        CriteriaBuilder cb = manager.getCriteriaBuilder();

        CriteriaQuery<Student> criteriaQuery = cb.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);
        CriteriaQuery<Student> select = criteriaQuery.select(root);
        criteriaQuery.orderBy(cb.asc(root.get("firstName")));

        TypedQuery<Student> query = manager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public List<Student> sortBySecondName() {
        CriteriaBuilder cb = manager.getCriteriaBuilder();

        CriteriaQuery<Student> criteriaQuery = cb.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);
        CriteriaQuery<Student> select = criteriaQuery.select(root);
        criteriaQuery.orderBy(cb.asc(root.get("secondName")));

        TypedQuery<Student> query = manager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public List<Student> sortByLastName() {
        CriteriaBuilder cb = manager.getCriteriaBuilder();

        CriteriaQuery<Student> criteriaQuery = cb.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);
        CriteriaQuery<Student> select = criteriaQuery.select(root);
        criteriaQuery.orderBy(cb.asc(root.get("lastName")));

        TypedQuery<Student> query = manager.createQuery(criteriaQuery);
        return query.getResultList();

    }

    @Override
    public List<Student> sortByPesel() {
        CriteriaBuilder cb = manager.getCriteriaBuilder();

        CriteriaQuery<Student> criteriaQuery = cb.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);
        CriteriaQuery<Student> select = criteriaQuery.select(root);
        criteriaQuery.orderBy(cb.asc(root.get("pesel")));

        TypedQuery<Student> query = manager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public List<Student> sortByDateOfBirth() {
        CriteriaBuilder cb = manager.getCriteriaBuilder();

        CriteriaQuery<Student> criteriaQuery = cb.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);
        CriteriaQuery<Student> select = criteriaQuery.select(root);
        criteriaQuery.orderBy(cb.asc(root.get("dateOfBirth")));

        TypedQuery<Student> query = manager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public List<Student> searchStudents(String searchName) {

        CriteriaBuilder cb = manager.getCriteriaBuilder();

        CriteriaQuery<Student> criteriaQuery = cb.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);
        CriteriaQuery<Student> select = criteriaQuery.select(root);


        Predicate firstNameSearch = cb.like(root.get("firstName"), searchName);
        Predicate secondNameSearch = cb.like(root.get("secondName"), searchName);
        Predicate lastNameSearch = cb.like(root.get("lastName"), searchName);


        TypedQuery<Student> query = manager.createQuery(criteriaQuery.select(root).where(cb.or(firstNameSearch,
                secondNameSearch, lastNameSearch)));
        return query.getResultList();



    }

}
