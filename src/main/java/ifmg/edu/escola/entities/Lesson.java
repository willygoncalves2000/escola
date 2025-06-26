package ifmg.edu.escola.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tb_lesson")
public abstract class Lesson {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer position;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;


    @ManyToMany
    @JoinTable(name = "tb_lessons_done",
                joinColumns = @JoinColumn(name = "lesson_id"),
                inverseJoinColumns = {
                        @JoinColumn(name = "user_id"),
                        @JoinColumn(name = "offer_id"),
                })
    private Set<Enrollment> enrollmentsDone = new HashSet<>();
}
