package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PrcParcConsommationDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long prcconId;


    /**
     * date de creation
     */
    private LocalDateTime prcconDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime prcconDateModif;


    /**
     * id user createur
     */
    private Long prcconIdCreateur;


    /**
     * nom du createur
     */
    private String prcconNomCreateur;


    /**
     * id user de modification
     */
    private Long prcconIdModif;


    /**
     * nom user de modification
     */
    private String prcconNomModif;


    /**
     * date consommation
     */
    private LocalDateTime prcconDate;


    /**
     * numero bon
     */
    private String prcconNum;


    /**
     * nom du pompiste
     */
    private String prcconNomPompiste;


    /**
     * id du pompiste
     */
    private Long prcconIdPompiste;


    /**
     * nom du demandeur
     */
    private String prcconNomDemandeur;


    /**
     * id du demandeur
     */
    private Long prcconIdDemandeur;


    /**
     * serie
     */
    private String prcconSerie;


    /**
     * 0=carburant 1=lubrifiant
     */
    private Integer prcconType;


    /**
     * depot inventorie
     */
    private String prcconDepot;


    /**
     * code produit
     */
    private String prcconCode;


    /**
     * libelle produit
     */
    private String prcconLibelle;


    /**
     * quantite consommee
     */
    private Float prcconQte;


    /**
     * prix unitaire
     */
    private Double prcconPu;


    /**
     * total ttc
     */
    private Double prcconTotal;


    /**
     * code activite
     */
    private String prcconActivite;


    /**
     * code site
     */
    private String prcconSite;


    /**
     * code departement
     */
    private String prcconDepartement;


    /**
     * code service
     */
    private String prcconService;


    /**
     * code region
     */
    private String prcconRegion;


    /**
     * code secteur
     */
    private String prcconSecteur;


    /**
     * code point de vente
     */
    private String prcconPdv;


    /**
     * code analytique 2
     */
    private String prcconAnal2;


    /**
     * code analytique 4
     */
    private String prcconAnal4;


    /**
     * date impression
     */
    private LocalDate prcconDateImp;


    /**
     * nom jasper du modele
     */
    private String prcconModeleImp;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer prcconEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer prcconGele;


    /**
     * 0=En cours 1=valide 2=gele 3=annule
     */
    private Integer prcconEtat;


    /**
     * date de validation
     */
    private LocalDate prcconDateValide;


    /**
     * date annulation
     */
    private LocalDate prcconDateAnnule;


    /**
     * motif annulation
     */
    private String prcconMotifAnnule;


    /**
     * releve du compteur
     */
    private Long prcconCompteur;


    /**
     * 0=distance 1=kilometrique 2=horaire
     */
    private Integer prcconTypeCompteur;

    private Long exeprcId;

    private Long prcId;


    /**
     * poids net
     */
    private Float prcconPoidsnet;


    /**
     * poids brut
     */
    private Float prcconPoidsbrut;

}
