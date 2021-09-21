package uz.apelsin.apelsinserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.apelsin.apelsinserver.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {

}
