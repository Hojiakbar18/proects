package uz.apelsin.apelsinserver.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.apelsin.apelsinserver.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
