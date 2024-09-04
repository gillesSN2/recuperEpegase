package recuperation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cai_traite_entete")
public class CaiTraiteEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "trt_id", nullable = false)
    private Long trtId;

    /**
     * date de creation
     */
    @Column(name = "trt_date_creat")
    private LocalDateTime trtDateCreat;

    /**
     * user de creation
     */
    @Column(name = "trt_user_creat")
    private Long trtUserCreat = 0L;

    /**
     * date de modification
     */
    @Column(name = "trt_date_modif")
    private LocalDateTime trtDateModif;

    /**
     * user de creation
     */
    @Column(name = "trt_user_modif")
    private Long trtUserModif = 0L;

    /**
     * 65=traite domiciliee 66=traite en portfeuille 67=traite entreprise
     */
    @Column(name = "trt_nature")
    private Integer trtNature;

    /**
     * numero de la traite
     */
    @Column(name = "trt_num")
    private String trtNum;

    /**
     * date debut
     */
    @Column(name = "trt_date_debut")
    private LocalDate trtDateDebut;

    /**
     * date contrat
     */
    @Column(name = "trt_date_contrat")
    private LocalDate trtDateContrat;

    /**
     * duree en nb mois
     */
    @Column(name = "trt_duree")
    private Integer trtDuree = 0;

    /**
     * periodicite
     */
    @Column(name = "trt_periodicite")
    private Integer trtPeriodicite = 0;

    /**
     * nom du responsable
     */
    @Column(name = "trt_nom_responsable")
    private String trtNomResponsable;

    /**
     * id du responsable
     */
    @Column(name = "trt_id_responsable")
    private Long trtIdResponsable = 0L;

    /**
     * 0=client 1=fournisseur
     */
    @Column(name = "trt_type_tiers")
    private Integer trtTypeTiers = 0;

    /**
     * nom du tiers
     */
    @Column(name = "trt_nom_tiers")
    private String trtNomTiers;

    /**
     * id du tiers
     */
    @Column(name = "trt_id_tiers")
    private Long trtIdTiers = 0L;

    /**
     * devise
     */
    @Column(name = "trt_devise")
    private String trtDevise;

    /**
     * montant
     */
    @Column(name = "trt_montant")
    private Double trtMontant = 0D;

    /**
     * nb de mois general
     */
    @Column(name = "trt_nb_mois_echeance_gene")
    private Integer trtNbMoisEcheanceGene = 0;

    /**
     * montant general
     */
    @Column(name = "trt_montant_gene")
    private Double trtMontantGene = 0D;

    /**
     * montant final
     */
    @Column(name = "trt_montant_final")
    private Double trtMontantFinal = 0D;

    /**
     * total reglement
     */
    @Column(name = "trt_total_reglement")
    private Double trtTotalReglement = 0D;

    /**
     * objet
     */
    @Column(name = "trt_objet")
    private String trtObjet;

    /**
     * facture concernee
     */
    @Column(name = "trt_facture")
    private String trtFacture;

    /**
     * banque
     */
    @Column(name = "trt_banque")
    private String trtBanque;

    /**
     * activite
     */
    @Column(name = "trt_activite")
    private String trtActivite;

    /**
     * site
     */
    @Column(name = "trt_site")
    private String trtSite;

    /**
     * departement
     */
    @Column(name = "trt_departement")
    private String trtDepartement;

    /**
     * service
     */
    @Column(name = "trt_service")
    private String trtService;

    /**
     * region
     */
    @Column(name = "trt_region")
    private String trtRegion;

    /**
     * secteur
     */
    @Column(name = "trt_secteur")
    private String trtSecteur;

    /**
     * pdv
     */
    @Column(name = "trt_pdv")
    private String trtPdv;

    /**
     * budget
     */
    @Column(name = "trt_budget")
    private String trtBudget;

    /**
     * dossier
     */
    @Column(name = "trt_dossier")
    private String trtDossier;

    /**
     * 0=en 1=valide 2=gele 3=annule 4=execute
     */
    @Column(name = "trt_etat")
    private Integer trtEtat = 0;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "trt_etat_val")
    private Integer trtEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "trt_gele")
    private Integer trtGele = 0;

    /**
     * date de validation
     */
    @Column(name = "trt_date_valide")
    private LocalDate trtDateValide;

    /**
     * modele impression recu
     */
    @Column(name = "trt_modele_imp")
    private String trtModeleImp;

    /**
     * date impression recu
     */
    @Column(name = "trt_date_impression")
    private LocalDateTime trtDateImpression;

    @Column(name = "execai_id", nullable = false)
    private Long execaiId;

    /**
     * id banque
     */
    @Column(name = "trt_id_banque")
    private Long trtIdBanque = 0L;

}
