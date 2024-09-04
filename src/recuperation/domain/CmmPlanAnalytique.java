package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_plan_analytique")
public class CmmPlanAnalytique implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ana_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long anaId;

    /**
     * date de creation
     */
    @Column(name = "ana_date_creat")
    private LocalDateTime anaDateCreat;

    /**
     * date de modification
     */
    @Column(name = "ana_date_modif")
    private LocalDateTime anaDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "ana_user_creat")
    private Long anaUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "ana_user_modif")
    private Long anaUserModif = 0L;

    /**
     * annee
     */
    @Column(name = "ana_annee")
    private String anaAnnee;

    /**
     * nature 1=a1 2=a2 3=a3 4=a4 5=chantier 6=dossier 7=destinataire 8=parc 9=cle
     */
    @Column(name = "ana_nature")
    private String anaNature;

    /**
     * ordre des elements
     */
    @Column(name = "ana_ordre")
    private Integer anaOrdre = 0;

    /**
     * code analytique 1
     */
    @Column(name = "ana_code")
    private String anaCode;

    /**
     * libelle en FR
     */
    @Column(name = "ana_nom_FR")
    private String anaNomFr;

    /**
     * libelle en UK
     */
    @Column(name = "ana_nom_UK")
    private String anaNomUk;

    /**
     * libelle en SP
     */
    @Column(name = "ana_nom_SP")
    private String anaNomSp;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "ana_inactif")
    private Integer anaInactif = 0;

    /**
     * nature de la repartition
     */
    @Column(name = "ana_nature_repartition")
    private Integer anaNatureRepartition = 0;

    /**
     * annee de debut de validite
     */
    @Column(name = "ana_annee_debut")
    private Integer anaAnneeDebut = 0;

    /**
     * annee de fin de validite
     */
    @Column(name = "ana_annee_fin")
    private Integer anaAnneeFin = 0;

    /**
     * type de dossier
     */
    @Column(name = "ana_type_dossier")
    private String anaTypeDossier;

    /**
     * date debut mission
     */
    @Column(name = "ana_mission_debut")
    private LocalDate anaMissionDebut;

    /**
     * date fin mission
     */
    @Column(name = "ana_mission_fin")
    private LocalDate anaMissionFin;

    /**
     * nom du proprietaire
     */
    @Column(name = "ana_mission_proprietaire")
    private String anaMissionProprietaire;

    /**
     * lettre de commande
     */
    @Column(name = "ana_mission_lettre_cmd")
    private String anaMissionLettreCmd;

    /**
     * nom du chef de chantier
     */
    @Column(name = "ana_mission_chef")
    private String anaMissionChef;

    /**
     * cout theorique
     */
    @Column(name = "ana_mission_cout_theorique")
    private Double anaMissionCoutTheorique = 0D;

    /**
     * etat du chantier 0=en cours 1=ferme 2=gele 3=abondonne
     */
    @Column(name = "ana_mission_0")
    private Integer anaMission0 = 0;

    /**
     * civilite (suivant fichier xml)
     */
    @Column(name = "ana_tiers_civilite")
    private String anaTiersCivilite;

    /**
     * telephone destinataire
     */
    @Column(name = "ana_tiers_telephone")
    private String anaTiersTelephone;

    /**
     * fax
     */
    @Column(name = "anaTiers_fax")
    private String anatiersFax;

    /**
     * adresse destinataire
     */
    @Column(name = "ana_tiers_adresse")
    private String anaTiersAdresse;

    /**
     * boite postale
     */
    @Column(name = "ana_tiers_bp")
    private String anaTiersBp;

    /**
     * adresse mail
     */
    @Column(name = "ana_tiers_mail")
    private String anaTiersMail;

    /**
     * ville
     */
    @Column(name = "ana_tiers_ville")
    private String anaTiersVille;

    /**
     * point de vente
     */
    @Column(name = "ana_tiers_Pdv")
    private String anaTiersPdv;

    /**
     * appreciation
     */
    @Column(name = "ana_tiers_appreciaiton")
    private String anaTiersAppreciaiton;

    /**
     * nom pays
     */
    @Column(name = "ana_tiers_nom_pays")
    private String anaTiersNomPays;

    /**
     * code devise
     */
    @Column(name = "ana_tiers_devise")
    private String anaTiersDevise;

    /**
     * format devise
     */
    @Column(name = "ana_tiers_format_devise")
    private Integer anaTiersFormatDevise = 0;

    /**
     * source du tiers
     */
    @Column(name = "ana_tiers_source")
    private String anaTiersSource;

    /**
     * code langue
     */
    @Column(name = "ana_tiers_langue")
    private String anaTiersLangue;

    /**
     * observations
     */
    @Column(name = "ana_tiers_obs")
    private String anaTiersObs;

    /**
     * 1=autorise dans les ventes
     */
    @Column(name = "ana_vte")
    private Boolean anaVte = Boolean.FALSE;

    /**
     * 1=autorise dans les achats
     */
    @Column(name = "ana_ach")
    private Boolean anaAch = Boolean.FALSE;

    /**
     * 1=autorise dans la production
     */
    @Column(name = "ana_prd")
    private Boolean anaPrd = Boolean.FALSE;

    /**
     * 1=autorise dans les frais generaux
     */
    @Column(name = "ana_frg")
    private Boolean anaFrg = Boolean.FALSE;

    /**
     * 1=autorise dans les investissements
     */
    @Column(name = "ana_inv")
    private Boolean anaInv = Boolean.FALSE;

    /**
     * 1=autorise dans la tva
     */
    @Column(name = "ana_tva")
    private Boolean anaTva = Boolean.FALSE;

    /**
     * 1=autorise dans les impots et taxes
     */
    @Column(name = "ana_tax")
    private Boolean anaTax = Boolean.FALSE;

    /**
     * 1=autorise dans les salaries
     */
    @Column(name = "ana_sal")
    private Boolean anaSal = Boolean.FALSE;

    /**
     * devise
     */
    @Column(name = "ana_type_devise")
    private String anaTypeDevise;

    /**
     * taux de devise
     */
    @Column(name = "ana_type_taux_devise")
    private Float anaTypeTauxDevise = 0F;

    /**
     * exoneration de tva
     */
    @Column(name = "ana_type_exo_tva")
    private Boolean anaTypeExoTva = Boolean.FALSE;

    /**
     * exoneration de douane
     */
    @Column(name = "ana_type_exo_douane")
    private Boolean anaTypeExoDouane = Boolean.FALSE;

    /**
     * etat du chantier 0=en cours 1=ferme 2=gele 3=abondonne
     */
    @Column(name = "ana_mission_etat")
    private Integer anaMissionEtat = 0;

    /**
     * regroupement des destinataires
     */
    @Column(name = "ana_tiers_regroupe")
    private String anaTiersRegroupe;

    /**
     * id du tiers
     */
    @Column(name = "ana_id_tiers")
    private Long anaIdTiers = 0L;

    /**
     * service affaire
     */
    @Column(name = "ana_affaires_service")
    private String anaAffairesService;

    /**
     * etat affaire 0=en cours 1=terminee
     */
    @Column(name = "ana_affaire_etat")
    private Integer anaAffaireEtat = 0;

    /**
     * nom agent
     */
    @Column(name = "ana_affaires_agent")
    private String anaAffairesAgent;

    /**
     * valeur theorique
     */
    @Column(name = "ana_affaire_theo")
    private Double anaAffaireTheo = 0D;

    /**
     * valeur relle
     */
    @Column(name = "ana_affaire_reel")
    private Double anaAffaireReel = 0D;

    /**
     * nom contact
     */
    @Column(name = "ana_affaires_conctact")
    private String anaAffairesConctact;

    /**
     * date premiere information
     */
    @Column(name = "ana_date_information")
    private LocalDate anaDateInformation;

    /**
     * date premier rendez vous
     */
    @Column(name = "ana_date_rdv")
    private LocalDate anaDateRdv;

    /**
     * cout affaire theorique
     */
    @Column(name = "ana_affaires_cout_theo")
    private Double anaAffairesCoutTheo = 0D;

    /**
     * cout affaire reel
     */
    @Column(name = "ana_affaires_cout_reel")
    private Double anaAffairesCoutReel = 0D;

}
