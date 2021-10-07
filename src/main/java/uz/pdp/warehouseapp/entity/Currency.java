package uz.pdp.warehouseapp.entity;

import lombok.EqualsAndHashCode;
import uz.pdp.warehouseapp.entity.template.AbsNameEntity;

import javax.persistence.Entity;

@Entity
@EqualsAndHashCode(callSuper = true)
public class Currency extends AbsNameEntity {

}
