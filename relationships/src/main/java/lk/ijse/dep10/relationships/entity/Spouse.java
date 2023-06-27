package lk.ijse.dep10.relationships.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "spouse")
public class Spouse {
    @Id
    private int id;
    @Column(nullable = false)
    private String name;
    @OneToOne
    @JoinColumn(nullable = false, name = "employee_id", referencedColumnName = "id", unique = true)
    private Employee employee;
}
