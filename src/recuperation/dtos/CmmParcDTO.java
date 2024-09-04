package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CmmParcDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long prcId;


    /**
     * date creation
     */
    private LocalDateTime prcDateCreat;


    /**
     * date modification
     */
    private LocalDateTime prcDateModif;


    /**
     * id user de creation
     */
    private Long prcUserCreat;


    /**
     * id user de modification
     */
    private Long prcUserModif;


    /**
     * immatriculation
     */
    private String prcImmatriculation;


    /**
     * libelle du parc en francais
     */
    private String prcNomFr;


    /**
     * libelle du parc en anglais
     */
    private String prcNomUk;


    /**
     * libelle du parc en espagnol
     */
    private String prcNomSp;


    /**
     * 0=actif 1=inactif
     */
    private Integer prcInactif;


    /**
     * code immobilisation comptable
     */
    private Integer prcImmobilisation;


    /**
     * id immobilisation comptable
     */
    private Long prcIdImmobilisation;


    /**
     * nom de la photo
     */
    private String prcPhoto;


    /**
     * voir fichier xml
     */
    private Integer prcNature;


    /**
     * libelle nature
     */
    private String prcLibNature;


    /**
     * code famille
     */
    private String prcFamille;


    /**
     * libelle famille
     */
    private String prcLibFamille;


    /**
     * code sous famille
     */
    private String prcSousFamille;


    /**
     * libelle sous famille
     */
    private String prcLibSousFamille;


    /**
     * marque
     */
    private String prcMarque;


    /**
     * numero chassis ou de serie
     */
    private String prcChassis;


    /**
     * numero moteur
     */
    private String prcMoteur;


    /**
     * numero arrangement
     */
    private String prcArrangement;


    /**
     * date achat
     */
    private LocalDate prcDateAchat;


    /**
     * periode anniversaire JJ:MM par rapport a la date achat
     */
    private String prcAnniversaire;


    /**
     * annee fabrication
     */
    private Integer prcAnneeFab;


    /**
     * prix achat
     */
    private Double prcPrixAchat;


    /**
     * prix revient
     */
    private Double prcPrixRevient;


    /**
     * prix vente ou location
     */
    private Double prcPrixVente;


    /**
     * date mise en service
     */
    private LocalDate prcDateMes;


    /**
     * prix argus
     */
    private Double prcPrixArgus;


    /**
     * date de sortie
     */
    private LocalDate prcDateSortie;


    /**
     * prix cession
     */
    private Double prcPrixCession;


    /**
     * 0=en cours 1=cession 2=rebut
     */
    private Integer prcEtat;


    /**
     * 0=en arret 1=en fonction 2=en panne
     */
    private Integer prcFonction;


    /**
     * nom lieu actuel (mission ou garage)
     */
    private String prcLieu;


    /**
     * description panne (si panne)
     */
    private String prcPanne;


    /**
     * 0=interne 1=externe 2=fabrique
     */
    private Integer prcOrigine;


    /**
     * puissance fiscale
     */
    private Float prcPuisFiscale;


    /**
     * puissance en chevaux
     */
    private Float prcPuisChev;


    /**
     * consommation moyenne au 100 km
     */
    private Float prcConsommation;


    /**
     * consommation litre par km
     */
    private Float prcCote;


    /**
     * 0=distance 1=kilometrique 2=horaire
     */
    private Integer prcCompteur;


    /**
     * 0=essence 1=gazoil 2=gpl 3=electique 4=hybride 5=kerosene 6=solaire
     */
    private Integer prcAlimentation;


    /**
     * amperage
     */
    private Float prcAmpere;


    /**
     * voltage
     */
    private Float prcVolt;


    /**
     * 0=ordinaire 1=super 98 2=super 99 3=jet a1
     */
    private Integer prcEssence;


    /**
     * matricule salarie
     */
    private String prcMatSalarie;


    /**
     * nom salarie
     */
    private String prcNomSalarie;


    /**
     * prenom salarie
     */
    private String prcPrenomSalarie;


    /**
     * code service
     */
    private String prcService;


    /**
     * libelle service
     */
    private String prcLibService;


    /**
     * 0=sans alerte 1=alerte par mail
     */
    private Integer prcAlerte;


    /**
     * mail pour alerte
     */
    private String prcMailAlerte;


    /**
     * id tiers si garage
     */
    private Long prcIdTiers;


    /**
     * raison sociale tiers si garage
     */
    private String prcNomTiers;


    /**
     * adresse du tiers
     */
    private String prcAdresse;


    /**
     * telephone du tiers
     */
    private String prcTel;


    /**
     * ville du tiers
     */
    private String prcVille;


    /**
     * contact du tiers
     */
    private String prcContact;

}
