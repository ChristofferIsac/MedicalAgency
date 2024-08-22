package Com.MedicalAgency.Entity;
import javax.persistence.*;

@Entity
@Table(name = "médico")
public class Doctor {

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    private String skill;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getName() {
        return name;
    }

    public String getSkill() {
        return skill;
    }

    public Long getId() {
        return id;
    }
}
