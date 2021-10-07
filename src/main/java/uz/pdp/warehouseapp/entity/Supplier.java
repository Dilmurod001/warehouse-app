package uz.pdp.warehouseapp.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.warehouseapp.entity.template.AbsNameEntity;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Supplier extends AbsNameEntity {
    private String phoneNumber;

}
