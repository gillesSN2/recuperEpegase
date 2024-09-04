package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AchValorisationEnteteQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long valId;


    /**
     * date de creation
     */
    private LocalDateTime valDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime valDateModif;


    /**
     * id user createur
     */
    private Long valIdCreateur;


    /**
     * nom du createur
     */
    private String valNomCreateur;


    /**
     * id user de modification
     */
    private Long valIdModif;


    /**
     * nom user de modification
     */
    private String valNomModif;


    /**
     * date valorisation
     */
    private LocalDateTime valDate;


    /**
     * numero valorisation
     */
    private String valNum;


    /**
     * serie
     */
    private String valSerie;


    /**
     * site
     */
    private String valSite;


    /**
     * departement
     */
    private String valDepartement;


    /**
     * service
     */
    private String valService;


    /**
     * region
     */
    private String valRegion;


    /**
     * secteur
     */
    private String valSecteur;


    /**
     * point de vente
     */
    private String valPdv;


    /**
     * nature (12=commande, 13=reception)
     */
    private Integer valNature1;


    /**
     * nature (47=reexpedition)
     */
    private Integer valNature2;


    /**
     * nom du commercial
     */
    private String valNomResponsable;


    /**
     * id du commercial
     */
    private Long valIdResponsable;


    /**
     * total commande
     */
    private Double valTotalCommande;


    /**
     * total reception
     */
    private Double valTotalReception;


    /**
     * total retour
     */
    private Double valTotalRetour;


    /**
     * total note de debit
     */
    private Double valTotalNoteDebit;


    /**
     * total rexpedition
     */
    private Double valTotalRexpedition;


    /**
     * total frais 1
     */
    private Double valTotalFrais1;


    /**
     * total frais 2
     */
    private Double valTotalFrais2;


    /**
     * prix de revient 1
     */
    private Double valPr1;


    /**
     * prix de revient 2
     */
    private Double valPr2;


    /**
     * coefficient 1
     */
    private Float valCoef1;


    /**
     * coefficient 2
     */
    private Float valCoef2;


    /**
     * 0=calcul valeur 1=calcul poids
     */
    private Integer valCalcul;


    /**
     * objet de la valorisation
     */
    private String valObjet;


    /**
     * numero dossier transit
     */
    private String valDossierTransit;


    /**
     * date intention
     */
    private LocalDate valDateIntention;


    /**
     * date peremption intention
     */
    private LocalDate valDateIntentionFin;


    /**
     * reference credoc
     */
    private String valRefCredoc;


    /**
     * nom du bateau
     */
    private String valNomBateau;


    /**
     * port de chargement
     */
    private String valPortChargement;


    /**
     * date de chargement
     */
    private LocalDate valDateChargement;


    /**
     * port de dechargement
     */
    private String valPortDechargement;


    /**
     * date de dechargement
     */
    private LocalDate valDateDechargement;


    /**
     * bureau de douane
     */
    private String valBureauDouane;


    /**
     * date arrivee
     */
    private LocalDate valDateArrivee;


    /**
     * numero manifeste
     */
    private String valManifeste;


    /**
     * total frais expert
     */
    private Double valTotalExpert;


    /**
     * total valeur de reference
     */
    private Double valTotalReference;


    /**
     * nom banque
     */
    private String valBanque;


    /**
     * poids brut
     */
    private Float valPoidsBrut;


    /**
     * poids net
     */
    private Float valPoidsNet;


    /**
     * unite de conversion
     */
    private Integer valPoidsUnite;


    /**
     * nombre unite
     */
    private Integer valNbColis;


    /**
     * nombre contener
     */
    private Integer valNbContener;


    /**
     * nombre camion
     */
    private Integer valNbCamion;


    /**
     * nombre wagon
     */
    private Integer valNbWagon;


    /**
     * date impression
     */
    private LocalDate valDateImp;


    /**
     * modele impression
     */
    private String valModeleImp;


    /**
     * 0=sans validation 1=avecc validation
     */
    private Integer valEtatVal;


    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    private Integer valEtat;


    /**
     * date de validation
     */
    private LocalDate valDateValide;


    /**
     * total fob
     */
    private Double valTotalFob;


    /**
     * total divers
     */
    private Double valTotalDivers;


    /**
     * total fret
     */
    private Double valTotalFret;


    /**
     * total assurance theorique
     */
    private Double valTotalAssuranceTheo;


    /**
     * total assurance reelle
     */
    private Double valTotalAssuranceReelle;


    /**
     * total douane theorique
     */
    private Double valTotalDouaneTheo;


    /**
     * total douane relle
     */
    private Double valTotalDouaneReelle;


    /**
     * total tva douane theorique
     */
    private Double valTotalTvaDouaneTheo;


    /**
     * total tva douane reelle
     */
    private Double valTotalTvaDouaneReelle;


    /**
     * total douane theorique
     */
    private Double valTotalTransit;


    /**
     * total debours
     */
    private Double valTotalDebours;


    /**
     * 0=normal 1=fictif
     */
    private Integer valFictif;


    /**
     * 0=pr au poids 1=pr au prix achat
     */
    private Integer valCalculPr;


    /**
     * true = exonere de tva
     */
    private Boolean valExoTva;


    /**
     * true = exonere de douane
     */
    private Boolean valExoDouane;


    /**
     * id assureur
     */
    private Long valIdAssureur;


    /**
     * nom assureur
     */
    private String valNomAssureur;


    /**
     * id transitaire
     */
    private Long valIdTransitaire;


    /**
     * nom transitaire
     */
    private String valNomTransitaire;


    /**
     * id transporteur
     */
    private Long valIdTransporteur;


    /**
     * nom transporteur
     */
    private String valNomTransporteur;


    /**
     * coefficient utilise par la douane
     */
    private Float valCoefDeviseDouane;


    /**
     * lta
     */
    private String valLta;


    /**
     * 0=maritime 1=avion 2=express 3=route
     */
    private Integer valMode;


    /**
     * dpi
     */
    private String valDpi;

    private Long exeachId;

    private Long usrId;


    /**
     * devise
     */
    private String valDevise;


    /**
     * id banque
     */
    private Long valIdBanque;


    /**
     * nb virement
     */
    private Integer valNbVirement;


    /**
     * total frais financier theorique
     */
    private Double valTotalFinancierTheo;


    /**
     * total frais financier reelle
     */
    private Double valTotalFinancierReelle;


    /**
     * date transfert en compta
     */
    private LocalDate valDateTransfert;


    /**
     * coefficient du forfait transport utile que pour le mali
     */
    private Float valCoefForfaitTransport;


    /**
     * forfait transport utile que pour le mali
     */
    private Double valForfaitTransport;


    /**
     * numero de transfert
     */
    private String valNumTrf;


    /**
     * prix de revient 1 ttc
     */
    private Double valPr1Ttc;


    /**
     * numero declaration
     */
    private String valDeclaration;


    /**
     * valeur declaration en douane
     */
    private Double valValeurDouane;

}
