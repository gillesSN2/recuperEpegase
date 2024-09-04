package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vte_campagne_entete")
public class VteCampagneEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cam_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long camId;

    /**
     * date de creation
     */
    @Column(name = "cam_date_creat")
    private LocalDateTime camDateCreat;

    /**
     * date de modification
     */
    @Column(name = "cam_date_modif")
    private LocalDateTime camDateModif;

    /**
     * id user createur
     */
    @Column(name = "cam_id_createur")
    private Long camIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "cam_nom_createur")
    private String camNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "cam_id_modif")
    private Long camIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "cam_nom_modif")
    private String camNomModif;

    /**
     * date debut de campagne
     */
    @Column(name = "cam_date_debut")
    private LocalDate camDateDebut;

    /**
     * date fin de campagne
     */
    @Column(name = "cam_date_Fin")
    private LocalDate camDateFin;

    /**
     * numero campagne
     */
    @Column(name = "cam_num")
    private String camNum;

    /**
     * serie campagne
     */
    @Column(name = "cam_serie")
    private String camSerie;

    /**
     * date campagne
     */
    @Column(name = "cam_date")
    private LocalDateTime camDate;

    /**
     * objet campagne
     */
    @Column(name = "cam_objet")
    private String camObjet;

    /**
     * descriptif campagne
     */
    @Column(name = "cam_descriptif")
    private String camDescriptif;

    /**
     * nom du commercial
     */
    @Column(name = "cam_nom_responsable")
    private String camNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "cam_id_responsable")
    private Long camIdResponsable = 0L;

    /**
     * nom du commercial
     */
    @Column(name = "cam_nom_commercial")
    private String camNomCommercial;

    /**
     * id du commercial
     */
    @Column(name = "cam_id_commercial")
    private Long camIdCommercial = 0L;

    /**
     * nom du equipe
     */
    @Column(name = "cam_nom_equipe")
    private String camNomEquipe;

    /**
     * id du equipe
     */
    @Column(name = "cam_id_equipe")
    private Long camIdEquipe = 0L;

    /**
     * total budget
     */
    @Column(name = "cam_tot_budget")
    private Double camTotBudget = 0D;

    /**
     * total depense
     */
    @Column(name = "cam_tot_depense")
    private Double camTotDepense = 0D;

    /**
     * total recette
     */
    @Column(name = "cam_tot_recette")
    private Double camTotRecette = 0D;

    /**
     * depense - recette
     */
    @Column(name = "cam_marge")
    private Double camMarge = 0D;

    /**
     * code activite
     */
    @Column(name = "cam_activite")
    private String camActivite;

    /**
     * code site
     */
    @Column(name = "cam_site")
    private String camSite;

    /**
     * code departement
     */
    @Column(name = "cam_departement")
    private String camDepartement;

    /**
     * code service
     */
    @Column(name = "cam_service")
    private String camService;

    /**
     * code analytique 2
     */
    @Column(name = "cam_anal2")
    private String camAnal2;

    /**
     * code analytique 4
     */
    @Column(name = "cam_anal4")
    private String camAnal4;

    /**
     * date impression
     */
    @Column(name = "cam_date_imp")
    private LocalDate camDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "cam_modele_imp")
    private String camModeleImp;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "cam_etat_val")
    private Integer camEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "cam_gele")
    private Integer camGele = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=cloture
     */
    @Column(name = "cam_etat")
    private Integer camEtat = 0;

    /**
     * date de validite
     */
    @Column(name = "cam_date_validite")
    private LocalDate camDateValidite;

    /**
     * date de validation
     */
    @Column(name = "cam_date_valide")
    private LocalDate camDateValide;

    /**
     * date annulation
     */
    @Column(name = "cam_date_annule")
    private LocalDate camDateAnnule;

    /**
     * motif annulation
     */
    @Column(name = "cam_motif_annule")
    private String camMotifAnnule;

    /**
     * date transfert en compta
     */
    @Column(name = "cam_date_transfert")
    private LocalDate camDateTransfert;

    @Column(name = "exevte_id", nullable = false)
    private Long exevteId;

    @Column(name = "usr_id")
    private Long usrId;

}
