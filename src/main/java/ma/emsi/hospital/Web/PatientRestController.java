package ma.emsi.hospital.Web;

import ma.emsi.hospital.Repositories.PatientRepository;
import ma.emsi.hospital.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
  //Injection de dependances
    @Autowired
    private PatientRepository patientRepository;

    // pour consulter la liste des patient
    //pour acceder
    @GetMapping("/patients")
    public List<Patient> patientList(){
        return patientRepository.findAll();
    }


}
