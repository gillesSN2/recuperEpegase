package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ach_fabrication_entete_achats")
public class AchFabricationEnteteAchats implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "fab_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fabId;

    /**
     * date de creation
     */
    @Column(name = "fab_date_creat")
    private LocalDateTime fabDateCreat;

    /**
     * date de modification
     */
    @Column(name = "fab_date_modif")
    private LocalDateTime fabDateModif;

    /**
     * id user createur
     */
    @Column(name = "fab_id_createur")
    private Long fabIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "fab_nom_createur")
    private String fabNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "fab_id_modif")
    private Long fabIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "fab_nom_modif")
    private String fabNomModif;

    /**
     * date inventaire
     */
    @Column(name = "fab_date")
    private LocalDateTime fabDate;

    /**
     * numero inventaire
     */
    @Column(name = "fab_num")
    private String fabNum;

    /**
     * code du process
     */
    @Column(name = "fab_process")
    private String fabProcess;

    /**
     * depot inventorie
     */
    @Column(name = "fab_depot")
    private String fabDepot;

    /**
     * nom equipe
     */
    @Column(name = "fab_nom_equipe")
    private String fabNomEquipe;

    /**
     * id equipe
     */
    @Column(name = "fab_id_equipe")
    private Long fabIdEquipe = 0L;

    /**
     * nom du commercial
     */
    @Column(name = "fab_nom_responsable")
    private String fabNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "fab_id_responsable")
    private Long fabIdResponsable = 0L;

    /**
     * serie
     */
    @Column(name = "fab_serie")
    private String fabSerie;

    /**
     * objet
     */
    @Column(name = "fab_object")
    private String fabObject;

    /**
     * total ttc
     */
    @Column(name = "fab_tot_pump")
    private Double fabTotPump = 0D;

    /**
     * code activite
     */
    @Column(name = "fab_activite")
    private String fabActivite;

    /**
     * code site
     */
    @Column(name = "fab_site")
    private String fabSite;

    /**
     * code ligne
     */
    @Column(name = "fab_ligne")
    private String fabLigne;

    /**
     * code atelier
     */
    @Column(name = "fab_atelier")
    private String fabAtelier;

    /**
     * code analytique 2
     */
    @Column(name = "fab_anal2")
    private String fabAnal2;

    /**
     * code analytique 4
     */
    @Column(name = "fab_anal4")
    private String fabAnal4;

    /**
     * info 1
     */
    @Column(name = "fab_info1")
    private String fabInfo1;

    /**
     * info 2
     */
    @Column(name = "fab_info2")
    private String fabInfo2;

    /**
     * info 3
     */
    @Column(name = "fab_info3")
    private String fabInfo3;

    /**
     * info 4
     */
    @Column(name = "fab_info4")
    private String fabInfo4;

    /**
     * info 5
     */
    @Column(name = "fab_info5")
    private String fabInfo5;

    /**
     * info 6
     */
    @Column(name = "fab_info6")
    private String fabInfo6;

    /**
     * info 7
     */
    @Column(name = "fab_info7")
    private String fabInfo7;

    /**
     * info 8
     */
    @Column(name = "fab_info8")
    private String fabInfo8;

    /**
     * info 9
     */
    @Column(name = "fab_info9")
    private String fabInfo9;

    /**
     * info 10
     */
    @Column(name = "fab_info10")
    private String fabInfo10;

    /**
     * date impression
     */
    @Column(name = "fab_date_imp")
    private LocalDateTime fabDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "fab_modele_imp")
    private String fabModeleImp;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "fab_etat_val")
    private Integer fabEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "fab_gele")
    private Integer fabGele = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule
     */
    @Column(name = "fab_etat")
    private Integer fabEtat = 0;

    /**
     * date de validation
     */
    @Column(name = "fab_date_valide")
    private LocalDate fabDateValide;

    /**
     * date annulation
     */
    @Column(name = "fab_date_annule")
    private LocalDate fabDateAnnule;

    /**
     * motif annulation
     */
    @Column(name = "fab_motif_annule")
    private String fabMotifAnnule;

    @Column(name = "exeach_id", nullable = false)
    private Long exeachId;

    @Column(name = "usr_id")
    private Long usrId;

}
