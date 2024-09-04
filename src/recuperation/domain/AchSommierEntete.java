package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ach_sommier_entete")
public class AchSommierEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "som_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long somId;

    /**
     * date de creation
     */
    @Column(name = "som_date_creat")
    private LocalDateTime somDateCreat;

    /**
     * date de modification
     */
    @Column(name = "som_date_modif")
    private LocalDateTime somDateModif;

    /**
     * id user createur
     */
    @Column(name = "som_id_createur")
    private Long somIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "som_nom_createur")
    private String somNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "som_id_modif")
    private Long somIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "som_nom_modif")
    private String somNomModif;

    /**
     * date sommier
     */
    @Column(name = "som_date")
    private LocalDateTime somDate;

    /**
     * date expiration du sommier
     */
    @Column(name = "som_date_expiration")
    private LocalDateTime somDateExpiration;

    /**
     * date prorogation du sommier
     */
    @Column(name = "som_date_prorogation")
    private LocalDateTime somDateProrogation;

    /**
     * numero sommier
     */
    @Column(name = "som_num")
    private String somNum;

    /**
     * type 0=entree, 1=sortie
     */
    @Column(name = "som_type")
    private Integer somType = 0;

    /**
     * nom du commercial
     */
    @Column(name = "som_nom_responsable")
    private String somNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "som_id_responsable")
    private Long somIdResponsable = 0L;

    /**
     * numero dossier transit
     */
    @Column(name = "som_dossier_transit")
    private String somDossierTransit;

    /**
     * numero reception
     */
    @Column(name = "som_reception")
    private String somReception;

    /**
     * numero cession
     */
    @Column(name = "som_cession")
    private String somCession;

    /**
     * date impression
     */
    @Column(name = "som_date_imp")
    private LocalDate somDateImp;

    /**
     * modele impression
     */
    @Column(name = "som_modele_imp")
    private String somModeleImp;

    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    @Column(name = "som_etat")
    private Integer somEtat = 0;

    /**
     * regime de sortie
     */
    @Column(name = "som_regime")
    private String somRegime;

    /**
     * nom du tiers
     */
    @Column(name = "som_nom_tiers")
    private String somNomTiers;

    @Column(name = "exeach_id", nullable = false)
    private Long exeachId;

    @Column(name = "usr_id")
    private Long usrId;

}
