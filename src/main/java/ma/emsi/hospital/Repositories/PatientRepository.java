package ma.emsi.hospital.Repositories;

import ma.emsi.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {

    Patient findByNom(String nom);
}
