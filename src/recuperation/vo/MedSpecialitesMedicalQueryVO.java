package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class MedSpecialitesMedicalQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long spemedId;


    /**
     * date de creation
     */
    private LocalDateTime spemedDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime spemedDateModif;


    /**
     * user de creation
     */
    private Long spemedUserCreat;


    /**
     * user de modification
     */
    private Long spemedUserModif;


    /**
     * 1=laide aux diagnostic (laboratoire) 1=radiologie 2=service hsopitalier 3=administratif 4=technique
     */
    private Integer spemedType;


    /**
     * code service
     */
    private String spemedCode;


    /**
     * nom service
     */
    private String spemedNom;


    /**
     * adresse
     */
    private String spemedAdresse;


    /**
     * boite postale
     */
    private String spemedBp;


    /**
     * telephone 1
     */
    private String spemedTel1;


    /**
     * telephone 2
     */
    private String spemedTel2;


    /**
     * fax
     */
    private String spemedFax;


    /**
     * mail
     */
    private String spemedMail;


    /**
     * nom du responsabe
     */
    private String spemedNomResp;


    /**
     * nom assistant
     */
    private String spemedNomAssistant;


    /**
     * nom pavillon
     */
    private String spemedPavillion;


    /**
     * docteur 1
     */
    private String spemedDocteur1;


    /**
     * docteur 2
     */
    private String spemedDocteur2;


    /**
     * docteur 3
     */
    private String spemedDocteur3;


    /**
     * docteur 4
     */
    private String spemedDocteur4;


    /**
     * docteur 5
     */
    private String spemedDocteur5;


    /**
     * docteur 6
     */
    private String spemedDocteur6;


    /**
     * docteur 7
     */
    private String spemedDocteur7;


    /**
     * docteur 8
     */
    private String spemedDocteur8;


    /**
     * docteur 9
     */
    private String spemedDocteur9;


    /**
     * docteur 10
     */
    private String spemedDocteur10;

    private Long spemedServiceid;

}
