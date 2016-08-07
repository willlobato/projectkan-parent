package projectkan.services;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by willlobato on 06/08/16.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:application-context-projectkan-services.xml")
public abstract class AbstractServiceTest {

    protected static final String ATTRIBUTE_FIELD = "field";
    protected static final String ATTRIBUTE_CONSTRAINTS = "constraints";

}
