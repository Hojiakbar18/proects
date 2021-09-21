package uz.apelsin.apelsinserver.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.apelsin.apelsinserver.entity.template.AbsTemplate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends AbsTemplate {

    private String name;

    private String description;

    private double price;

    private String photo;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;


}
