package uz.pdp.warehouseapp.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.warehouseapp.entity.template.AbsNameEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Category extends AbsNameEntity {

    @ManyToOne
    private Category parentCategory;

}
