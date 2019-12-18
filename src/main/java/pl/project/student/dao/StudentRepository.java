package pl.project.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.student.entity.Student;

/**
 * Created by A.Wójcik on 10.12.2019.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, StudentRepositoryCustom {

}
