package projectkan.model;

import lombok.Data;

import java.util.List;

/**
 * Created by willlobato on 07/08/16.
 */
@Data
public class NavigationItemDTO {

    private String name;

    private String path;

    private List<NavigationItemDTO> item;

    public NavigationItemDTO(String name, List<NavigationItemDTO> item) {
        this.name = name;
        this.item = item;
    }

    public NavigationItemDTO(String name, String path) {
        this.name = name;
        this.path = path;
    }






}
