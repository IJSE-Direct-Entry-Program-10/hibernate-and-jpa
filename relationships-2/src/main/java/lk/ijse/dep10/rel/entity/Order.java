package lk.ijse.dep10.rel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name ="`order`")
public class Order {
    @Id
    private String id;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private BigDecimal total;
}
