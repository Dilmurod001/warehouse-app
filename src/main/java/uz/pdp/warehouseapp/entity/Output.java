package uz.pdp.warehouseapp.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.warehouseapp.entity.template.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Output extends AbsEntity {

    private Date date;

    @ManyToOne
    private Warehouse warehouse;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Currency currency;
    private String factureNumber;
    private String code;
}
