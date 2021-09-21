package uz.apelsin.apelsinserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.apelsin.apelsinserver.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {


}
