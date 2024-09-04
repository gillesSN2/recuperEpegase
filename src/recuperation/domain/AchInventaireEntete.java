package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ach_inventaire_entete")
public class AchInventaireEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "inv_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invId;

    /**
     * date de creation
     */
    @Column(name = "inv_date_creat")
    private LocalDateTime invDateCreat;

    /**
     * date de modification
     */
    @Column(name = "inv_date_modif")
    private LocalDateTime invDateModif;

    /**
     * id user createur
     */
    @Column(name = "inv_id_createur")
    private Long invIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "inv_nom_createur")
    private String invNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "inv_id_modif")
    private Long invIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "inv_nom_modif")
    private String invNomModif;

    /**
     * date inventaire
     */
    @Column(name = "inv_date")
    private LocalDateTime invDate;

    /**
     * numero inventaire
     */
    @Column(name = "inv_num")
    private String invNum;

    /**
     * depot inventorie
     */
    @Column(name = "inv_depot")
    private String invDepot;

    /**
     * 0=ecrasement 1=correction
     */
    @Column(name = "inv_type")
    private Integer invType = 0;

    /**
     * 0=normal 1=sur depot 2=sur casier 3=sur famille 4=sur stock negatif
     */
    @Column(name = "inv_mode")
    private Integer invMode = 0;

    /**
     * specification de creation inventaire
     */
    @Column(name = "inv_mode_specif")
    private String invModeSpecif;

    /**
     * nom du commercial
     */
    @Column(name = "inv_nom_responsable")
    private String invNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "inv_id_responsable")
    private Long invIdResponsable = 0L;

    /**
     * serie
     */
    @Column(name = "inv_serie")
    private String invSerie;

    /**
     * objet
     */
    @Column(name = "inv_object")
    private String invObject;

    /**
     * total ttc
     */
    @Column(name = "inv_tot_pump")
    private Double invTotPump = 0D;

    /**
     * code activite
     */
    @Column(name = "inv_activite")
    private String invActivite;

    /**
     * code site
     */
    @Column(name = "inv_site")
    private String invSite;

    /**
     * code departement
     */
    @Column(name = "inv_departement")
    private String invDepartement;

    /**
     * code service
     */
    @Column(name = "inv_service")
    private String invService;

    /**
     * code region
     */
    @Column(name = "inv_region")
    private String invRegion;

    /**
     * code secteur
     */
    @Column(name = "inv_secteur")
    private String invSecteur;

    /**
     * code point de vente
     */
    @Column(name = "inv_pdv")
    private String invPdv;

    /**
     * code analytique 2
     */
    @Column(name = "inv_anal2")
    private String invAnal2;

    /**
     * code analytique 4
     */
    @Column(name = "inv_anal4")
    private String invAnal4;

    /**
     * info 1
     */
    @Column(name = "inv_info1")
    private String invInfo1;

    /**
     * info 2
     */
    @Column(name = "inv_info2")
    private String invInfo2;

    /**
     * info 3
     */
    @Column(name = "inv_info3")
    private String invInfo3;

    /**
     * info 4
     */
    @Column(name = "inv_info4")
    private String invInfo4;

    /**
     * info 5
     */
    @Column(name = "inv_info5")
    private String invInfo5;

    /**
     * info 6
     */
    @Column(name = "inv_info6")
    private String invInfo6;

    /**
     * info 7
     */
    @Column(name = "inv_info7")
    private String invInfo7;

    /**
     * info 8
     */
    @Column(name = "inv_info8")
    private String invInfo8;

    /**
     * info 9
     */
    @Column(name = "inv_info9")
    private String invInfo9;

    /**
     * info 10
     */
    @Column(name = "inv_info10")
    private String invInfo10;

    /**
     * date impression
     */
    @Column(name = "inv_date_imp")
    private LocalDate invDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "inv_modele_imp")
    private String invModeleImp;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "inv_etat_val")
    private Integer invEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "inv_gele")
    private Integer invGele = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule
     */
    @Column(name = "inv_etat")
    private Integer invEtat = 0;

    /**
     * date de validation
     */
    @Column(name = "inv_date_valide")
    private LocalDate invDateValide;

    /**
     * date annulation
     */
    @Column(name = "inv_date_annule")
    private LocalDate invDateAnnule;

    /**
     * motif annulation
     */
    @Column(name = "inv_motif_annule")
    private String invMotifAnnule;

    @Column(name = "exeach_id", nullable = false)
    private Long exeachId;

    @Column(name = "usr_id")
    private Long usrId;

    /**
     * nom equipe
     */
    @Column(name = "inv_nom_equipe")
    private String invNomEquipe;

    /**
     * id equipe
     */
    @Column(name = "inv_id_equipe")
    private Long invIdEquipe = 0L;

}
