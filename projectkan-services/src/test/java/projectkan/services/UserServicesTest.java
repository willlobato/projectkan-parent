package projectkan.services;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import projectkan.model.User;

import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;

/**
 * Created by willlobato on 28/07/16.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:application-context-projectkan-services.xml")
public class UserServicesTest {

    public static final String USERNAME = "willlobato";
    public static final String PASSWORD = "123456";
    public static final String EMAIL = "will.lobato@gmail.com";

    public static final String EMAIL_INVALID = "willXlobatoXgmailXcom";

    public static final String ATTRIBUTE_FIELD = "field";
    public static final String ATTRIBUTE_CONSTRAINTS = "constraints";

    private User user;

    @Inject
    private UserService userService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    @Transactional
    public void shouldCreateNewUser() throws Exception {
        this.user = new User();
        this.user.setUsername(USERNAME);
        this.user.setPassword(PASSWORD);
        this.user.setEmail(EMAIL);

        userService.create(user);

        assertThat(user.getIdUser(), notNullValue());
    }

    @Test
    public void throwsConstraintExceptionWhenCreateWithInvalidEmail() throws Exception {

        thrown.expect(hasProperty(ATTRIBUTE_CONSTRAINTS,
                hasItem(hasProperty(ATTRIBUTE_FIELD, equalTo("email")))));

        this.user = new User();
        this.user.setUsername(USERNAME);
        this.user.setPassword(PASSWORD);
        this.user.setEmail(EMAIL_INVALID);

        userService.create(user);

    }

    @Test
    public void throwsConstraintExceptionWhenCreateWithPasswordNull() throws Exception {

        thrown.expect(hasProperty(ATTRIBUTE_CONSTRAINTS,
                hasItem(hasProperty(ATTRIBUTE_FIELD, equalTo("password")))));

        this.user = new User();
        this.user.setUsername(USERNAME);
        this.user.setPassword(null);
        this.user.setEmail(EMAIL);

        userService.create(user);
    }

    @Test
    public void throwsConstraintExceptionWhenCreateWithUsernameNull() throws Exception {

        thrown.expect(hasProperty(ATTRIBUTE_CONSTRAINTS,
                hasItem(hasProperty(ATTRIBUTE_FIELD, equalTo("username")))));

        this.user = new User();
        this.user.setUsername(null);
        this.user.setPassword(PASSWORD);
        this.user.setEmail(EMAIL);

        userService.create(user);
    }

    @Test
    @Transactional
    public void shouldLogin() throws Exception {

        shouldCreateNewUser();
        boolean logged = userService.login(USERNAME, PASSWORD);

        assertThat(logged, equalTo(Boolean.TRUE));
    }


}