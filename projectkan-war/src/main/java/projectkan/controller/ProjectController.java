package projectkan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectkan.exception.BusinessException;
import projectkan.model.Project;
import projectkan.model.ProjectDTO;
import projectkan.services.ProjectService;
import projectkan.util.MapperUtil;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by willlobato on 03/08/16.
 */
@Slf4j
@RestController
@RequestMapping("${path.project}")
public class ProjectController {

    @Inject
    private ProjectService service;

    @Inject
    private MapperUtil mapperUtil;

    /**
     * List all projects
     * @return
     */
    @GetMapping
    public ResponseEntity<List<ProjectDTO>> list() throws BusinessException {
        List<Project> listAll = service.listAll();

        List<ProjectDTO> projectDTOs = listAll.stream().map(
                project -> mapperUtil.convertToDto(project)).collect(Collectors.toList());

        return new ResponseEntity<>(projectDTOs, HttpStatus.OK);
    }

    /**
     * Get one project
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> get(@PathVariable Long id) throws BusinessException {
        Project project = service.get(id);
        ProjectDTO projectDTO = mapperUtil.convertToDto(project);
        return new ResponseEntity<>(projectDTO, HttpStatus.OK);
    }

    /**
     * Delete one project
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws BusinessException {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Create new project
     * @param projectDTO
     * @return
     * @throws BusinessException
     */
    @PostMapping
    public ResponseEntity<ProjectDTO> create(@RequestBody ProjectDTO projectDTO) throws BusinessException {
        Project project = mapperUtil.convertToEntity(projectDTO);
        service.create(project);
        projectDTO = mapperUtil.convertToDto(project);
        return new ResponseEntity<>(projectDTO, HttpStatus.CREATED);
    }

    /**
     * Update project
     * @param projectDTO
     * @return
     * @throws BusinessException
     */
    @PutMapping
    public ResponseEntity<ProjectDTO> update(@RequestBody ProjectDTO projectDTO) throws BusinessException {
        Project project = mapperUtil.convertToEntity(projectDTO);
        service.update(project);
        projectDTO = mapperUtil.convertToDto(project);
        return new ResponseEntity<>(projectDTO, HttpStatus.NO_CONTENT);
    }

}
