package lk.ijse.dep10.query.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
@NamedNativeQuery(name = "searchEmployees",
        query = "SELECT * FROM employee WHERE name LIKE :q",
        resultClass = Employee.class)
public class Employee {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
}
