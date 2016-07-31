package projectkan.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by willlobato on 28/07/16.
 */
public abstract class BusinessException extends Exception {

    @Getter
    @Setter
    private Integer code;

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
