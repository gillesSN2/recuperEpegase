package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class VteChargementEnteteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long chamobId;


    /**
     * date de creation
     */
    private LocalDateTime chamobDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime chamobDateModif;


    /**
     * utilisateur de creation
     */
    private Long chamobUserCreat;


    /**
     * utilisateur de modification
     */
    private Long chamobUserModif;


    /**
     * date de chargement
     */
    private LocalDateTime chamobDate;


    /**
     * serie
     */
    private String chamobSerie;


    /**
     * numero de chargement
     */
    private String chamobNum;


    /**
     * nom du chauffeur
     */
    private String chamobNomChauffeur;


    /**
     * id du chauffeur
     */
    private Long chamobIdChauffeur;


    /**
     * code du parc
     */
    private String chamobParc;


    /**
     * code depot de chargement
     */
    private String chamobDepotCharg;


    /**
     * observations
     */
    private String chamobObs;


    /**
     * categorie de client
     */
    private String chamobCatClient;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer chamobEtatVal;


    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    private Integer chamobEtat;


    /**
     * date de validation
     */
    private LocalDate chamobDateValide;


    /**
     * date de transformation
     */
    private LocalDate chamobDateTransforme;


    /**
     * date annulation
     */
    private LocalDate chamobDateAnnule;


    /**
     * motif annulation
     */
    private String chamobMotifAnnule;


    /**
     * code budget
     */
    private String chamobBudget;


    /**
     * code activite
     */
    private String chamobActivite;


    /**
     * code site
     */
    private String chamobSite;


    /**
     * code departement
     */
    private String chamobDepartement;


    /**
     * code service
     */
    private String chamobService;


    /**
     * code region
     */
    private String chamobRegion;


    /**
     * code secteur
     */
    private String chamobSecteur;


    /**
     * code point de vente
     */
    private String chamobPdv;


    /**
     * code analytique 1
     */
    private String chamobAnal1;


    /**
     * code analytique 2
     */
    private String chamobAnal2;


    /**
     * code analytique 3
     */
    private String chamobAnal3;


    /**
     * code analytique 4
     */
    private String chamobAnal4;


    /**
     * nom utilisateur de creation
     */
    private String chamobNomUserCreat;


    /**
     * nom utilisateur de modification
     */
    private String chamobNomUserModif;


    /**
     * nom du responsable
     */
    private String chamobNomResponsable;


    /**
     * id du responsable
     */
    private Long chamobIdResponsable;


    /**
     * nom du commercial
     */
    private String chamobNomCommercial;


    /**
     * id du commercial
     */
    private Long chamobIdCommercial;


    /**
     * categorie du client
     */
    private String chamobCat;


    /**
     * observations
     */
    private String chamobObservation;


    /**
     * total ht
     */
    private Double chamobTotHt;


    /**
     * total remise
     */
    private Double chamobTotRemise;


    /**
     * total rabais
     */
    private Double chamobTotRabais;


    /**
     * ttal tva
     */
    private Double chamobTotTva;


    /**
     * taux taxe complementaire
     */
    private Float chamobTauxTc;


    /**
     * total taxe complementaire
     */
    private Double chamobTotTc;


    /**
     * total ttc
     */
    private Double chamobTotTtc;


    /**
     * total reglement
     */
    private Double chamobTotReglement;


    /**
     * 0=non solde 1=solde
     */
    private Integer chamobSolde;


    /**
     * date impression
     */
    private LocalDate chamobDateImp;


    /**
     * nom jasper du modele
     */
    private String chamobModeleImp;

    private Long exevteId;

    private Long usrId;


    /**
     * objet
     */
    private String chamobObjet;


    /**
     * total facture
     */
    private Double chamobTotFacture;


    /**
     * date derniere facture
     */
    private LocalDateTime chamobDateFacture;


    /**
     * date dernier reglement
     */
    private LocalDateTime chamobDateReglement;


    /**
     * nom equipe
     */
    private String chamobNomEquipe;


    /**
     * id equipe
     */
    private Long chamobIdEquipe;

}
