package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pay_salaries_contrats")
public class PaySalariesContrats implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "salcon_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salconId;

    /**
     * date de creation
     */
    @Column(name = "salcon_date_creat")
    private LocalDateTime salconDateCreat;

    /**
     * date de modification
     */
    @Column(name = "salcon_date_modif")
    private LocalDateTime salconDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "salcon_user_creat")
    private Long salconUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "salcon_user_modif")
    private Long salconUserModif = 0L;

    /**
     * numero du contrat
     */
    @Column(name = "salcon_num")
    private String salconNum;

    /**
     * 0=stage 1=cdd 2=cdi 3=prestataire
     */
    @Column(name = "salcon_type")
    private Integer salconType = 0;

    /**
     * numero de feuille de calcul
     */
    @Column(name = "salcon_feuille")
    private Integer salconFeuille = 0;

    /**
     * 0=actif 1=licencie 2=demissionne 3=decede 4=retraite 5=fin de contrat 6=arret ou suspension
     */
    @Column(name = "salcon_etat")
    private Integer salconEtat = 0;

    /**
     * 0=sans periode essai 1=avec periode essai
     */
    @Column(name = "salcon_essai")
    private Integer salconEssai = 0;

    /**
     * nb de mois essai
     */
    @Column(name = "salcon_nb_mois_essai")
    private Integer salconNbMoisEssai = 0;

    /**
     * fonction
     */
    @Column(name = "salcon_fonction")
    private String salconFonction;

    /**
     * imputation service
     */
    @Column(name = "salcon_site")
    private String salconSite;

    /**
     * imputation service
     */
    @Column(name = "salcon_departement")
    private String salconDepartement;

    /**
     * imputation service
     */
    @Column(name = "salcon_service")
    private String salconService;

    /**
     * date debut du contrat
     */
    @Column(name = "salcon_date_debut")
    private LocalDate salconDateDebut;

    /**
     * lieu de travail
     */
    @Column(name = "salcon_lieu_travail")
    private String salconLieuTravail;

    /**
     * code convention du salarie
     */
    @Column(name = "salcon_convention")
    private String salconConvention;

    /**
     * libelle convention du salarie
     */
    @Column(name = "salcon_lib_convention")
    private String salconLibConvention;

    /**
     * code centres impots xml
     */
    @Column(name = "salcon_centres_impots")
    private String salconCentresImpots;

    /**
     * libelle centres impots xml
     */
    @Column(name = "salcon_lib_centres_impots")
    private String salconLibCentresImpots;

    /**
     * code classement xml
     */
    @Column(name = "salcon_classement")
    private String salconClassement;

    /**
     * libelle classement xml
     */
    @Column(name = "salcon_lib_classement")
    private String salconLibClassement;

    /**
     * code niveau emploi xml
     */
    @Column(name = "salcon_niv_emploi")
    private String salconNivEmploi;

    /**
     * libelle niveau emploi xml
     */
    @Column(name = "salcon_lib_niv_emploi")
    private String salconLibNivEmploi;

    /**
     * code grille convention xml
     */
    @Column(name = "salcon_grille")
    private String salconGrille;

    /**
     * libelle grille convention xml
     */
    @Column(name = "salcon_lib_grille")
    private String salconLibGrille;

    /**
     * code activite
     */
    @Column(name = "salcon_activite")
    private String salconActivite;

    /**
     * libelle activite
     */
    @Column(name = "salcon_lib_activite")
    private String salconLibActivite;

    /**
     * code budget
     */
    @Column(name = "salcon_budget")
    private String salconBudget;

    /**
     * libelle budget
     */
    @Column(name = "salcon_lib_budget")
    private String salconLibBudget;

    /**
     * 0=sans 1=vehicule perso 2=vhicule societe
     */
    @Column(name = "salcon_vehicule")
    private Integer salconVehicule = 0;

    /**
     * montant de remboursement au kilometre
     */
    @Column(name = "salcon_rmb_kms")
    private Double salconRmbKms = 0D;

    /**
     * code parc
     */
    @Column(name = "salcon_parc")
    private String salconParc;

    /**
     * texte du contrat
     */
    @Column(name = "salcon_text")
    private String salconText;

    /**
     * date fin du contrat
     */
    @Column(name = "salcon_date_fin")
    private LocalDate salconDateFin;

    /**
     * motif de sortie
     */
    @Column(name = "salcon_motif_sortie")
    private String salconMotifSortie;

    /**
     * date remise pour signature
     */
    @Column(name = "salcon_date_remise")
    private LocalDate salconDateRemise;

    /**
     * date retour signature
     */
    @Column(name = "salcon_date_retour")
    private LocalDate salconDateRetour;

    /**
     * date confirmation depart
     */
    @Column(name = "salcon_date_confirmation")
    private LocalDate salconDateConfirmation;

    /**
     * id du represetant
     */
    @Column(name = "salcon_id_representant")
    private Long salconIdRepresentant;

    /**
     * nom et prenom du represetant
     */
    @Column(name = "salcon_nom_representant")
    private String salconNomRepresentant;

    /**
     * qualite du representant
     */
    @Column(name = "salcon_qualite")
    private String salconQualite;

    /**
     * 0= sans habilitation 1=avec habilitation
     */
    @Column(name = "salcon_etat_val")
    private Integer salconEtatVal = 0;

    /**
     * 0=non valide 1=valide
     */
    @Column(name = "salcon_etat_h")
    private Integer salconEtatH = 0;

    /**
     * date de validation
     */
    @Column(name = "salcon_date_valide")
    private LocalDateTime salconDateValide;

    /**
     * date impression
     */
    @Column(name = "salcon_date_imp")
    private LocalDateTime salconDateImp;

    @Column(name = "sal_id", nullable = false)
    private Long salId;

    /**
     * prime rendement
     */
    @Column(name = "salcon_prime_rendement")
    private Double salconPrimeRendement = 0D;

    /**
     * prime responsabilite
     */
    @Column(name = "salcon_prime_responsabilite")
    private Double salconPrimeResponsabilite = 0D;

    /**
     * fonction
     */
    @Column(name = "salcon_prime_fonction")
    private Double salconPrimeFonction = 0D;

    /**
     * indemnite caisse
     */
    @Column(name = "salcon_indemnite_caisse")
    private Double salconIndemniteCaisse = 0D;

    /**
     * indemnite transport
     */
    @Column(name = "salcon_indemnite_transport")
    private Double salconIndemniteTransport = 0D;

    /**
     * indemnite logement
     */
    @Column(name = "salcon_indemnite_logement")
    private Double salconIndemniteLogement = 0D;

    /**
     * avn logement
     */
    @Column(name = "salcon_avn_logement")
    private Double salconAvnLogement = 0D;

    /**
     * avn domesticite
     */
    @Column(name = "salcon_avn_domesticite")
    private Double salconAvnDomesticite = 0D;

    /**
     * avn telephone
     */
    @Column(name = "salcon_avn_telephone")
    private Double salconAvnTelephone = 0D;

    /**
     * avn eau
     */
    @Column(name = "salcon_avn_eau")
    private Double salconAvnEau = 0D;

    /**
     * avn electricite
     */
    @Column(name = "salcon_avn_electricite")
    private Double salconAvnElectricite = 0D;

    /**
     * avn nourriture
     */
    @Column(name = "salcon_avn_nourriture")
    private Double salconAvnNourriture = 0D;

    /**
     * avn vehicule
     */
    @Column(name = "salcon_avn_vehicule")
    private Double salconAvnVehicule = 0D;

    /**
     * regime de conges : nb jour de conges
     */
    @Column(name = "salcon_nb_jour_cp")
    private Float salconNbJourCp = 0F;

    /**
     * regime de conges : nb jour de travail
     */
    @Column(name = "salcon_nb_jour_tr")
    private Float salconNbJourTr = 0F;

    /**
     * cle de repartition 1
     */
    @Column(name = "salcon_cle1_anal")
    private String salconCle1Anal;

    /**
     * libelle cle de repartition 1
     */
    @Column(name = "salcon_lib_cle1_anal")
    private String salconLibCle1Anal;

    /**
     * cle de repartition 2
     */
    @Column(name = "salcon_cle2_anal")
    private String salconCle2Anal;

    /**
     * libelle cle de repartition 2
     */
    @Column(name = "salcon_lib_cle2_anal")
    private String salconLibCle2Anal;

    /**
     * sursalaire
     */
    @Column(name = "salcon_sursalaire")
    private Double salconSursalaire = 0D;

    /**
     * indemnite deplacement
     */
    @Column(name = "salcon_indemnite_deplacement")
    private Double salconIndemniteDeplacement = 0D;

    /**
     * indemnite kilometrique
     */
    @Column(name = "salcon_indemnite_kilometrique")
    private Double salconIndemniteKilometrique = 0D;

    /**
     * indemnite salissure
     */
    @Column(name = "salcon_indemnite_salissure")
    private Double salconIndemniteSalissure = 0D;

    /**
     * code projet
     */
    @Column(name = "salcon_projet")
    private String salconProjet;

    /**
     * libelle projet
     */
    @Column(name = "salcon_lib_projet")
    private String salconLibProjet;

    /**
     * salaire de base
     */
    @Column(name = "salcon_base")
    private Double salconBase = 0D;

    /**
     * prime sujetion
     */
    @Column(name = "salcon_prime_sujetion")
    private Double salconPrimeSujetion = 0D;

    /**
     * indemnite representation
     */
    @Column(name = "salcon_indemnite_representation")
    private Double salconIndemniteRepresentation = 0D;

    /**
     * forfait heure supplementaire
     */
    @Column(name = "salcon_forfait_sup")
    private Double salconForfaitSup = 0D;

    /**
     * prime outillage
     */
    @Column(name = "salcon_prime_outillage")
    private Double salconPrimeOutillage = 0D;

    /**
     * prime astreinte
     */
    @Column(name = "salcon_prime_astreinte")
    private Double salconPrimeAstreinte = 0D;

    /**
     * id du tiers pour interim
     */
    @Column(name = "salcon_id_tiers")
    private Long salconIdTiers = 0L;

    /**
     * nom tiers pour interim
     */
    @Column(name = "salcon_nom_tiers")
    private String salconNomTiers;

}
