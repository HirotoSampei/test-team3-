package jp.te4a.spring.boot.myapp13.validate;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class WriterValidator implements ConstraintValidator<Writer,String>{
	String ok;
	@Override
	public void initialize(Writer nv){ ok =  nv.ok(); }
	@Override
	public boolean isValid(String in,ConstraintValidatorContext cxt){
		if(in == null){
			return false;
		}
		System.out.println(in.equals(ok));
		return in.equals(ok);
}}
