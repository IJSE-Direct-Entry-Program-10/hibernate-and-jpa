package lk.ijse.dep10.relationships.entity;

import jakarta.persistence.*;
import lk.ijse.dep10.relationships.entity.util.Gender;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "student")
@ToString(exclude = "courseList")
public class Student {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(name = "contact_number", nullable = false)
    private String contactNumber;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToMany(mappedBy = "studentSet")
    private List<Course> courseList = new ArrayList<>();

    public Student(String id, String name, String contactNumber, Gender gender) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.gender = gender;
    }
}
