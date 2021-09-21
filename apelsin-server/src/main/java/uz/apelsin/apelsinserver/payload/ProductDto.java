package uz.apelsin.apelsinserver.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.apelsin.apelsinserver.entity.Category;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Integer id;

    private String name;

    private String description;

    private double price;

    private String photo;

    private Integer categoryId;
    private Category category;

}
