package projectkan.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projectkan.exception.BusinessException;
import projectkan.model.User;
import projectkan.repository.UserRepository;
import projectkan.util.ValidationUtil;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by willlobato on 28/07/16.
 */
@Slf4j
@Service
@Transactional
public class UserService {

    @Inject
    private UserRepository userRepository;

    @Inject
    private ValidationUtil<User> validationUtil;

    public void create(User user) throws BusinessException {
        if(log.isDebugEnabled()) {
            log.debug("Creating user {}", user);
        }

        validationUtil.validate(user);

        user.setIdUser(null);
        userRepository.save(user);
    }

    public boolean login(String username, String password) throws BusinessException {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if(user != null) {
            return true;
        }
        return false;
    }

}
