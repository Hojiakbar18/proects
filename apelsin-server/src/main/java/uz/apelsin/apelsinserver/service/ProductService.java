package uz.apelsin.apelsinserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.apelsin.apelsinserver.entity.Product;
import uz.apelsin.apelsinserver.payload.ApiResponse;
import uz.apelsin.apelsinserver.payload.ProductDto;
import uz.apelsin.apelsinserver.repository.CategoryRepository;
import uz.apelsin.apelsinserver.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public ApiResponse saveOrEdit(ProductDto dto){
        Product product=new Product();
        try {
            if (dto.getId()!=null){
                product=productRepository.getById(dto.getId());
            }
            if (dto.getCategoryId()!=null){
                product.setCategory(categoryRepository.getById(dto.getCategoryId()));
            }
            product.setDescription(dto.getDescription());
            product.setName(dto.getName());
            product.setPrice(dto.getPrice());
            product.setPhoto(dto.getPhoto());

            productRepository.save(product);

            return new ApiResponse(dto.getId()!=null?"edited":"saved",true);

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ApiResponse("error",false);
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public ProductDto getById(Integer id){
      return  getProductDto(productRepository.getById(id));
    }




    public ProductDto getProductDto(Product product){
        ProductDto dto=new ProductDto();

        dto.setDescription(product.getDescription());
        if (product.getCategory()!=null){
            dto.setCategory(product.getCategory());
        }

        dto.setName(product.getName());
        dto.setPhoto(product.getPhoto());
        dto.setPrice(product.getPrice());
        dto.setId(product.getId());
        return dto;
    }

}
