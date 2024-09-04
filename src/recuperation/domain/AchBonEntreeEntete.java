package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ach_bon_entree_entete")
public class AchBonEntreeEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "bin_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long binId;

    /**
     * date de creation
     */
    @Column(name = "bin_date_creat")
    private LocalDateTime binDateCreat;

    /**
     * date de modification
     */
    @Column(name = "bin_date_modif")
    private LocalDateTime binDateModif;

    /**
     * id user createur
     */
    @Column(name = "bin_id_createur")
    private Long binIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "bin_nom_createur")
    private String binNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "bin_id_modif")
    private Long binIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "bin_nom_modif")
    private String binNomModif;

    /**
     * date inventaire
     */
    @Column(name = "bin_date")
    private LocalDateTime binDate;

    /**
     * numero inventaire
     */
    @Column(name = "bin_num")
    private String binNum;

    /**
     * depot inventorie
     */
    @Column(name = "bin_depot")
    private String binDepot;

    /**
     * nom du commercial
     */
    @Column(name = "bin_nom_responsable")
    private String binNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "bin_id_responsable")
    private Long binIdResponsable = 0L;

    /**
     * serie
     */
    @Column(name = "bin_serie")
    private String binSerie;

    /**
     * objet
     */
    @Column(name = "bin_object")
    private String binObject;

    /**
     * total ttc
     */
    @Column(name = "bin_tot_pump")
    private Double binTotPump = 0D;

    /**
     * code activite
     */
    @Column(name = "bin_activite")
    private String binActivite;

    /**
     * code site
     */
    @Column(name = "bin_site")
    private String binSite;

    /**
     * code departement
     */
    @Column(name = "bin_departement")
    private String binDepartement;

    /**
     * code service
     */
    @Column(name = "bin_service")
    private String binService;

    /**
     * code region
     */
    @Column(name = "bin_region")
    private String binRegion;

    /**
     * code secteur
     */
    @Column(name = "bin_secteur")
    private String binSecteur;

    /**
     * code point de vente
     */
    @Column(name = "bin_pdv")
    private String binPdv;

    /**
     * code analytique 2
     */
    @Column(name = "bin_anal2")
    private String binAnal2;

    /**
     * code analytique 4
     */
    @Column(name = "bin_anal4")
    private String binAnal4;

    /**
     * info 1
     */
    @Column(name = "bin_info1")
    private String binInfo1;

    /**
     * info 2
     */
    @Column(name = "bin_info2")
    private String binInfo2;

    /**
     * info 3
     */
    @Column(name = "bin_info3")
    private String binInfo3;

    /**
     * info 4
     */
    @Column(name = "bin_info4")
    private String binInfo4;

    /**
     * info 5
     */
    @Column(name = "bin_info5")
    private String binInfo5;

    /**
     * info 6
     */
    @Column(name = "bin_info6")
    private String binInfo6;

    /**
     * info 7
     */
    @Column(name = "bin_info7")
    private String binInfo7;

    /**
     * info 8
     */
    @Column(name = "bin_info8")
    private String binInfo8;

    /**
     * info 9
     */
    @Column(name = "bin_info9")
    private String binInfo9;

    /**
     * info 10
     */
    @Column(name = "bin_info10")
    private String binInfo10;

    /**
     * date impression
     */
    @Column(name = "bin_date_imp")
    private LocalDate binDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "bin_modele_imp")
    private String binModeleImp;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "bin_etat_val")
    private Integer binEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "bin_gele")
    private Integer binGele = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule
     */
    @Column(name = "bin_etat")
    private Integer binEtat = 0;

    /**
     * date de validation
     */
    @Column(name = "bin_date_valide")
    private LocalDate binDateValide;

    /**
     * date annulation
     */
    @Column(name = "bin_date_annule")
    private LocalDate binDateAnnule;

    /**
     * motif annulation
     */
    @Column(name = "bin_motif_annule")
    private String binMotifAnnule;

    @Column(name = "exeach_id", nullable = false)
    private Long exeachId;

    @Column(name = "usr_id")
    private Long usrId;

    /**
     * nom du rapporteur
     */
    @Column(name = "bin_nom_rapporteur")
    private String binNomRapporteur;

    /**
     * id du rapporteur
     */
    @Column(name = "bin_id_rapporteur")
    private Long binIdRapporteur = 0L;

    /**
     * numero contrat
     */
    @Column(name = "bin_contrat")
    private String binContrat;

    /**
     * nom equipe
     */
    @Column(name = "bin_nom_equipe")
    private String binNomEquipe;

    /**
     * id equipe
     */
    @Column(name = "bin_id_equipe")
    private Long binIdEquipe = 0L;

}
