package lk.ijse.dep10.nh.entity;

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
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, columnDefinition = "VARCHAR(100)")
    private String name;
    @Column(nullable = false, columnDefinition = "VARCHAR(300) DEFAULT 'Panadura'")
    private String address;
    @Column(name = "contact_number", unique = true)
    private String contactNumber;

    public Customer(String name, String address, String contactNumber) {
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
    }
}
