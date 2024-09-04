package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cpt_ecritures_analytiques_destroy")
public class CptEcrituresAnalytiquesDestroy implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ecrana_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ecranaId;

    /**
     * id origine de la table origine (pour les transferts)
     */
    @Column(name = "ecrana_id_origine")
    private Long ecranaIdOrigine = 0L;

    /**
     * AM = amortissement LO=loyer FV=facture vente FA=facture fournisseur (pour les transferts)
     */
    @Column(name = "ecrana_type_origine")
    private String ecranaTypeOrigine;

    /**
     * nature axe analytique
     */
    @Column(name = "ecrana_axe")
    private Integer ecranaAxe = 0;

    /**
     * cle analytique
     */
    @Column(name = "ecrana_cle")
    private String ecranaCle;

    /**
     * ordre
     */
    @Column(name = "ecrana_ordre")
    private Long ecranaOrdre = 0L;

    /**
     * code journal
     */
    @Column(name = "ecrana_code")
    private String ecranaCode;

    /**
     * date de saisie
     */
    @Column(name = "ecrana_date_saisie")
    private LocalDate ecranaDateSaisie;

    /**
     * periode
     */
    @Column(name = "ecrana_periode")
    private String ecranaPeriode;

    /**
     * nature du compte
     */
    @Column(name = "ecrana_nature")
    private Integer ecranaNature = 0;

    /**
     * 0=public 1=prive
     */
    @Column(name = "ecrana_reserve")
    private Integer ecranaReserve = 0;

    /**
     * compte general
     */
    @Column(name = "ecrana_compte")
    private String ecranaCompte = "0";

    /**
     * cle 1
     */
    @Column(name = "ecrana_cle1")
    private String ecranaCle1;

    /**
     * cle 2
     */
    @Column(name = "ecrana_cle2")
    private String ecranaCle2;

    /**
     * classe du compte
     */
    @Column(name = "ecrana_classe")
    private String ecranaClasse;

    /**
     * montant saisie
     */
    @Column(name = "ecrana_montant_saisie")
    private Double ecranaMontantSaisie = 0D;

    /**
     * libelle
     */
    @Column(name = "ecrana_libelle")
    private String ecranaLibelle;

    /**
     * piece
     */
    @Column(name = "ecrana_piece")
    private String ecranaPiece;

    /**
     * ref 1
     */
    @Column(name = "ecrana_reference1")
    private String ecranaReference1;

    /**
     * ref 2
     */
    @Column(name = "ecrana_reference2")
    private String ecranaReference2;

    /**
     * site
     */
    @Column(name = "ecrana_site")
    private String ecranaSite;

    /**
     * libelle site
     */
    @Column(name = "ecrana_site_lib")
    private String ecranaSiteLib;

    /**
     * site taux repartition
     */
    @Column(name = "ecrana_site_taux")
    private Float ecranaSiteTaux = 0F;

    /**
     * site montant
     */
    @Column(name = "ecrana_site_montant")
    private Double ecranaSiteMontant = 0D;

    /**
     * site visible
     */
    @Column(name = "ecrana_site_visible")
    private Boolean ecranaSiteVisible = Boolean.FALSE;

    /**
     * departement
     */
    @Column(name = "ecrana_departement")
    private String ecranaDepartement;

    /**
     * libelle departement
     */
    @Column(name = "ecrana_departement_lib")
    private String ecranaDepartementLib;

    /**
     * departement taux repartition
     */
    @Column(name = "ecrana_departement_taux")
    private Float ecranaDepartementTaux = 0F;

    /**
     * departement montant
     */
    @Column(name = "ecrana_departement_montant")
    private Double ecranaDepartementMontant = 0D;

    /**
     * departement visible
     */
    @Column(name = "ecrana_departement_visible")
    private Boolean ecranaDepartementVisible = Boolean.FALSE;

    /**
     * service
     */
    @Column(name = "ecrana_service")
    private String ecranaService;

    /**
     * libelle service
     */
    @Column(name = "ecrana_service_lib")
    private String ecranaServiceLib;

    /**
     * service taux repartition
     */
    @Column(name = "ecrana_service_taux")
    private Float ecranaServiceTaux = 0F;

    /**
     * service montant
     */
    @Column(name = "ecrana_service_montant")
    private Double ecranaServiceMontant = 0D;

    /**
     * service visible
     */
    @Column(name = "ecrana_service_visible")
    private Boolean ecranaServiceVisible = Boolean.FALSE;

    /**
     * region
     */
    @Column(name = "ecrana_region")
    private String ecranaRegion;

    /**
     * libelle region
     */
    @Column(name = "ecrana_region_lib")
    private String ecranaRegionLib;

    /**
     * region taux repartition
     */
    @Column(name = "ecrana_region_taux")
    private Float ecranaRegionTaux = 0F;

    /**
     * region montant
     */
    @Column(name = "ecrana_Region_montant")
    private Double ecranaRegionMontant = 0D;

    /**
     * region visible
     */
    @Column(name = "ecrana_region_visible")
    private Boolean ecranaRegionVisible = Boolean.FALSE;

    /**
     * secteur
     */
    @Column(name = "ecrana_secteur")
    private String ecranaSecteur;

    /**
     * libelle secteur
     */
    @Column(name = "ecrana_secteur_lib")
    private String ecranaSecteurLib;

    /**
     * secteur taux repartition
     */
    @Column(name = "ecrana_secteur_taux")
    private Float ecranaSecteurTaux = 0F;

    /**
     * secteur montant
     */
    @Column(name = "ecrana_secteur_montant")
    private Double ecranaSecteurMontant = 0D;

    /**
     * secteur visible
     */
    @Column(name = "ecrana_secteur_visible")
    private Boolean ecranaSecteurVisible = Boolean.FALSE;

    /**
     * point de vente
     */
    @Column(name = "ecrana_pdv")
    private String ecranaPdv;

    /**
     * libelle point de vente
     */
    @Column(name = "ecrana_pdv_lib")
    private String ecranaPdvLib;

    /**
     * pdv taux repartition
     */
    @Column(name = "ecrana_pdv_taux")
    private Float ecranaPdvTaux = 0F;

    /**
     * pdv montant
     */
    @Column(name = "ecrana_pdv_montant")
    private Double ecranaPdvMontant = 0D;

    /**
     * pdv visible
     */
    @Column(name = "ecrana_pdv_visible")
    private Boolean ecranaPdvVisible = Boolean.FALSE;

    /**
     * ligne
     */
    @Column(name = "ecrana_ligne")
    private String ecranaLigne;

    /**
     * libelle ligne
     */
    @Column(name = "ecrana_ligne_lib")
    private String ecranaLigneLib;

    /**
     * ligne taux repartition
     */
    @Column(name = "ecrana_ligne_taux")
    private Float ecranaLigneTaux = 0F;

    /**
     * ligne montant
     */
    @Column(name = "ecrana_ligne_montant")
    private Double ecranaLigneMontant = 0D;

    /**
     * ligne visible
     */
    @Column(name = "ecrana_ligne_visible")
    private Boolean ecranaLigneVisible = Boolean.FALSE;

    /**
     * atelier
     */
    @Column(name = "ecrana_atelier")
    private String ecranaAtelier;

    /**
     * libelle atelier
     */
    @Column(name = "ecrana_atelier_lib")
    private String ecranaAtelierLib;

    /**
     * atelier taux repartition
     */
    @Column(name = "ecrana_atelier_taux")
    private Float ecranaAtelierTaux = 0F;

    /**
     * atelier montant
     */
    @Column(name = "ecrana_atelier_montant")
    private Double ecranaAtelierMontant = 0D;

    /**
     * atelier visible
     */
    @Column(name = "ecrana_atelier_visible")
    private Boolean ecranaAtelierVisible = Boolean.FALSE;

    /**
     * activite
     */
    @Column(name = "ecrana_activite")
    private String ecranaActivite;

    /**
     * libelle activite
     */
    @Column(name = "ecrana_activite_lib")
    private String ecranaActiviteLib;

    /**
     * activite taux repartition
     */
    @Column(name = "ecrana_activite_taux")
    private Float ecranaActiviteTaux = 0F;

    /**
     * activite montant
     */
    @Column(name = "ecrana_activite_montant")
    private Double ecranaActiviteMontant = 0D;

    /**
     * activite visible
     */
    @Column(name = "ecrana_activite_visible")
    private Boolean ecranaActiviteVisible = Boolean.FALSE;

    /**
     * projet
     */
    @Column(name = "ecrana_projet")
    private String ecranaProjet;

    /**
     * libelle projet
     */
    @Column(name = "ecrana_projet_lib")
    private String ecranaProjetLib;

    /**
     * projet taux repartition
     */
    @Column(name = "ecrana_projet_taux")
    private Float ecranaProjetTaux = 0F;

    /**
     * projet montant
     */
    @Column(name = "ecrana_projet_montant")
    private Double ecranaProjetMontant = 0D;

    /**
     * projet visible
     */
    @Column(name = "ecrana_projet_visible")
    private Boolean ecranaProjetVisible = Boolean.FALSE;

    /**
     * analytique 1
     */
    @Column(name = "ecrana_anal1")
    private String ecranaAnal1;

    /**
     * libelle analytique 1
     */
    @Column(name = "ecrana_anal1_lib")
    private String ecranaAnal1Lib;

    /**
     * anal1 taux repartition
     */
    @Column(name = "ecrana_anal1_taux")
    private Float ecranaAnal1Taux = 0F;

    /**
     * anal1 montant
     */
    @Column(name = "ecrana_anal1_montant")
    private Double ecranaAnal1Montant = 0D;

    /**
     * anal1 visible
     */
    @Column(name = "ecrana_anal1_visible")
    private Boolean ecranaAnal1Visible = Boolean.FALSE;

    /**
     * analytique 2
     */
    @Column(name = "ecrana_anal2")
    private String ecranaAnal2;

    /**
     * libelle analytique 2
     */
    @Column(name = "ecrana_anal2_lib")
    private String ecranaAnal2Lib;

    /**
     * anal2 (parc) taux repartition
     */
    @Column(name = "ecrana_anal2_taux")
    private Float ecranaAnal2Taux = 0F;

    /**
     * anal2 montant
     */
    @Column(name = "ecrana_anal2_montant")
    private Double ecranaAnal2Montant = 0D;

    /**
     * anal2 visible
     */
    @Column(name = "ecrana_anal2_visible")
    private Boolean ecranaAnal2Visible = Boolean.FALSE;

    /**
     * analytique 3
     */
    @Column(name = "ecrana_anal3")
    private String ecranaAnal3;

    /**
     * libelle analytique 3
     */
    @Column(name = "ecrana_anal3_lib")
    private String ecranaAnal3Lib;

    /**
     * anal3 (agent) taux repartition
     */
    @Column(name = "ecrana_anal3_taux")
    private Float ecranaAnal3Taux = 0F;

    /**
     * anal3 montant
     */
    @Column(name = "ecrana_anal3_montant")
    private Double ecranaAnal3Montant = 0D;

    /**
     * anal3 visible
     */
    @Column(name = "ecrana_anal3_visible")
    private Boolean ecranaAnal3Visible = Boolean.FALSE;

    /**
     * analytique 4
     */
    @Column(name = "ecrana_anal4")
    private String ecranaAnal4;

    /**
     * libelle analytique 4
     */
    @Column(name = "ecrana_anal4_lib")
    private String ecranaAnal4Lib;

    /**
     * anal4 (dossier) taux repartition
     */
    @Column(name = "ecrana_anal4_taux")
    private Float ecranaAnal4Taux = 0F;

    /**
     * anal4 montant
     */
    @Column(name = "ecrana_anal4_montant")
    private Double ecranaAnal4Montant = 0D;

    /**
     * anal4 visible
     */
    @Column(name = "ecrana_anal4_visible")
    private Boolean ecranaAnal4Visible = Boolean.FALSE;

    /**
     * nature jurnal
     */
    @Column(name = "ecrana_nature_jrx")
    private Integer ecranaNatureJrx = 0;

    /**
     * cle de repartition
     */
    @Column(name = "ecrana_pourcentage")
    private Float ecranaPourcentage = 0F;

    /**
     * id ecriture gene
     */
    @Column(name = "ecr_id")
    private Long ecrId = 0L;

    /**
     * date de destruction ecriture
     */
    @Column(name = "ecrana_date_delete")
    private LocalDateTime ecranaDateDelete;

    /**
     * utilisateur de destruction ecriture
     */
    @Column(name = "ecrana_user_delete")
    private Long ecranaUserDelete;

    /**
     * sens 0=debit 1=credit
     */
    @Column(name = "ecrana_sens")
    private Integer ecranaSens = 0;

}
