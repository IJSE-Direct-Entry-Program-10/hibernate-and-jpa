package lk.ijse.dep10.query.util.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_car")
public class EmployeeCar {
    @Id
    @OneToOne
    @JoinColumn(name = "reg_no", referencedColumnName = "reg_number")
    private Car car;
    @OneToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "id", nullable = false, unique = true)
    private Employee employee;
    @Column(name = "handed_date", nullable = false)
    private Date handedDate;
}
