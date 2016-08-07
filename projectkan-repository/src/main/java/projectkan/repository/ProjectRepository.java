package projectkan.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import projectkan.model.Project;

import java.io.Serializable;

/**
 * Created by willlobato on 29/07/16.
 */
public interface ProjectRepository extends CrudRepository<Project, Serializable> {

    Page<Project> findAll(Pageable pageable);

}
