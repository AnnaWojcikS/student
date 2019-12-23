package pl.project.student.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by A.Wójcik on 22.12.2019.
 */
@Documented
@Constraint(validatedBy = DateOfBirthValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DateOfBirthConstraint {
    String message() default "You must be over 18 to register.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
