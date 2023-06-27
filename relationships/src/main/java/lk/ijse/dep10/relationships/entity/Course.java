package lk.ijse.dep10.relationships.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "course")
public class Course {
    @Id
    private String id;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private int duration;

    @ManyToMany
    @JoinTable(name = "course_student",
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    private Set<Student> studentSet = new HashSet<>();

    public Course(String id, String description, int duration) {
        this.id = id;
        this.description = description;
        this.duration = duration;
    }
}
