package lk.ijse.dep10.rel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(name = "contact_number", nullable = false, unique = true)
    private String contactNumber;
}
