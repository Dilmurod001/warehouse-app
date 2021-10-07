package uz.pdp.warehouseapp.entity;

import lombok.EqualsAndHashCode;
import uz.pdp.warehouseapp.entity.template.AbsNameEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
public class Warehouse extends AbsNameEntity {



}
