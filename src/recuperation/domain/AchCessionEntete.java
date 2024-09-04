package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ach_cession_entete")
public class AchCessionEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ces_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cesId;

    /**
     * date de creation
     */
    @Column(name = "ces_date_creat")
    private LocalDateTime cesDateCreat;

    /**
     * date de modification
     */
    @Column(name = "ces_date_modif")
    private LocalDateTime cesDateModif;

    /**
     * id user createur
     */
    @Column(name = "ces_id_createur")
    private Long cesIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "ces_nom_createur")
    private String cesNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "ces_id_modif")
    private Long cesIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "ces_nom_modif")
    private String cesNomModif;

    /**
     * date inventaire
     */
    @Column(name = "ces_date")
    private LocalDateTime cesDate;

    /**
     * numero inventaire
     */
    @Column(name = "ces_num")
    private String cesNum;

    /**
     * depot origine
     */
    @Column(name = "ces_depot_origine")
    private String cesDepotOrigine;

    /**
     * depot destination
     */
    @Column(name = "ces_depot_destination")
    private String cesDepotDestination;

    /**
     * nom du commercial
     */
    @Column(name = "ces_nom_responsable")
    private String cesNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "ces_id_responsable")
    private Long cesIdResponsable = 0L;

    /**
     * serie
     */
    @Column(name = "ces_serie")
    private String cesSerie;

    /**
     * objet
     */
    @Column(name = "ces_object")
    private String cesObject;

    /**
     * total ttc
     */
    @Column(name = "ces_tot_pump")
    private Double cesTotPump = 0D;

    /**
     * code activite
     */
    @Column(name = "ces_activite")
    private String cesActivite;

    /**
     * code site
     */
    @Column(name = "ces_site")
    private String cesSite;

    /**
     * code departement
     */
    @Column(name = "ces_departement")
    private String cesDepartement;

    /**
     * code service
     */
    @Column(name = "ces_service")
    private String cesService;

    /**
     * code region
     */
    @Column(name = "ces_region")
    private String cesRegion;

    /**
     * code secteur
     */
    @Column(name = "ces_secteur")
    private String cesSecteur;

    /**
     * code point de vente
     */
    @Column(name = "ces_pdv")
    private String cesPdv;

    /**
     * code analytique 2
     */
    @Column(name = "ces_anal2")
    private String cesAnal2;

    /**
     * code analytique 4
     */
    @Column(name = "ces_anal4")
    private String cesAnal4;

    /**
     * info 1
     */
    @Column(name = "ces_info1")
    private String cesInfo1;

    /**
     * info 2
     */
    @Column(name = "ces_info2")
    private String cesInfo2;

    /**
     * info 3
     */
    @Column(name = "ces_info3")
    private String cesInfo3;

    /**
     * info 4
     */
    @Column(name = "ces_info4")
    private String cesInfo4;

    /**
     * info 5
     */
    @Column(name = "ces_info5")
    private String cesInfo5;

    /**
     * info 6
     */
    @Column(name = "ces_info6")
    private String cesInfo6;

    /**
     * info 7
     */
    @Column(name = "ces_info7")
    private String cesInfo7;

    /**
     * info 8
     */
    @Column(name = "ces_info8")
    private String cesInfo8;

    /**
     * info 9
     */
    @Column(name = "ces_info9")
    private String cesInfo9;

    /**
     * info 10
     */
    @Column(name = "ces_info10")
    private String cesInfo10;

    /**
     * date impression
     */
    @Column(name = "ces_date_imp")
    private LocalDate cesDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "ces_modele_imp")
    private String cesModeleImp;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "ces_etat_val")
    private Integer cesEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "ces_gele")
    private Integer cesGele = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule
     */
    @Column(name = "ces_etat")
    private Integer cesEtat = 0;

    /**
     * date de validation
     */
    @Column(name = "ces_date_valide")
    private LocalDate cesDateValide;

    /**
     * date annulation
     */
    @Column(name = "ces_date_annule")
    private LocalDate cesDateAnnule;

    /**
     * motif annulation
     */
    @Column(name = "ces_motif_annule")
    private String cesMotifAnnule;

    @Column(name = "exeach_id", nullable = false)
    private Long exeachId;

    @Column(name = "usr_id")
    private Long usrId;

    /**
     * nom equipe
     */
    @Column(name = "ces_nom_equipe")
    private String cesNomEquipe;

    /**
     * id equipe
     */
    @Column(name = "ces_id_equipe")
    private Long cesIdEquipe = 0L;

    /**
     * 0=standard fixe 1=standard mobile 2=fictif
     */
    @Column(name = "ces_type_depot")
    private Integer cesTypeDepot = 0;

    /**
     * code sommier sortie
     */
    @Column(name = "ces_sommier")
    private String cesSommier;

}
