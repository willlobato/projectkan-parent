package projectkan.model;

import lombok.Data;
import projectkan.constants.Constants;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by willlobato on 27/07/16.
 */
@Data
@Entity
@Table(name = Constants.Database.ROLE, schema = Constants.Database.SCHEMA, catalog = Constants.Database.CATALOG)
public class Role {

    @Id
    @SequenceGenerator(name = Constants.Database.PK_SEQUENCE,
            sequenceName = Constants.Database.ROLE_ID_SEQ, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Constants.Database.PK_SEQUENCE)
    @Column(name = Constants.Database.ROLE_ID_ROLE, nullable = false)
    private Long idRole;

    @Basic
    @Column(name = Constants.Database.ROLE_DESCRIPTION)
    private String description;

}
