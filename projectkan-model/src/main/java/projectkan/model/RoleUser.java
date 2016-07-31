package projectkan.model;

import lombok.Data;
import projectkan.constants.Constants;

import javax.persistence.*;

/**
 * Created by willlobato on 27/07/16.
 *
 */
@Data
@Entity
@Table(name = Constants.Database.ROLE_USER, schema = Constants.Database.SCHEMA, catalog = Constants.Database.CATALOG)
@IdClass(RoleUserPK.class)
public class RoleUser {

    @Id
    @Column(name = Constants.Database.ROLE_USER_ID_ROLE, nullable = false)
    private Long idRole;

    @Id
    @Column(name = Constants.Database.ROLE_USER_ID_USER, nullable = false)
    private Long idUser;

}
