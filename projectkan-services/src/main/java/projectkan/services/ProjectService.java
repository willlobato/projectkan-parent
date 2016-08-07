package projectkan.services;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projectkan.exception.BusinessException;
import projectkan.exception.ObjectNotFoundException;
import projectkan.model.Project;
import projectkan.repository.ProjectRepository;
import projectkan.util.ValidationUtil;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by willlobato on 03/08/16.
 */
@Slf4j
@Service
@Transactional
public class ProjectService {

    @Inject
    private ProjectRepository repository;

    @Inject
    private ValidationUtil<Project> validationUtil;

    public List<Project> listAll() throws BusinessException {
        ArrayList<Project> projects = Lists.newArrayList(repository.findAll());
        if(projects.isEmpty()) {
            throw new ObjectNotFoundException();
        }
        return projects;
    }

    public Page<Project> findAll(Pageable pageable) throws BusinessException {
        Page<Project> projects = repository.findAll(pageable);
        return projects;
    }

    public Project get(Long id) throws BusinessException {
        Project project = repository.findOne(id);
        if(project == null) {
            throw new ObjectNotFoundException();
        }
        return project;
    }

    public void delete(Long id) throws BusinessException {
        Project project = repository.findOne(id);
        if(project == null) {
            throw new ObjectNotFoundException();
        }
        repository.delete(id);
    }

    public void create(Project project) throws BusinessException {
        validationUtil.validate(project);

        project.setIdProject(null);
        repository.save(project);
    }


    public void update(Project project) throws BusinessException {
        validationUtil.validate(project);

        repository.save(project);
    }

}
