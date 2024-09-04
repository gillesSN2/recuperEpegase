package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pay_plan_paye")
public class PayPlanPaye implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "plp_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plpId;

    /**
     * date de creation
     */
    @Column(name = "plp_date_creat")
    private LocalDateTime plpDateCreat;

    /**
     * date de modification
     */
    @Column(name = "plp_date_modif")
    private LocalDateTime plpDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "plp_user_creat")
    private Long plpUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "plp_user_modif")
    private Long plpUserModif = 0L;

    /**
     * numero de code
     */
    @Column(name = "plp_code")
    private String plpCode;

    /**
     * libelle du rubrique en FR
     */
    @Column(name = "plp_libelle_FR")
    private String plpLibelleFr;

    /**
     * commentaire
     */
    @Column(name = "plp_commentaire")
    private String plpCommentaire;

    /**
     * libelle du rubrique en UK
     */
    @Column(name = "plp_libelle_UK")
    private String plpLibelleUk;

    /**
     * libelle du rubrique en SP
     */
    @Column(name = "plp_libelle_SP")
    private String plpLibelleSp;

    /**
     * code nature
     */
    @Column(name = "plp_nature")
    private Integer plpNature = 0;

    /**
     * libelle nature en FR
     */
    @Column(name = "plp_libelle_nature_FR")
    private String plpLibelleNatureFr;

    /**
     * 0=+ 1=- 2=calcul 3=resultat
     */
    @Column(name = "plp_sens")
    private Integer plpSens = 0;

    /**
     * 0=sans 1=fiche preparatoire 2=modification mensuelle
     */
    @Column(name = "plp_option")
    private Integer plpOption = 0;

    /**
     * 0=groupe ...
     */
    @Column(name = "plp_groupe")
    private Integer plpGroupe = 0;

    /**
     * 0=actif 1=inactif
     */
    @Column(name = "plp_inactif")
    private Integer plpInactif = 0;

    /**
     * compte normal
     */
    @Column(name = "plp_compte_normal")
    private String plpCompteNormal;

    /**
     * compte prestataire
     */
    @Column(name = "plp_compte_prestataire")
    private String plpComptePrestataire;

    /**
     * contre partie normal
     */
    @Column(name = "plp_cp_normal")
    private String plpCpNormal;

    /**
     * contre partie prestataire
     */
    @Column(name = "plp_cp_prestataire")
    private String plpCpPrestataire;

    /**
     * 0=sans analytique 1=avec imputation analytique
     */
    @Column(name = "plp_analytique")
    private Integer plpAnalytique = 0;

    /**
     * 0=sans ran 1=avec ran
     */
    @Column(name = "plp_ran")
    private Integer plpRan = 0;

    /**
     * 0=sans protection 1=avec protection
     */
    @Column(name = "plp_protege")
    private Integer plpProtege = 0;

    /**
     * true = integre dans la base fiscale
     */
    @Column(name = "plp_base_fiscale")
    private Boolean plpBaseFiscale = Boolean.FALSE;

    /**
     * true = integre dans la base sociale
     */
    @Column(name = "plp_base_sociale")
    private Boolean plpBaseSociale = Boolean.FALSE;

    /**
     * true = integre dans la base autre
     */
    @Column(name = "plp_base_autre")
    private Boolean plpBaseAutre = Boolean.FALSE;

    /**
     * true = integre dans la base patronale
     */
    @Column(name = "plp_base_patronale")
    private Boolean plpBasePatronale = Boolean.FALSE;

    /**
     * taux integre dans la base fiscale
     */
    @Column(name = "plp_taux_fiscale")
    private Float plpTauxFiscale = 0F;

    /**
     * taux integre dans la base sociale
     */
    @Column(name = "plp_taux_sociale")
    private Float plpTauxSociale = 0F;

    /**
     * taux integre dans la base autre
     */
    @Column(name = "plp_taux_autre")
    private Float plpTauxAutre = 0F;

    /**
     * taux integre dans la base patronale
     */
    @Column(name = "plp_taux_patronale")
    private Float plpTauxPatronale = 0F;

    /**
     * formule integre dans la base fiscale
     */
    @Column(name = "plp_formule_fiscale")
    private String plpFormuleFiscale;

    /**
     * formule integre dans la base sociale
     */
    @Column(name = "plp_formule_sociale")
    private String plpFormuleSociale;

    /**
     * formule integre dans la base autre
     */
    @Column(name = "plp_formule_autre")
    private String plpFormuleAutre;

    /**
     * formule integre dans la base patronale
     */
    @Column(name = "plp_formule_patronale")
    private String plpFormulePatronale;

    @Column(name = "exepay_id", nullable = false)
    private Long exepayId;

    /**
     * taux integre dans la base patronale
     */
    @Column(name = "plp_taux_patronal")
    private Float plpTauxPatronal = 0F;

    /**
     * true = integre dans la base heure supplementaire
     */
    @Column(name = "plp_base_heure_sup")
    private Boolean plpBaseHeureSup = Boolean.FALSE;

    /**
     * true = integre dans la facture interim
     */
    @Column(name = "plp_facture")
    private Boolean plpFacture = Boolean.FALSE;

}
