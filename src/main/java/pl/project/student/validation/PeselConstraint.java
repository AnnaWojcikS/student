package pl.project.student.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDate;

/**
 * Created by A.Wójcik on 22.12.2019.
 */
@Constraint(validatedBy = PeselValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface PeselConstraint {
    String message() default "Incorrect PESEL.";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
