package lk.ijse.dep10.rel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_course")
public class StudentCourse {
    @EmbeddedId
    private StudentCoursePK studentCoursePK;
    @Column(name = "registered_date", nullable = false)
    private Date registeredDate;
    @Column(nullable = false)
    private String reason;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Course course;

    public StudentCourse(StudentCoursePK studentCoursePK, Date registeredDate, String reason) {
        this.studentCoursePK = studentCoursePK;
        this.registeredDate = registeredDate;
        this.reason = reason;
    }

    public StudentCourse(String studentId, String courseId, Date registeredDate, String reason) {
        this.studentCoursePK = new StudentCoursePK(studentId, courseId);
        this.registeredDate = registeredDate;
        this.reason = reason;
    }
}
