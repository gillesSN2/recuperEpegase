package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "med_patient_prot")
public class MedPatientProt implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "patprt_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patprtId;

    /**
     * date de debut du protocole
     */
    @Column(name = "patprt_date_debut")
    private LocalDate patprtDateDebut;

    /**
     * date de fin du protocole
     */
    @Column(name = "patptr_date_fin")
    private LocalDate patptrDateFin;

    /**
     * code du protocole
     */
    @Column(name = "patptr_code")
    private String patptrCode;

    /**
     * libelle du protocole
     */
    @Column(name = "patptr_libelle")
    private String patptrLibelle;

    @Column(name = "pat_id", nullable = false)
    private Long patId;

}
