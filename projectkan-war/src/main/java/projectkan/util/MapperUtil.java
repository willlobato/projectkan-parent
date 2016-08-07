package projectkan.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import projectkan.model.Project;
import projectkan.model.ProjectDTO;

import javax.inject.Inject;

/**
 * Created by willlobato on 06/08/16.
 */
@Component
public class MapperUtil {

    @Inject
    private ModelMapper modelMapper;

    public final ProjectDTO convertToDto(Project project) {
        ProjectDTO dto = modelMapper.map(project, ProjectDTO.class);
        return dto;
    }

    public Project convertToEntity(ProjectDTO projectDTO) {
        Project project = modelMapper.map(projectDTO, Project.class);
        return project;
    }

}
