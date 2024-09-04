package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CmmReunionEnteteQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long reuId;


    /**
     * date de creation
     */
    private LocalDateTime reuDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime reuDateModif;


    /**
     * id user createur
     */
    private Long reuIdCreateur;


    /**
     * nom du createur
     */
    private String reuNomCreateur;


    /**
     * id user de modification
     */
    private Long reuIdModif;


    /**
     * nom user de modification
     */
    private String reuNomModif;


    /**
     * date reunion
     */
    private LocalDateTime reuDate;


    /**
     * type reunion
     */
    private Integer reuType;


    /**
     * heure debut
     */
    private String reuHeureDeb;


    /**
     * minute debut
     */
    private String reuMinuteDeb;


    /**
     * heure fin
     */
    private String reuHeureFin;


    /**
     * minute fin
     */
    private String reuMinuteFin;


    /**
     * numero reunion
     */
    private String reuNum;


    /**
     * nom du president de seance
     */
    private String reuNomPresident;


    /**
     * id du president
     */
    private Long reuIdPresident;


    /**
     * nom du secretaire de seance
     */
    private String reuNomSecretaire;


    /**
     * id du secretaire
     */
    private Long reuIdSecretaire;


    /**
     * objet
     */
    private String reuObject;


    /**
     * observation
     */
    private String reuIntroduction;


    /**
     * contenu
     */
    private String reuContenu;


    /**
     * conclusion
     */
    private String reuConclusion;


    /**
     * lieu de reunion
     */
    private String reuLieu;


    /**
     * code activite
     */
    private String reuActivite;


    /**
     * code service
     */
    private String reuService;


    /**
     * info 1
     */
    private String reuInfo1;


    /**
     * info 2
     */
    private String reuInfo2;


    /**
     * info 3
     */
    private String reuInfo3;


    /**
     * info 4
     */
    private String reuInfo4;


    /**
     * info 5
     */
    private String reuInfo5;


    /**
     * info 6
     */
    private String reuInfo6;


    /**
     * info 7
     */
    private String reuInfo7;


    /**
     * info 8
     */
    private String reuInfo8;


    /**
     * info 9
     */
    private String reuInfo9;


    /**
     * info 10
     */
    private String reuInfo10;


    /**
     * date impression
     */
    private LocalDate reuDateImp;


    /**
     * nom jasper du modele
     */
    private String reuModeleImp;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer reuEtatVal;


    /**
     * 0=preparation 1=en cours 2=valider
     */
    private Integer reuEtat;


    /**
     * date de validation
     */
    private LocalDate reuDateValide;


    /**
     * date debut analyse
     */
    private LocalDate reuDateDebut;


    /**
     * date fin analyse
     */
    private LocalDate reuDateFin;


    /**
     * 5=reunion interne 120=reunion tiers 121=reunion commerciale
     */
    private Integer reuNature;


    /**
     * civilite president
     */
    private String reuCivilPresident;


    /**
     * civilite secretaire
     */
    private String reuCivilSecretaire;


    /**
     * nom du tiers
     */
    private String reuNomTiers;


    /**
     * id du tiers
     */
    private Long reuIdTiers;


    /**
     * civilite du tiers
     */
    private String reuCivilTiers;


    /**
     * id du contact tiers
     */
    private Long reuIdContact;


    /**
     * nom du contact tiers
     */
    private String reuNomContact;


    /**
     * civilite du contact tiers
     */
    private String reuCivilContact;


    /**
     * id du front office
     */
    private Long reuIdFrontOffice;


    /**
     * nom du front office
     */
    private String reuNomFrontOffice;


    /**
     * civilite du front office
     */
    private String reuCivilFrontOffice;


    /**
     * id du back office
     */
    private Long reuIdBackOffice;


    /**
     * nom du back office
     */
    private String reuNomBackOffice;


    /**
     * civilite du back office
     */
    private String reuCivilBackOffice;


    /**
     * 0=sur place 1=exterieur 2=telephone 3=video conference 4=skype 5=internet
     */
    private Integer reuMethode;


    /**
     * date envoie de la convocation
     */
    private LocalDate reuDateEnvoie;


    /**
     * date impression du compte rendu
     */
    private LocalDate reuDateCrImp;


    /**
     * nom jasper du modele du compte rendu
     */
    private String reuModeleCrImp;

}
