package projectkan.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by willlobato on 07/08/16.
 */
@Data
public class NavigationItemDTO {

    private String name;

    private String path;

    private List<NavigationItemDTO> items;

    public NavigationItemDTO(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public NavigationItemDTO(String name, List<NavigationItemDTO> items) {
        this.name = name;
        this.items = items;
    }

    public NavigationItemDTO(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public void addItem(NavigationItemDTO item) {
        items.add(item);
    }

}
