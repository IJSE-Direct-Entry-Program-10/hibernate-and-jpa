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
@Table(name = "car")
public class Car {
    @Id
    @Column(name = "registration_number")
    private String registrationNumber;
    @Column(nullable = false)
    private String model;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinTable(name = "car_manager",
    joinColumns = @JoinColumn(name = "car_reg_no", referencedColumnName = "registration_number"),
    inverseJoinColumns = @JoinColumn(name = "manager_id", referencedColumnName = "id", nullable = false))
    private Manager manager;

    public Car(String registrationNumber, String model) {
        this.registrationNumber = registrationNumber;
        this.model = model;
    }
}
