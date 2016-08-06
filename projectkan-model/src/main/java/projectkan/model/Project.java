package projectkan.model;

import lombok.Data;
import projectkan.constants.Constants;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by willlobato on 29/07/16.
 */
@Data
@Entity
@Table(name = Constants.Database.PROJECT, schema = Constants.Database.SCHEMA, catalog = Constants.Database.CATALOG)
public class Project {

    @Id
    @SequenceGenerator(name = Constants.Database.PK_SEQUENCE,
            sequenceName = Constants.Database.PROJECT_ID_SEQ, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Constants.Database.PK_SEQUENCE)
    @Column(name = Constants.Database.PROJECT_ID_PROJECT, nullable = false)
    private Long idProject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = Constants.Database.PROJECT_ID_PROJECT_PARENT)
    private Project idProjectParent;

    @Column(name = Constants.Database.PROJECT_CODE)
    private String code;

    @Column(name = Constants.Database.PROJECT_NAME)
    @NotNull
    private String name;

    @Column(name = Constants.Database.PROJECT_DESCRIPTION)
    private String description;

    @Column(name = Constants.Database.PROJECT_INITIAL_DATE)
    private Date initialDate;

    @Column(name = Constants.Database.PROJECT_FINISH_DATE)
    private Date finishDate;

}
