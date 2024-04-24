package com.choujigen.ogre.form;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = HissatsuNameValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface HissatsuNameConstraint {
	String message() default "Invalid hissatsu name";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
