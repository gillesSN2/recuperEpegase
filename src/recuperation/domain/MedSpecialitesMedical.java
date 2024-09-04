package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "med_specialites_medical")
public class MedSpecialitesMedical implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "spemed_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long spemedId;

    /**
     * date de creation
     */
    @Column(name = "spemed_date_creat")
    private LocalDateTime spemedDateCreat;

    /**
     * date de modification
     */
    @Column(name = "spemed_date_modif")
    private LocalDateTime spemedDateModif;

    /**
     * user de creation
     */
    @Column(name = "spemed_user_creat")
    private Long spemedUserCreat = 0L;

    /**
     * user de modification
     */
    @Column(name = "spemed_user_modif")
    private Long spemedUserModif = 0L;

    /**
     * 1=laide aux diagnostic (laboratoire) 1=radiologie 2=service hsopitalier 3=administratif 4=technique
     */
    @Column(name = "spemed_type")
    private Integer spemedType = 0;

    /**
     * code service
     */
    @Column(name = "spemed_code")
    private String spemedCode;

    /**
     * nom service
     */
    @Column(name = "spemed_nom")
    private String spemedNom;

    /**
     * adresse
     */
    @Column(name = "spemed_adresse")
    private String spemedAdresse;

    /**
     * boite postale
     */
    @Column(name = "spemed_bp")
    private String spemedBp;

    /**
     * telephone 1
     */
    @Column(name = "spemed_tel1")
    private String spemedTel1;

    /**
     * telephone 2
     */
    @Column(name = "spemed_tel2")
    private String spemedTel2;

    /**
     * fax
     */
    @Column(name = "spemed_fax")
    private String spemedFax;

    /**
     * mail
     */
    @Column(name = "spemed_mail")
    private String spemedMail;

    /**
     * nom du responsabe
     */
    @Column(name = "spemed_nom_resp")
    private String spemedNomResp;

    /**
     * nom assistant
     */
    @Column(name = "spemed_nom_assistant")
    private String spemedNomAssistant;

    /**
     * nom pavillon
     */
    @Column(name = "spemed_pavillion")
    private String spemedPavillion;

    /**
     * docteur 1
     */
    @Column(name = "spemed_Docteur1")
    private String spemedDocteur1;

    /**
     * docteur 2
     */
    @Column(name = "spemed_Docteur2")
    private String spemedDocteur2;

    /**
     * docteur 3
     */
    @Column(name = "spemed_Docteur3")
    private String spemedDocteur3;

    /**
     * docteur 4
     */
    @Column(name = "spemed_Docteur4")
    private String spemedDocteur4;

    /**
     * docteur 5
     */
    @Column(name = "spemed_Docteur5")
    private String spemedDocteur5;

    /**
     * docteur 6
     */
    @Column(name = "spemed_Docteur6")
    private String spemedDocteur6;

    /**
     * docteur 7
     */
    @Column(name = "spemed_Docteur7")
    private String spemedDocteur7;

    /**
     * docteur 8
     */
    @Column(name = "spemed_Docteur8")
    private String spemedDocteur8;

    /**
     * docteur 9
     */
    @Column(name = "spemed_Docteur9")
    private String spemedDocteur9;

    /**
     * docteur 10
     */
    @Column(name = "spemed_Docteur10")
    private String spemedDocteur10;

    @Column(name = "spemed_serviceId")
    private Long spemedServiceid;

}
