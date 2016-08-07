package projectkan.model;

import lombok.Data;

/**
 * Created by willlobato on 07/08/16.
 */
@Data
public class NavigationItemDTO {

    private String name;

    private String path;

    public NavigationItemDTO(String name) {
        this.name = name;
    }

    public NavigationItemDTO(String name, String path) {
        this.name = name;
        this.path = path;
    }


}
