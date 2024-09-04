package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CaiTraiteEnteteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long trtId;


    /**
     * date de creation
     */
    private LocalDateTime trtDateCreat;


    /**
     * user de creation
     */
    private Long trtUserCreat;


    /**
     * date de modification
     */
    private LocalDateTime trtDateModif;


    /**
     * user de creation
     */
    private Long trtUserModif;


    /**
     * 65=traite domiciliee 66=traite en portfeuille 67=traite entreprise
     */
    private Integer trtNature;


    /**
     * numero de la traite
     */
    private String trtNum;


    /**
     * date debut
     */
    private LocalDate trtDateDebut;


    /**
     * date contrat
     */
    private LocalDate trtDateContrat;


    /**
     * duree en nb mois
     */
    private Integer trtDuree;


    /**
     * periodicite
     */
    private Integer trtPeriodicite;


    /**
     * nom du responsable
     */
    private String trtNomResponsable;


    /**
     * id du responsable
     */
    private Long trtIdResponsable;


    /**
     * 0=client 1=fournisseur
     */
    private Integer trtTypeTiers;


    /**
     * nom du tiers
     */
    private String trtNomTiers;


    /**
     * id du tiers
     */
    private Long trtIdTiers;


    /**
     * devise
     */
    private String trtDevise;


    /**
     * montant
     */
    private Double trtMontant;


    /**
     * nb de mois general
     */
    private Integer trtNbMoisEcheanceGene;


    /**
     * montant general
     */
    private Double trtMontantGene;


    /**
     * montant final
     */
    private Double trtMontantFinal;


    /**
     * total reglement
     */
    private Double trtTotalReglement;


    /**
     * objet
     */
    private String trtObjet;


    /**
     * facture concernee
     */
    private String trtFacture;


    /**
     * banque
     */
    private String trtBanque;


    /**
     * activite
     */
    private String trtActivite;


    /**
     * site
     */
    private String trtSite;


    /**
     * departement
     */
    private String trtDepartement;


    /**
     * service
     */
    private String trtService;


    /**
     * region
     */
    private String trtRegion;


    /**
     * secteur
     */
    private String trtSecteur;


    /**
     * pdv
     */
    private String trtPdv;


    /**
     * budget
     */
    private String trtBudget;


    /**
     * dossier
     */
    private String trtDossier;


    /**
     * 0=en 1=valide 2=gele 3=annule 4=execute
     */
    private Integer trtEtat;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer trtEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer trtGele;


    /**
     * date de validation
     */
    private LocalDate trtDateValide;


    /**
     * modele impression recu
     */
    private String trtModeleImp;


    /**
     * date impression recu
     */
    private LocalDateTime trtDateImpression;

    private Long execaiId;


    /**
     * id banque
     */
    private Long trtIdBanque;

}
