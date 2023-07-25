package com.alexsandro.validation;

import com.alexsandro.validation.constraintvalidation.NotEmpityListValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The interface Not empty list.
 */
@Retention(RetentionPolicy.RUNTIME) //ser verificada em tempo de execução
@Target(ElementType.FIELD) //será usada em campos
@Constraint(validatedBy = NotEmpityListValidation.class) //quem de fato valida-rá o compo
public @interface NotEmptyList {
  /**
   * Message string.
   *
   * @return the string
   */
  String message() default "A lsita não pode ser vazia.";

  /**
   * Groups class [ ].
   *
   * @return the class [ ]
   */
  // requerido pela anotation, é padrão em anotations de validação.
  Class<?>[] groups() default {};

  /**
   * Payload class.
   *
   * @return the class
   */
  Class<? extends Payload>[] payload() default {};
}
