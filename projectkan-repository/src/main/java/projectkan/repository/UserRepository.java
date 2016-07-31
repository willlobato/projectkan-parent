package projectkan.repository;

import org.springframework.data.repository.CrudRepository;
import projectkan.model.User;

import java.io.Serializable;

/**
 * Created by willlobato on 27/07/16.
 */
public interface UserRepository extends CrudRepository<User, Serializable> {

    User findByUsernameAndPassword(String username, String password);

}
