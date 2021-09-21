package uz.apelsin.apelsinserver.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.apelsin.apelsinserver.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
