package projectkan.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by willlobato on 27/07/16.
 */
@Data
public class RoleUserPK implements Serializable {

    private Long idRole;
    private Long idUser;

}
