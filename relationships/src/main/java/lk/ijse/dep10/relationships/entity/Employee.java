package lk.ijse.dep10.relationships.entity;

import jakarta.persistence.*;
import lombok.*;

@ToString(exclude = "spouse")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
//    @Setter(AccessLevel.NONE)
    @OneToOne(mappedBy = "employee")
    private Spouse spouse;

    public Employee(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void setSpouse(Spouse spouse) {
        spouse.setEmployee(this);
        this.spouse = spouse;
    }
}
