package pl.project.student.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by A.Wójcik on 23.12.2019.
 */
@Documented
@Constraint(validatedBy = ZipCodeValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ZipCodeConstraint {
    String message() default "Incorrect Zip Code.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
