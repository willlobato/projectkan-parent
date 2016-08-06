package projectkan.util;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import projectkan.model.Project;
import projectkan.model.ProjectDTO;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by willlobato on 06/08/16.
 */
@Component
public class MapperUtil {

    @Inject
    private ModelMapper modelMapper;

    public final ProjectDTO convertToDto(Project project) {
        ProjectDTO postDto = modelMapper.map(project, ProjectDTO.class);
        return postDto;
    }

    public Project convertToEntity(ProjectDTO projectDTO) {
        Project post = modelMapper.map(projectDTO, Project.class);
        return post;
    }

}
