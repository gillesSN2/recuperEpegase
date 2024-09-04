package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_reunion_entete")
public class CmmReunionEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "reu_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reuId;

    /**
     * date de creation
     */
    @Column(name = "reu_date_creat")
    private LocalDateTime reuDateCreat;

    /**
     * date de modification
     */
    @Column(name = "reu_date_modif")
    private LocalDateTime reuDateModif;

    /**
     * id user createur
     */
    @Column(name = "reu_id_createur")
    private Long reuIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "reu_nom_createur")
    private String reuNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "reu_id_modif")
    private Long reuIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "reu_nom_modif")
    private String reuNomModif;

    /**
     * date reunion
     */
    @Column(name = "reu_date")
    private LocalDateTime reuDate;

    /**
     * type reunion
     */
    @Column(name = "reu_type")
    private Integer reuType = 0;

    /**
     * heure debut
     */
    @Column(name = "reu_heure_deb")
    private String reuHeureDeb;

    /**
     * minute debut
     */
    @Column(name = "reu_minute_deb")
    private String reuMinuteDeb;

    /**
     * heure fin
     */
    @Column(name = "reu_heure_fin")
    private String reuHeureFin;

    /**
     * minute fin
     */
    @Column(name = "reu_minute_fin")
    private String reuMinuteFin;

    /**
     * numero reunion
     */
    @Column(name = "reu_num")
    private String reuNum;

    /**
     * nom du president de seance
     */
    @Column(name = "reu_nom_president")
    private String reuNomPresident;

    /**
     * id du president
     */
    @Column(name = "reu_id_president")
    private Long reuIdPresident = 0L;

    /**
     * nom du secretaire de seance
     */
    @Column(name = "reu_nom_secretaire")
    private String reuNomSecretaire;

    /**
     * id du secretaire
     */
    @Column(name = "reu_id_secretaire")
    private Long reuIdSecretaire = 0L;

    /**
     * objet
     */
    @Column(name = "reu_object")
    private String reuObject;

    /**
     * observation
     */
    @Column(name = "reu_introduction")
    private String reuIntroduction;

    /**
     * contenu
     */
    @Column(name = "reu_contenu")
    private String reuContenu;

    /**
     * conclusion
     */
    @Column(name = "reu_conclusion")
    private String reuConclusion;

    /**
     * lieu de reunion
     */
    @Column(name = "reu_lieu")
    private String reuLieu;

    /**
     * code activite
     */
    @Column(name = "reu_activite")
    private String reuActivite;

    /**
     * code service
     */
    @Column(name = "reu_service")
    private String reuService;

    /**
     * info 1
     */
    @Column(name = "reu_info1")
    private String reuInfo1;

    /**
     * info 2
     */
    @Column(name = "reu_info2")
    private String reuInfo2;

    /**
     * info 3
     */
    @Column(name = "reu_info3")
    private String reuInfo3;

    /**
     * info 4
     */
    @Column(name = "reu_info4")
    private String reuInfo4;

    /**
     * info 5
     */
    @Column(name = "reu_info5")
    private String reuInfo5;

    /**
     * info 6
     */
    @Column(name = "reu_info6")
    private String reuInfo6;

    /**
     * info 7
     */
    @Column(name = "reu_info7")
    private String reuInfo7;

    /**
     * info 8
     */
    @Column(name = "reu_info8")
    private String reuInfo8;

    /**
     * info 9
     */
    @Column(name = "reu_info9")
    private String reuInfo9;

    /**
     * info 10
     */
    @Column(name = "reu_info10")
    private String reuInfo10;

    /**
     * date impression
     */
    @Column(name = "reu_date_imp")
    private LocalDate reuDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "reu_modele_imp")
    private String reuModeleImp;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "reu_etat_val")
    private Integer reuEtatVal = 0;

    /**
     * 0=preparation 1=en cours 2=valider
     */
    @Column(name = "reu_etat")
    private Integer reuEtat = 0;

    /**
     * date de validation
     */
    @Column(name = "reu_date_valide")
    private LocalDate reuDateValide;

    /**
     * date debut analyse
     */
    @Column(name = "reu_date_debut")
    private LocalDate reuDateDebut;

    /**
     * date fin analyse
     */
    @Column(name = "reu_date_fin")
    private LocalDate reuDateFin;

    /**
     * 5=reunion interne 120=reunion tiers 121=reunion commerciale
     */
    @Column(name = "reu_nature")
    private Integer reuNature = 0;

    /**
     * civilite president
     */
    @Column(name = "reu_civil_president")
    private String reuCivilPresident;

    /**
     * civilite secretaire
     */
    @Column(name = "reu_civil_secretaire")
    private String reuCivilSecretaire;

    /**
     * nom du tiers
     */
    @Column(name = "reu_nom_tiers")
    private String reuNomTiers;

    /**
     * id du tiers
     */
    @Column(name = "reu_id_tiers")
    private Long reuIdTiers = 0L;

    /**
     * civilite du tiers
     */
    @Column(name = "reu_civil_tiers")
    private String reuCivilTiers;

    /**
     * id du contact tiers
     */
    @Column(name = "reu_id_contact")
    private Long reuIdContact = 0L;

    /**
     * nom du contact tiers
     */
    @Column(name = "reu_nom_contact")
    private String reuNomContact;

    /**
     * civilite du contact tiers
     */
    @Column(name = "reu_civil_contact")
    private String reuCivilContact;

    /**
     * id du front office
     */
    @Column(name = "reu_id_front_office")
    private Long reuIdFrontOffice = 0L;

    /**
     * nom du front office
     */
    @Column(name = "reu_nom_front_office")
    private String reuNomFrontOffice;

    /**
     * civilite du front office
     */
    @Column(name = "reu_civil_front_office")
    private String reuCivilFrontOffice;

    /**
     * id du back office
     */
    @Column(name = "reu_id_back_office")
    private Long reuIdBackOffice = 0L;

    /**
     * nom du back office
     */
    @Column(name = "reu_nom_back_office")
    private String reuNomBackOffice;

    /**
     * civilite du back office
     */
    @Column(name = "reu_civil_back_office")
    private String reuCivilBackOffice;

    /**
     * 0=sur place 1=exterieur 2=telephone 3=video conference 4=skype 5=internet
     */
    @Column(name = "reu_methode")
    private Integer reuMethode = 0;

    /**
     * date envoie de la convocation
     */
    @Column(name = "reu_date_envoie")
    private LocalDate reuDateEnvoie;

    /**
     * date impression du compte rendu
     */
    @Column(name = "reu_date_cr_imp")
    private LocalDate reuDateCrImp;

    /**
     * nom jasper du modele du compte rendu
     */
    @Column(name = "reu_modele_cr_imp")
    private String reuModeleCrImp;

}
