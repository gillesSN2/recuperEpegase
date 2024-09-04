package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "med_patient_contact")
public class MedPatientContact implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "patcon_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patconId;

    /**
     * civilite
     */
    @Column(name = "patcon_civilite")
    private String patconCivilite;

    /**
     * qualite du contact
     */
    @Column(name = "patcon_qualite")
    private String patconQualite;

    /**
     * nom du contact
     */
    @Column(name = "patcon_nom")
    private String patconNom;

    /**
     * prenom du contact
     */
    @Column(name = "patcon_prenom")
    private String patconPrenom;

    /**
     * adresse du contact
     */
    @Column(name = "patcon_adresse")
    private String patconAdresse;

    /**
     * telephone du bureau du contact
     */
    @Column(name = "patcon_tel_bur")
    private String patconTelBur;

    /**
     * telephone du domicile du contact
     */
    @Column(name = "patcon_tel_dom")
    private String patconTelDom;

    /**
     * cellulaire du contact
     */
    @Column(name = "patcon_cel")
    private String patconCel;

    /**
     * mail du contact
     */
    @Column(name = "patcon_mail")
    private String patconMail;

    /**
     * observations
     */
    @Column(name = "patcon_obs")
    private String patconObs;

    @Column(name = "pat_id", nullable = false)
    private Long patId;

}
