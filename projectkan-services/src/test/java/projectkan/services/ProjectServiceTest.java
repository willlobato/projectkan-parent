package projectkan.services;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.transaction.annotation.Transactional;
import projectkan.exception.BusinessException;
import projectkan.exception.ConstraintException;
import projectkan.model.Project;

import javax.inject.Inject;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;

/**
 * Created by willlobato on 06/08/16.
 */
@Transactional
public class ProjectServiceTest extends AbstractServiceTest {

    public static final String CODE = "Code";
    public static final String NAME = "Name";
    public static final String DESCRIPTION = "Description";
    public static final String NEW_NAME = "New Name";
    public static final LocalDate INITIAL_DATE = LocalDate.of(2016, 1, 1);
    public static final LocalDate FINISH_DATE = LocalDate.of(2017, 1, 1);

    public Project project;

    @Inject
    private ProjectService service;

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Before
    public void setUp() {
        project = buildNewCreateToTest(1, INITIAL_DATE, FINISH_DATE);
    }

    @Test
    public void shouldCreate() throws Exception {
        service.create(project);

        assertThat(project.getIdProject(), notNullValue());
    }

    @Test
    public void throwConstraintExceptionWithNameIsEmptyWhenCreate() throws Exception {
        project.setName(null);

        thrown.expect(ConstraintException.class);
        thrown.expect(hasProperty(ATTRIBUTE_CONSTRAINTS,
                hasItem(hasProperty(ATTRIBUTE_FIELD, equalTo("name")))));

        service.create(project);
    }

    @Test
    public void shouldUpdateWithFieldName() throws Exception {
        setUpUpdateWithFieldName(NEW_NAME);

        service.update(project);

        assertThat(project.getName(), equalTo(NEW_NAME));
    }

    @Test
    public void shouldListAll() throws Exception {
        int result = setUpManyCreates();

        List<Project> projects = service.listAll();

        assertThat(projects.size(), equalTo(result));
    }

    private int setUpManyCreates() throws BusinessException {
        int i = 1;
        service.create(buildNewCreateToTest(i++, INITIAL_DATE, FINISH_DATE));
        service.create(buildNewCreateToTest(i++, INITIAL_DATE, FINISH_DATE));
        service.create(buildNewCreateToTest(i++, INITIAL_DATE, FINISH_DATE));
        service.create(buildNewCreateToTest(i++, INITIAL_DATE, FINISH_DATE));
        service.create(buildNewCreateToTest(i++, INITIAL_DATE, FINISH_DATE));
        return i;
    }

    private Project buildNewCreateToTest(Integer i, LocalDate initialDate, LocalDate finishDate) {
        Project project = new Project();
        project.setCode(CODE+i);
        project.setName(NAME +i);
        project.setDescription(DESCRIPTION+i);
        project.setInitialDate(Date.valueOf(initialDate));
        project.setFinishDate(Date.valueOf(finishDate));
        return project;
    }

    private void setUpUpdateWithFieldName(String name) throws Exception {
        service.create(project);
        project.setName(name);
    }


}
