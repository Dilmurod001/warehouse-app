package uz.pdp.warehouseapp.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.warehouseapp.entity.template.AbsNameEntity;


import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Client extends AbsNameEntity {
    private String phoneNumber;
}
