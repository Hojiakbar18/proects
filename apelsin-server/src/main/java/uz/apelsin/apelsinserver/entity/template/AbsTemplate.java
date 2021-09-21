package uz.apelsin.apelsinserver.entity.template;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbsTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
