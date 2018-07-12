import javax.persistence.Id;
import javax.persistence.Column;

class JpaAnnotationsField {
    @Id private Long id; // Noncompliant

    @Column private String value; // Noncompliant

    @Id public Long getId() {
        return id;
    }
}