package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class CptEcrituresAnalytiquesQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long ecranaId;


    /**
     * id origine de la table origine (pour les transferts)
     */
    private Long ecranaIdOrigine;


    /**
     * AM = amortissement LO=loyer FV=facture vente FA=facture fournisseur (pour les transferts)
     */
    private String ecranaTypeOrigine;


    /**
     * nature axe analytique
     */
    private Integer ecranaAxe;


    /**
     * cle analytique
     */
    private String ecranaCle;


    /**
     * ordre
     */
    private Long ecranaOrdre;


    /**
     * code journal
     */
    private String ecranaCode;


    /**
     * date de saisie
     */
    private LocalDate ecranaDateSaisie;


    /**
     * periode
     */
    private String ecranaPeriode;


    /**
     * nature du compte
     */
    private Integer ecranaNature;


    /**
     * compte general
     */
    private String ecranaCompte;


    /**
     * cle 1
     */
    private String ecranaCle1;


    /**
     * cle 2
     */
    private String ecranaCle2;


    /**
     * classe du compte
     */
    private String ecranaClasse;


    /**
     * montant saisie
     */
    private Double ecranaMontantSaisie;


    /**
     * libelle
     */
    private String ecranaLibelle;


    /**
     * piece
     */
    private String ecranaPiece;


    /**
     * ref 1
     */
    private String ecranaReference1;


    /**
     * ref 2
     */
    private String ecranaReference2;


    /**
     * site
     */
    private String ecranaSite;


    /**
     * libelle site
     */
    private String ecranaSiteLib;


    /**
     * site taux repartition
     */
    private Float ecranaSiteTaux;


    /**
     * site montant
     */
    private Double ecranaSiteMontant;


    /**
     * site visible
     */
    private Boolean ecranaSiteVisible;


    /**
     * departement
     */
    private String ecranaDepartement;


    /**
     * libelle departement
     */
    private String ecranaDepartementLib;


    /**
     * departement taux repartition
     */
    private Float ecranaDepartementTaux;


    /**
     * departement montant
     */
    private Double ecranaDepartementMontant;


    /**
     * departement visible
     */
    private Boolean ecranaDepartementVisible;


    /**
     * service
     */
    private String ecranaService;


    /**
     * libelle service
     */
    private String ecranaServiceLib;


    /**
     * service taux repartition
     */
    private Float ecranaServiceTaux;


    /**
     * service montant
     */
    private Double ecranaServiceMontant;


    /**
     * service visible
     */
    private Boolean ecranaServiceVisible;


    /**
     * region
     */
    private String ecranaRegion;


    /**
     * libelle region
     */
    private String ecranaRegionLib;


    /**
     * region taux repartition
     */
    private Float ecranaRegionTaux;


    /**
     * region montant
     */
    private Double ecranaRegionMontant;


    /**
     * region visible
     */
    private Boolean ecranaRegionVisible;


    /**
     * secteur
     */
    private String ecranaSecteur;


    /**
     * libelle secteur
     */
    private String ecranaSecteurLib;


    /**
     * secteur taux repartition
     */
    private Float ecranaSecteurTaux;


    /**
     * secteur montant
     */
    private Double ecranaSecteurMontant;


    /**
     * secteur visible
     */
    private Boolean ecranaSecteurVisible;


    /**
     * point de vente
     */
    private String ecranaPdv;


    /**
     * libelle point de vente
     */
    private String ecranaPdvLib;


    /**
     * pdv taux repartition
     */
    private Float ecranaPdvTaux;


    /**
     * pdv montant
     */
    private Double ecranaPdvMontant;


    /**
     * pdv visible
     */
    private Boolean ecranaPdvVisible;


    /**
     * ligne
     */
    private String ecranaLigne;


    /**
     * libelle ligne
     */
    private String ecranaLigneLib;


    /**
     * ligne taux repartition
     */
    private Float ecranaLigneTaux;


    /**
     * ligne montant
     */
    private Double ecranaLigneMontant;


    /**
     * ligne visible
     */
    private Boolean ecranaLigneVisible;


    /**
     * atelier
     */
    private String ecranaAtelier;


    /**
     * libelle atelier
     */
    private String ecranaAtelierLib;


    /**
     * atelier taux repartition
     */
    private Float ecranaAtelierTaux;


    /**
     * atelier montant
     */
    private Double ecranaAtelierMontant;


    /**
     * atelier visible
     */
    private Boolean ecranaAtelierVisible;


    /**
     * activite
     */
    private String ecranaActivite;


    /**
     * libelle activite
     */
    private String ecranaActiviteLib;


    /**
     * activite taux repartition
     */
    private Float ecranaActiviteTaux;


    /**
     * activite montant
     */
    private Double ecranaActiviteMontant;


    /**
     * activite visible
     */
    private Boolean ecranaActiviteVisible;


    /**
     * projet
     */
    private String ecranaProjet;


    /**
     * libelle projet
     */
    private String ecranaProjetLib;


    /**
     * projet taux repartition
     */
    private Float ecranaProjetTaux;


    /**
     * projet montant
     */
    private Double ecranaProjetMontant;


    /**
     * projet visible
     */
    private Boolean ecranaProjetVisible;


    /**
     * analytique 1
     */
    private String ecranaAnal1;


    /**
     * libelle analytique 1
     */
    private String ecranaAnal1Lib;


    /**
     * anal1 taux repartition
     */
    private Float ecranaAnal1Taux;


    /**
     * anal1 montant
     */
    private Double ecranaAnal1Montant;


    /**
     * anal1 visible
     */
    private Boolean ecranaAnal1Visible;


    /**
     * analytique 2
     */
    private String ecranaAnal2;


    /**
     * libelle analytique 2
     */
    private String ecranaAnal2Lib;


    /**
     * anal2 (parc) taux repartition
     */
    private Float ecranaAnal2Taux;


    /**
     * anal2 montant
     */
    private Double ecranaAnal2Montant;


    /**
     * anal2 visible
     */
    private Boolean ecranaAnal2Visible;


    /**
     * analytique 3
     */
    private String ecranaAnal3;


    /**
     * libelle analytique 3
     */
    private String ecranaAnal3Lib;


    /**
     * anal3 (agent) taux repartition
     */
    private Float ecranaAnal3Taux;


    /**
     * anal3 montant
     */
    private Double ecranaAnal3Montant;


    /**
     * anal3 visible
     */
    private Boolean ecranaAnal3Visible;


    /**
     * analytique 4
     */
    private String ecranaAnal4;


    /**
     * libelle analytique 4
     */
    private String ecranaAnal4Lib;


    /**
     * anal4 (dossier) taux repartition
     */
    private Float ecranaAnal4Taux;


    /**
     * anal4 montant
     */
    private Double ecranaAnal4Montant;


    /**
     * anal4 visible
     */
    private Boolean ecranaAnal4Visible;


    /**
     * nature jurnal
     */
    private Integer ecranaNatureJrx;


    /**
     * 0=public 1=prive
     */
    private Integer ecranaReserve;


    /**
     * cle de repartition
     */
    private Float ecranaPourcentage;

    private Long ecrId;


    /**
     * sens 0=debit 1=credit
     */
    private Integer ecranaSens;

}
