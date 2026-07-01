package comacademiabi.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "grades")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enrollment_id", nullable = false)
    private Enrollment enrollment;

    @Column(name = "partial_number", nullable = false)
    private int partial_number;

    @Column(name = "score")
    private BigDecimal score;

    @Column(name = "recorded_at")
    private LocalDateTime recorded_at;

    @PrePersist
    public void prePersist() {
        this.recorded_at = LocalDateTime.now();
    }
}
