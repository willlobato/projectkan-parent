package projectkan.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projectkan.component.NavigationComponent;
import projectkan.model.NavigationDTO;

import javax.inject.Inject;
import java.util.Locale;

/**
 * Created by willlobato on 07/08/16.
 */
@RestController
@RequestMapping("${path.navigation}")
public class NavigationController {

    @Inject
    private NavigationComponent component;

    @GetMapping
    public ResponseEntity<NavigationDTO> buildNavigationBar(Locale locale) {
        return new ResponseEntity<>(component.build(locale), HttpStatus.OK);
    }

}
