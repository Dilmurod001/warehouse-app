package uz.pdp.warehouseapp.entity;

import lombok.EqualsAndHashCode;
import uz.pdp.warehouseapp.entity.template.AbsNameEntity;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
public class Measurement extends AbsNameEntity {
}
