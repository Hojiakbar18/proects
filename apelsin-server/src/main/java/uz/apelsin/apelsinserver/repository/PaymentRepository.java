package uz.apelsin.apelsinserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.apelsin.apelsinserver.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {

}
