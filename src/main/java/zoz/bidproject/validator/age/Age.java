package zoz.bidproject.validator.age;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = {AgeValidator.class})
public @interface Age {
	public int min() default 18;
	public int max() default 75;
	String message() default "Age must be between {min} - {max}";
	Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
