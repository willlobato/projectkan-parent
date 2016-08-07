package projectkan.component;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import projectkan.model.NavigationDTO;
import projectkan.model.NavigationItemDTO;

import java.util.Locale;

/**
 * Created by willlobato on 07/08/16.
 */
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class NavigationComponent {

    public static final String LABEL_PROJECT = "label.project";
    public static final String LABEL_NAVIGATION_MAIN = "label.navigation.main";
    public static final String LABEL_NAVIGATION_REGISTER = "label.navigation.register";
    public static final String LABEL_NAVIGATION_REGISTER_PROJECT = "label.navigation.register.project";

    @Autowired
    private MessageSource messageSource;

    @Getter
    @Setter
    private Locale locale;

    @Getter
    @Setter
    private NavigationDTO navigation;

    @Value("${path.project.view}")
    private String pathProjectView;

    public NavigationDTO build(Locale locale) {
        this.locale = locale;

        navigation = new NavigationDTO(getMessage(LABEL_NAVIGATION_MAIN));

        NavigationItemDTO navigationItem = new NavigationItemDTO(getMessage(LABEL_NAVIGATION_REGISTER));
        navigationItem.addItem(new NavigationItemDTO(getMessage(LABEL_NAVIGATION_REGISTER_PROJECT), pathProjectView));
        navigation.add(navigationItem);

        return navigation;
    }

    private String getMessage(String label) {
        return  messageSource.getMessage(label, null, locale);
    }

}
