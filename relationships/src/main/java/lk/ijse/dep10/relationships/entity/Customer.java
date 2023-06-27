package lk.ijse.dep10.relationships.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString(exclude = "orderList")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(name = "contact_number", nullable = false, unique = true)
    private String contactNumber;
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private List<Order> orderList = new ArrayList<>();

    public Customer(int id, String name, String contactNumber) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public void addOrder(Order order){
        order.setCustomer(this);
        orderList.add(order);
    }
}
