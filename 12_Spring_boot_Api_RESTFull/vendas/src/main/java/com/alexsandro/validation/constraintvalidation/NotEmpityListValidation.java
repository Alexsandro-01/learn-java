package com.alexsandro.validation.constraintvalidation;

import com.alexsandro.validation.NotEmptyList;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * The type Not empity list validation.
 */
public class NotEmpityListValidation implements ConstraintValidator<NotEmptyList, List> {
  /**
   * Constructor.
   *
   * @param constraintAnnotation the anotation validator
   */
  @Override
  public void initialize(NotEmptyList constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  /**
   * Method for validate the list.
   *
   * @param list the list to be validated
   * @param constraintValidatorContext constraint validation context
   * @return if list is valid
   */
  @Override
  public boolean isValid(List list, ConstraintValidatorContext constraintValidatorContext) {
    return list != null && !list.isEmpty();
  }
}
