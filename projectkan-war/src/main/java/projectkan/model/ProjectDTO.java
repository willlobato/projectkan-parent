package projectkan.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by willlobato on 03/08/16.
 */
@Data
public class ProjectDTO {

    private Long idProject;

    private ProjectDTO idProjectParent;

    private String code;

    private String name;

    private String description;

    private Date initialDate;

    private Date finishDate;

}