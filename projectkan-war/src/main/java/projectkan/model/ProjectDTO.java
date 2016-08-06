package projectkan.model;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.Date;
import java.util.List;

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

    public static List<ProjectDTO> converter(List<Project> projectList) {
        return Lists.transform(projectList, new Function<Project, ProjectDTO>() {
            public ProjectDTO apply(Project project) {
                return converter(project);
            }
        });
    }

    public static ProjectDTO converter(Project project) {
        ProjectDTO projectVO = new ProjectDTO();
        projectVO.setIdProject(project.getIdProject());
        projectVO.setIdProjectParent(project.getIdProjectParent() != null ? converter(project.getIdProjectParent()) : null);
        projectVO.setCode(project.getCode());
        projectVO.setName(project.getName());
        projectVO.setDescription(project.getDescription());
        projectVO.setInitialDate(project.getInitialDate());
        projectVO.setFinishDate(project.getFinishDate());
        return projectVO;
    }
}
