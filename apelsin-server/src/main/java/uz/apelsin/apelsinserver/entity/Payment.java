package uz.apelsin.apelsinserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.apelsin.apelsinserver.entity.template.AbsTemplate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment extends AbsTemplate {

   private Date time;

   private double amount;

   @ManyToOne(fetch = FetchType.LAZY)
    private Invoice invoice;
}
