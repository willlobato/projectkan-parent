package projectkan.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import projectkan.model.NavigationDTO;
import projectkan.model.NavigationItemDTO;

import java.util.List;
import java.util.Locale;

/**
 * Created by willlobato on 07/08/16.
 */
@Component
public class NavigationComponent {

    public static final String LABEL_PROJECT = "label.project";

    @Autowired
    private MessageSource messageSource;

    @Value("${path.project.view}")
    private String pathProjectView;

    private NavigationDTO navigation = new NavigationDTO();

    public NavigationDTO build(Locale locale) {

        createNavigationItem(LABEL_PROJECT, pathProjectView, locale);

        return navigation;
    }

    private void createNavigationItem(String label, List<NavigationItemDTO> items, Locale locale) {
        String name = messageSource.getMessage(label, null, locale);
        NavigationItemDTO project = new NavigationItemDTO(name, items);

        navigation.add(project);
    }

    private void createNavigationItem(String label, String pathProjectView, Locale locale) {
        String name = messageSource.getMessage(label, null, locale);
        NavigationItemDTO project = new NavigationItemDTO(name, pathProjectView);

        navigation.add(project);
    }

}
