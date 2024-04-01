package ma.emsi.hospital.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private Patient patient;
    @ManyToOne
    private Medecin medecin;
    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;


}
