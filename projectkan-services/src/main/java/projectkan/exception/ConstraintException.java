package projectkan.exception;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by willlobato on 30/07/16.
 */
@Data
public class ConstraintException extends BusinessException {

    private List<Constraint> constraints = new ArrayList<Constraint>();

    public ConstraintException(String message) {
        super(message);
    }

    @Data
    public class Constraint {

        private String field;
        private String messageTemplate;
        private String interpolatedMessage;

    }

    public void add(Constraint constraint) {
        this.constraints.add(constraint);
    }


}
