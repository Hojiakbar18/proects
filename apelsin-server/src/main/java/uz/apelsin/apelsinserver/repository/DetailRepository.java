package uz.apelsin.apelsinserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.apelsin.apelsinserver.entity.Detail;

public interface DetailRepository extends JpaRepository<Detail, Integer> {
    Detail getDetailByOrderId(Integer order_id);
}
