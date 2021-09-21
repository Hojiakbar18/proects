package uz.apelsin.apelsinserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.apelsin.apelsinserver.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
}
