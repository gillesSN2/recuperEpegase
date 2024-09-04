package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotNull")};
        {stringHelper.

getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotBlank")};{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotEmpty")};


@Data
public class PaySalariesContratsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "salconId can not null")
    private Long salconId;


    /**
     * date de creation
     */
    private LocalDateTime salconDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime salconDateModif;


    /**
     * utilisateur de creation
     */
    private Long salconUserCreat;


    /**
     * utilisateur de modification
     */
    private Long salconUserModif;


    /**
     * numero du contrat
     */
    private String salconNum;


    /**
     * 0=stage 1=cdd 2=cdi 3=prestataire
     */
    private Integer salconType;


    /**
     * numero de feuille de calcul
     */
    private Integer salconFeuille;


    /**
     * 0=actif 1=licencie 2=demissionne 3=decede 4=retraite 5=fin de contrat 6=arret ou suspension
     */
    private Integer salconEtat;


    /**
     * 0=sans periode essai 1=avec periode essai
     */
    private Integer salconEssai;


    /**
     * nb de mois essai
     */
    private Integer salconNbMoisEssai;


    /**
     * fonction
     */
    private String salconFonction;


    /**
     * imputation service
     */
    private String salconSite;


    /**
     * imputation service
     */
    private String salconDepartement;


    /**
     * imputation service
     */
    private String salconService;


    /**
     * date debut du contrat
     */
    private LocalDate salconDateDebut;


    /**
     * lieu de travail
     */
    private String salconLieuTravail;


    /**
     * code convention du salarie
     */
    private String salconConvention;


    /**
     * libelle convention du salarie
     */
    private String salconLibConvention;


    /**
     * code centres impots xml
     */
    private String salconCentresImpots;


    /**
     * libelle centres impots xml
     */
    private String salconLibCentresImpots;


    /**
     * code classement xml
     */
    private String salconClassement;


    /**
     * libelle classement xml
     */
    private String salconLibClassement;


    /**
     * code niveau emploi xml
     */
    private String salconNivEmploi;


    /**
     * libelle niveau emploi xml
     */
    private String salconLibNivEmploi;


    /**
     * code grille convention xml
     */
    private String salconGrille;


    /**
     * libelle grille convention xml
     */
    private String salconLibGrille;


    /**
     * code activite
     */
    private String salconActivite;


    /**
     * libelle activite
     */
    private String salconLibActivite;


    /**
     * code budget
     */
    private String salconBudget;


    /**
     * libelle budget
     */
    private String salconLibBudget;


    /**
     * 0=sans 1=vehicule perso 2=vhicule societe
     */
    private Integer salconVehicule;


    /**
     * montant de remboursement au kilometre
     */
    private Double salconRmbKms;


    /**
     * code parc
     */
    private String salconParc;


    /**
     * texte du contrat
     */
    private String salconText;


    /**
     * date fin du contrat
     */
    private LocalDate salconDateFin;


    /**
     * motif de sortie
     */
    private String salconMotifSortie;


    /**
     * date remise pour signature
     */
    private LocalDate salconDateRemise;


    /**
     * date retour signature
     */
    private LocalDate salconDateRetour;


    /**
     * date confirmation depart
     */
    private LocalDate salconDateConfirmation;


    /**
     * id du represetant
     */
    private Long salconIdRepresentant;


    /**
     * nom et prenom du represetant
     */
    private String salconNomRepresentant;


    /**
     * qualite du representant
     */
    private String salconQualite;


    /**
     * 0= sans habilitation 1=avec habilitation
     */
    private Integer salconEtatVal;


    /**
     * 0=non valide 1=valide
     */
    private Integer salconEtatH;


    /**
     * date de validation
     */
    private LocalDateTime salconDateValide;


    /**
     * date impression
     */
    private LocalDateTime salconDateImp;

    @NotNull(message = "salId can not null")
    private Long salId;


    /**
     * prime rendement
     */
    private Double salconPrimeRendement;


    /**
     * prime responsabilite
     */
    private Double salconPrimeResponsabilite;


    /**
     * fonction
     */
    private Double salconPrimeFonction;


    /**
     * indemnite caisse
     */
    private Double salconIndemniteCaisse;


    /**
     * indemnite transport
     */
    private Double salconIndemniteTransport;


    /**
     * indemnite logement
     */
    private Double salconIndemniteLogement;


    /**
     * avn logement
     */
    private Double salconAvnLogement;


    /**
     * avn domesticite
     */
    private Double salconAvnDomesticite;


    /**
     * avn telephone
     */
    private Double salconAvnTelephone;


    /**
     * avn eau
     */
    private Double salconAvnEau;


    /**
     * avn electricite
     */
    private Double salconAvnElectricite;


    /**
     * avn nourriture
     */
    private Double salconAvnNourriture;


    /**
     * avn vehicule
     */
    private Double salconAvnVehicule;


    /**
     * regime de conges : nb jour de conges
     */
    private Float salconNbJourCp;


    /**
     * regime de conges : nb jour de travail
     */
    private Float salconNbJourTr;


    /**
     * cle de repartition 1
     */
    private String salconCle1Anal;


    /**
     * libelle cle de repartition 1
     */
    private String salconLibCle1Anal;


    /**
     * cle de repartition 2
     */
    private String salconCle2Anal;


    /**
     * libelle cle de repartition 2
     */
    private String salconLibCle2Anal;


    /**
     * sursalaire
     */
    private Double salconSursalaire;


    /**
     * indemnite deplacement
     */
    private Double salconIndemniteDeplacement;


    /**
     * indemnite kilometrique
     */
    private Double salconIndemniteKilometrique;


    /**
     * indemnite salissure
     */
    private Double salconIndemniteSalissure;


    /**
     * code projet
     */
    private String salconProjet;


    /**
     * libelle projet
     */
    private String salconLibProjet;


    /**
     * salaire de base
     */
    private Double salconBase;


    /**
     * prime sujetion
     */
    private Double salconPrimeSujetion;


    /**
     * indemnite representation
     */
    private Double salconIndemniteRepresentation;


    /**
     * forfait heure supplementaire
     */
    private Double salconForfaitSup;


    /**
     * prime outillage
     */
    private Double salconPrimeOutillage;


    /**
     * prime astreinte
     */
    private Double salconPrimeAstreinte;


    /**
     * id du tiers pour interim
     */
    private Long salconIdTiers;


    /**
     * nom tiers pour interim
     */
    private String salconNomTiers;

}
