package com.gda.cotizador.utils;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Validacion {
	
	public static Set<ConstraintViolation<Object>> validatObject(Object object){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate( object );
		return constraintViolations;
		
	}
	
	public static String getViolationsObject(Set<ConstraintViolation<Object>> constraintViolations){
		String violations = "";
		for (Iterator<ConstraintViolation<Object>> iterator = constraintViolations.iterator(); iterator.hasNext();) {
			ConstraintViolation<Object> constraintViolation = (ConstraintViolation<Object>) iterator.next();
			if(violations.equals("")){
				violations += "El atributo '" + constraintViolation.getPropertyPath() + "' no cumple con las especificaciones : " 
							+ constraintViolation.getMessage();
			}else{
				violations += "\nEl atributo '" + constraintViolation.getPropertyPath() + "' no cumple con las especificaciones : "  
							+ constraintViolation.getMessage();
			}
		}
		return violations;
	}
	
}
