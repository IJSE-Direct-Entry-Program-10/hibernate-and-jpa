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
@Table(name = "module")
public class Module {
    @Id
    private String id;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private int duration;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinTable(name = "module_teacher",
            joinColumns = @JoinColumn(name = "module_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id", nullable = false))
    private Teacher teacher;

    public Module(String id, String description, int duration) {
        this.id = id;
        this.description = description;
        this.duration = duration;
    }
}
