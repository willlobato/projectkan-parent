package projectkan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projectkan.model.NavigationDTO;
import projectkan.model.NavigationItemDTO;

import java.util.Locale;

/**
 * Created by willlobato on 07/08/16.
 */
@RestController
@RequestMapping("${path.menu}")
public class NavigationController {

    @Autowired
    private MessageSource messageSource;

    @Value("${path.project}")
    private String pathProject;

    @GetMapping
    public ResponseEntity<NavigationDTO> buildNavigationBar(Locale locale) {

        NavigationDTO navigation = new NavigationDTO();

        String name = messageSource.getMessage("label.project", null, locale);
        NavigationItemDTO project = new NavigationItemDTO(name, pathProject);

        navigation.add(project);

        return new ResponseEntity<>(navigation, HttpStatus.OK);
    }

}
