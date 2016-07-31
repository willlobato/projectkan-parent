package projectkan.util;

import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.springframework.stereotype.Component;
import projectkan.exception.BusinessException;
import projectkan.exception.ConstraintException;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Created by willlobato on 30/07/16.
 */
@Component
public class ValidationUtil<T> {

    @Inject
    private Validator validator;

    public void validate(T t) throws BusinessException {
        Set<ConstraintViolation<T>> violations = validator.validate(t);
        if(!violations.isEmpty()) {
            ConstraintException exception = new ConstraintException(String.format("Fields with error constraint to %s",t));
            for(ConstraintViolation<T> violation : violations) {
                ConstraintException.Constraint constraint = exception.new Constraint();
                constraint.setField(violation.getPropertyPath().toString());
                constraint.setMessageTemplate(violation.getMessageTemplate());
                constraint.setInterpolatedMessage(((ConstraintViolationImpl)violation).getMessage());
                exception.add(constraint);
            }
            throw exception;
        }
    }

}
