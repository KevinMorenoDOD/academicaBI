package comacademiabi.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "professors")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private int id;

    @Column(name = "full_name", nullable = false, length = 50)
    private String full_name;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "department", length = 50)
    private String department;

    @Column(name = "available", nullable = false)
    private boolean available;

    @PrePersist
    public void prePersist() {
        this.available = true;
    }
}
