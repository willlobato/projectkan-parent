package projectkan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import projectkan.constants.Constants;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by willlobato on 27/07/16.
 */
@Data
@Entity
@Table(name = Constants.Database.USER, schema = Constants.Database.SCHEMA, catalog = Constants.Database.CATALOG)
public class User {

    @Id
    @SequenceGenerator(name = Constants.Database.PK_SEQUENCE,
            sequenceName = Constants.Database.USER_ID_SEQ, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Constants.Database.PK_SEQUENCE)
    @Column(name = Constants.Database.USER_ID_USER, nullable = false)
    private Long idUser;

    @Column(name = Constants.Database.USER_USERNAME, unique = true, nullable = false)
    @Size(max = 255)
    @NotNull private String username;

    @Column(name = Constants.Database.USER_PASSWORD, nullable = false)
    @NotNull private String password;

    @Column(name = Constants.Database.USER_EMAIL, unique = true, nullable = false)
    @Size(max = 255)
    @Email @NotNull private String email;

}
