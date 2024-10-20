package com.wallet.service;

import jakarta.validation.*;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class classValidator <T>{
    private Validator validator;

    public void ValidatorOfValidationService(Validator validator) {
        this.validator = validator;
    }

    public void validateInput(T InputClass) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(InputClass);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    public void validateInputWithInjectedValidator(T InputClass) {
        Set<ConstraintViolation<T>> violations = validator.validate(InputClass);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
