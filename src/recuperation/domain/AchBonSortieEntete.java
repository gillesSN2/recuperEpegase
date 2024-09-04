package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ach_bon_sortie_entete")
public class AchBonSortieEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "bou_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bouId;

    /**
     * date de creation
     */
    @Column(name = "bou_date_creat")
    private LocalDateTime bouDateCreat;

    /**
     * date de modification
     */
    @Column(name = "bou_date_modif")
    private LocalDateTime bouDateModif;

    /**
     * id user createur
     */
    @Column(name = "bou_id_createur")
    private Long bouIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "bou_nom_createur")
    private String bouNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "bou_id_modif")
    private Long bouIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "bou_nom_modif")
    private String bouNomModif;

    /**
     * date inventaire
     */
    @Column(name = "bou_date")
    private LocalDateTime bouDate;

    /**
     * numero inventaire
     */
    @Column(name = "bou_num")
    private String bouNum;

    /**
     * depot inventorie
     */
    @Column(name = "bou_depot")
    private String bouDepot;

    /**
     * nom du commercial
     */
    @Column(name = "bou_nom_responsable")
    private String bouNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "bou_id_responsable")
    private Long bouIdResponsable = 0L;

    /**
     * serie
     */
    @Column(name = "bou_serie")
    private String bouSerie;

    /**
     * objet
     */
    @Column(name = "bou_object")
    private String bouObject;

    /**
     * total ttc
     */
    @Column(name = "bou_tot_pump")
    private Double bouTotPump = 0D;

    /**
     * code activite
     */
    @Column(name = "bou_activite")
    private String bouActivite;

    /**
     * code site
     */
    @Column(name = "bou_site")
    private String bouSite;

    /**
     * code departement
     */
    @Column(name = "bou_departement")
    private String bouDepartement;

    /**
     * code service
     */
    @Column(name = "bou_service")
    private String bouService;

    /**
     * code region
     */
    @Column(name = "bou_region")
    private String bouRegion;

    /**
     * code secteur
     */
    @Column(name = "bou_secteur")
    private String bouSecteur;

    /**
     * code point de vente
     */
    @Column(name = "bou_pdv")
    private String bouPdv;

    /**
     * code analytique 2
     */
    @Column(name = "bou_anal2")
    private String bouAnal2;

    /**
     * code analytique 4
     */
    @Column(name = "bou_anal4")
    private String bouAnal4;

    /**
     * info 1
     */
    @Column(name = "bou_info1")
    private String bouInfo1;

    /**
     * info 2
     */
    @Column(name = "bou_info2")
    private String bouInfo2;

    /**
     * info 3
     */
    @Column(name = "bou_info3")
    private String bouInfo3;

    /**
     * info 4
     */
    @Column(name = "bou_info4")
    private String bouInfo4;

    /**
     * info 5
     */
    @Column(name = "bou_info5")
    private String bouInfo5;

    /**
     * info 6
     */
    @Column(name = "bou_info6")
    private String bouInfo6;

    /**
     * info 7
     */
    @Column(name = "bou_info7")
    private String bouInfo7;

    /**
     * info 8
     */
    @Column(name = "bou_info8")
    private String bouInfo8;

    /**
     * info 9
     */
    @Column(name = "bou_info9")
    private String bouInfo9;

    /**
     * info 10
     */
    @Column(name = "bou_info10")
    private String bouInfo10;

    /**
     * date impression
     */
    @Column(name = "bou_date_imp")
    private LocalDate bouDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "bou_modele_imp")
    private String bouModeleImp;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "bou_etat_val")
    private Integer bouEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "bou_gele")
    private Integer bouGele = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule
     */
    @Column(name = "bou_etat")
    private Integer bouEtat = 0;

    /**
     * date de validation
     */
    @Column(name = "bou_date_valide")
    private LocalDate bouDateValide;

    /**
     * date annulation
     */
    @Column(name = "bou_date_annule")
    private LocalDate bouDateAnnule;

    /**
     * motif annulation
     */
    @Column(name = "bou_motif_annule")
    private String bouMotifAnnule;

    @Column(name = "exeach_id", nullable = false)
    private Long exeachId;

    @Column(name = "usr_id")
    private Long usrId;

    /**
     * nom du demandeur
     */
    @Column(name = "bou_nom_demandeur")
    private String bouNomDemandeur;

    /**
     * id du demandeur
     */
    @Column(name = "bou_id_demandeur")
    private Long bouIdDemandeur = 0L;

    /**
     * nom equipe
     */
    @Column(name = "bou_nom_equipe")
    private String bouNomEquipe;

    /**
     * id equipe
     */
    @Column(name = "bou_id_equipe")
    private Long bouIdEquipe = 0L;

}
