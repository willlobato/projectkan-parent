package projectkan.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by willlobato on 07/08/16.
 */
@Data
public class NavigationDTO {

    private List<NavigationItemDTO> items = new ArrayList<>();

    public NavigationDTO() {

    }

    public void add(NavigationItemDTO dto) {
        items.add(dto);
    }

}
