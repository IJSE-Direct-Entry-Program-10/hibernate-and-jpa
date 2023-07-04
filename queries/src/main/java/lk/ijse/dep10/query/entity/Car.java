package lk.ijse.dep10.query.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car")
@NamedQuery(name = "query1", query="FROM Car c WHERE c.model = :abc")
public class Car {
    @Id
    @Column(name = "reg_number")
    private String regNumber;
    @Column(nullable = false)
    private String model;
}
