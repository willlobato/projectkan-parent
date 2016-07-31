package projectkan.repository;

import org.springframework.data.repository.CrudRepository;
import projectkan.model.RoleUser;
import projectkan.model.RoleUserPK;

/**
 * Created by willlobato on 27/07/16.
 */
public interface RoleUserRepository extends CrudRepository<RoleUser, RoleUserPK> {

}
