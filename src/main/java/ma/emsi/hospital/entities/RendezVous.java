package ma.emsi.hospital.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Data  @NoArgsConstructor @AllArgsConstructor
public class RendezVous {
@Id //@GeneratedValue(strategy = GenerationType.IDENTITY)
private String id = UUID.randomUUID().toString();
    private Date date;
    // pour afficher en string
    @Enumerated(EnumType.STRING)
    private StatusRDV status;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medecin medecin;
    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;


}
