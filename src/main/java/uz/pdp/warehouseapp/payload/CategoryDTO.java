package uz.pdp.warehouseapp.payload;

import lombok.Data;

@Data
public class CategoryDTO {
    private String name;
    private Integer parentId;
}
