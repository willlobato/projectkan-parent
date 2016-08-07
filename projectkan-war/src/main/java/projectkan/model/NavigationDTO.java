package projectkan.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by willlobato on 07/08/16.
 */
@Data
public class NavigationDTO {

    private String name;

    private List<NavigationItemDTO> items = new ArrayList<>();

    public NavigationDTO(String name) {
        this.name = name;
    }

    public void add(NavigationItemDTO dto) {
        items.add(dto);
    }

//    private NavigationDTO createNavigationItem(String name, String pathProjectView) {
//        NavigationItemDTO project = new NavigationItemDTO(name, pathProjectView);
//
//        navigation.add(project);
//    }


}
