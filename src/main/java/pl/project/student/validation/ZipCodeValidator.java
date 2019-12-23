package pl.project.student.validation;

import pl.project.student.entity.Student;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by A.Wójcik on 23.12.2019.
 */
public class ZipCodeValidator implements ConstraintValidator<ZipCodeConstraint, String> {

    @Override
    public void initialize(ZipCodeConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String zipCode, ConstraintValidatorContext constraintValidatorContext) {
        return zipCode.matches("[0-9]{2}-[0-9]{3}");
    }
}
