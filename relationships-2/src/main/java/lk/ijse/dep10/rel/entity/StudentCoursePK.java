package lk.ijse.dep10.rel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class StudentCoursePK implements Serializable {
    @Column(name = "student_id")
    private String studentId;
    @Column(name = "course_id")
    private String courseId;
}
