package zoz.bidproject.validator.age;

import java.time.LocalDate;
import java.time.Period;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, LocalDate> {
	
	private int min;
	private int max;
	@Override
	public void initialize(Age age) {
		this.min=age.min();
		this.max=age.max();
	}
	@Override
	public boolean isValid(LocalDate birthDay, ConstraintValidatorContext context) {
		int age=Period.between(birthDay, LocalDate.now()).getYears();
		System.out.println("Age: "+age);
		if(age<this.min || age>this.max ) {
			
			return false;
		}
		return true;
	}

}
