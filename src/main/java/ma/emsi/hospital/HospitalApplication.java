package ma.emsi.hospital;

import ma.emsi.hospital.Repositories.ConsultationRepository;
import ma.emsi.hospital.Repositories.MedecinRepository;
import ma.emsi.hospital.Repositories.PatientRepository;
import ma.emsi.hospital.Repositories.RendezVousRepository;
import ma.emsi.hospital.Service.IHospitalService;
import ma.emsi.hospital.entities.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication  {

    public static void main(String[] args) {

        SpringApplication.run(HospitalApplication.class, args);
    }
@Bean

// on injecte les interfaces
    CommandLineRunner start(//on injecte la couche metier
                            IHospitalService iHospitalService, PatientRepository patientRepository, MedecinRepository medecinRepository,
                            RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository){
            //MedecinRepository medecinRepository,
                           // RendezVousRepository rendezVousRepository ,
                            //ConsultationRepository consultationRepository,
                            //PatientRepository patientRepository){
        return args -> {
            // on cree un patient
           // patientRepository.save(new Patient(null,"AAA",new Date(),false,null))
           //on fait une boucle

            Stream.of("Bcd","Cab","Dkl")
                    .forEach(name->{
                        Medecin medecin=new Medecin();
                        medecin.setEmail(name+"@gamil.com");
                        medecin.setNom(name);
                        medecin.setSpecialte(Math.random()>0.5?"Cardio":"Dentiste");

                       iHospitalService.saveMedecin(medecin);
                    });

            Stream.of("BBB","CCCC","DDD")
                    .forEach(name->{
                        Patient patient=new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        iHospitalService.savePatient(patient);
                    });
             // je cherche un patient par son nom ou l'id
            Patient patient=patientRepository.findById(1L).orElse(null);
            Patient patient1=patientRepository.findByNom("BBB");

            // chercher un medecin par son nom
            Medecin medecin=medecinRepository.findByNom("Cab");
             //on cree rendezVous
            RendezVous rendezVous=new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            // declarer la variable
            RendezVous saveDRDV = iHospitalService.saveRDV(rendezVous);
            //donner au client le numero de RDV
            System.out.println(saveDRDV.getId());

            //on cree consultation
           // RendezVous rendezVous1=rendezVousRepository.findById(1L).orElse(null);
            RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consultation");
            iHospitalService.saveConsultation(consultation);
        };
    }


    }

