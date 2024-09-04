package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ach_demande_entete")
public class AchDemandeEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "dem_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long demId;

    /**
     * date de creation
     */
    @Column(name = "dem_date_creat")
    private LocalDateTime demDateCreat;

    /**
     * date de modification
     */
    @Column(name = "dem_date_modif")
    private LocalDateTime demDateModif;

    /**
     * id user createur
     */
    @Column(name = "dem_id_createur")
    private Long demIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "dem_nom_createur")
    private String demNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "dem_id_modif")
    private Long demIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "dem_nom_modif")
    private String demNomModif;

    /**
     * date du reception
     */
    @Column(name = "dem_date")
    private LocalDate demDate;

    /**
     * numero reception
     */
    @Column(name = "dem_num")
    private String demNum;

    /**
     * nom du commercial
     */
    @Column(name = "dem_nom_responsable")
    private String demNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "dem_id_responsable")
    private Long demIdResponsable = 0L;

    /**
     * serie
     */
    @Column(name = "dem_serie")
    private String demSerie;

    /**
     * objet
     */
    @Column(name = "dem_object")
    private String demObject;

    /**
     * observation
     */
    @Column(name = "dem_observation")
    private String demObservation;

    /**
     * code budget
     */
    @Column(name = "dem_budget")
    private String demBudget;

    /**
     * montant disponible sur budget
     */
    @Column(name = "dem_budget_dispo")
    private Double demBudgetDispo = 0D;

    /**
     * montant disponible sur treso
     */
    @Column(name = "dem_budget_treso")
    private Double demBudgetTreso = 0D;

    /**
     * budget mensuel dispo
     */
    @Column(name = "dem_budget_dispo_mois")
    private Double demBudgetDispoMois = 0D;

    /**
     * budget mensuel treso
     */
    @Column(name = "dem_budget_treso_mois")
    private Double demBudgetTresoMois = 0D;

    /**
     * total ht
     */
    @Column(name = "dem_tot_ht")
    private Double demTotHt = 0D;

    /**
     * ttal tva
     */
    @Column(name = "dem_tot_tva")
    private Double demTotTva = 0D;

    /**
     * total ttc
     */
    @Column(name = "dem_tot_ttc")
    private Double demTotTtc = 0D;

    /**
     * code activite
     */
    @Column(name = "dem_activite")
    private String demActivite;

    /**
     * code site
     */
    @Column(name = "dem_site")
    private String demSite;

    /**
     * code departement
     */
    @Column(name = "dem_departement")
    private String demDepartement;

    /**
     * code service
     */
    @Column(name = "dem_service")
    private String demService;

    /**
     * code region
     */
    @Column(name = "dem_region")
    private String demRegion;

    /**
     * code secteur
     */
    @Column(name = "dem_secteur")
    private String demSecteur;

    /**
     * code point de vente
     */
    @Column(name = "dem_pdv")
    private String demPdv;

    /**
     * code analytique 2
     */
    @Column(name = "dem_anal2")
    private String demAnal2;

    /**
     * code analytique 4
     */
    @Column(name = "dem_anal4")
    private String demAnal4;

    /**
     * info 1
     */
    @Column(name = "dem_info1")
    private String demInfo1;

    /**
     * info 2
     */
    @Column(name = "dem_info2")
    private String demInfo2;

    /**
     * info 3
     */
    @Column(name = "dem_info3")
    private String demInfo3;

    /**
     * info 4
     */
    @Column(name = "dem_info4")
    private String demInfo4;

    /**
     * info 5
     */
    @Column(name = "dem_info5")
    private String demInfo5;

    /**
     * info 6
     */
    @Column(name = "dem_info6")
    private String demInfo6;

    /**
     * info 7
     */
    @Column(name = "dem_info7")
    private String demInfo7;

    /**
     * info 8
     */
    @Column(name = "dem_info8")
    private String demInfo8;

    /**
     * info 9
     */
    @Column(name = "dem_info9")
    private String demInfo9;

    /**
     * info 10
     */
    @Column(name = "dem_info10")
    private String demInfo10;

    /**
     * code formule 1
     */
    @Column(name = "dem_formule1")
    private String demFormule1;

    /**
     * code formule 2
     */
    @Column(name = "dem_formule2")
    private String demFormule2;

    /**
     * nom jasper anexe 1
     */
    @Column(name = "dem_annexe1")
    private String demAnnexe1;

    /**
     * nom jasper anexe 2
     */
    @Column(name = "dem_annexe2")
    private String demAnnexe2;

    /**
     * date impression
     */
    @Column(name = "dem_date_imp")
    private LocalDate demDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "dem_modele_imp")
    private String demModeleImp;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "dem_etat_val")
    private Integer demEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "dem_gele")
    private Integer demGele = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    @Column(name = "dem_etat")
    private Integer demEtat = 0;

    /**
     * date de validite
     */
    @Column(name = "dem_date_validite")
    private LocalDate demDateValidite;

    /**
     * date de relance
     */
    @Column(name = "dem_date_relance")
    private LocalDate demDateRelance;

    /**
     * date de validation
     */
    @Column(name = "dem_date_valide")
    private LocalDate demDateValide;

    /**
     * date de transformation
     */
    @Column(name = "dem_date_transforme")
    private LocalDate demDateTransforme;

    /**
     * type de transformation
     */
    @Column(name = "dem_type_transforme")
    private Integer demTypeTransforme = 0;

    /**
     * date annulation
     */
    @Column(name = "dem_date_annule")
    private LocalDate demDateAnnule;

    /**
     * motif annulation
     */
    @Column(name = "dem_motif_annule")
    private String demMotifAnnule;

    @Column(name = "exeach_id", nullable = false)
    private Long exeachId;

    @Column(name = "usr_id")
    private Long usrId;

}
