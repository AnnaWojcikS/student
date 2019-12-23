package pl.project.student.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

/**
 * Created by A.Wójcik on 22.12.2019.
 */
public class DateOfBirthValidator implements ConstraintValidator<DateOfBirthConstraint, LocalDate> {


    @Override
    public void initialize(DateOfBirthConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(LocalDate birthDate, ConstraintValidatorContext constraintValidatorContext) {
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(birthDate, currentDate).getYears();
        return birthDate != null && age >= 18;
    }
}
