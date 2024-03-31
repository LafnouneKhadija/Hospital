package ma.emsi.hospital.Service;

import jakarta.transaction.Transactional;
import ma.emsi.hospital.Repositories.PatientRepository;
import ma.emsi.hospital.entities.Consultation;
import ma.emsi.hospital.entities.Medecin;
import ma.emsi.hospital.entities.Patient;
import ma.emsi.hospital.entities.RendezVous;
import org.springframework.stereotype.Service;


public interface IHospitalService {

    Patient  savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);




}
