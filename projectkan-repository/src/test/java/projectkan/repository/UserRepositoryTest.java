package projectkan.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by willlobato on 27/07/16.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:application-context-projectkan-repository.xml")
public class UserRepositoryTest {

    @Inject
    private UserRepository userRepository;

    @Test
    public void test() {
        userRepository.findAll();
    }


}