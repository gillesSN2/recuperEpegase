package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class VteCommissionEnteteQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long comId;


    /**
     * date de creation
     */
    private LocalDateTime comDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime comDateModif;


    /**
     * id user createur
     */
    private Long comIdCreateur;


    /**
     * nom du createur
     */
    private String comNomCreateur;


    /**
     * id user de modification
     */
    private Long comIdModif;


    /**
     * nom user de modification
     */
    private String comNomModif;


    /**
     * date debut du calcul
     */
    private LocalDateTime comDateDebut;


    /**
     * date fin du calcul
     */
    private LocalDateTime comDateFin;


    /**
     * numero commissions
     */
    private String comNum;


    /**
     * date commissions
     */
    private LocalDateTime comDate;


    /**
     * nom du commercial
     */
    private String comNomResponsable;


    /**
     * id du commercial
     */
    private Long comIdResponsable;


    /**
     * nom du commercial
     */
    private String comNomCommercial;


    /**
     * id du commercial
     */
    private Long comIdCommercial;


    /**
     * total commission
     */
    private Double comTotCommission;


    /**
     * total reglement
     */
    private Double comTotReglement;


    /**
     * 0=non solde 1=solde
     */
    private Integer comSolde;


    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/paye 4=bon encaissement
     */
    private Integer comTypeReg;


    /**
     * mode de reglement xml
     */
    private String comModeReg;


    /**
     * nombre de jour
     */
    private Integer comNbJourReg;


    /**
     * nombre de jour arrondi
     */
    private Integer comArrondiReg;


    /**
     * condition de reglement
     */
    private String comConditionReg;


    /**
     * date echeance de reglement
     */
    private LocalDate comDateEcheReg;


    /**
     * date dernier reglement
     */
    private LocalDate comDateLastReg;


    /**
     * code activite
     */
    private String comActivite;


    /**
     * code site
     */
    private String comSite;


    /**
     * code departement
     */
    private String comDepartement;


    /**
     * code service
     */
    private String comService;


    /**
     * code analytique 2
     */
    private String comAnal2;


    /**
     * code analytique 4
     */
    private String comAnal4;


    /**
     * date impression
     */
    private LocalDate comDateImp;


    /**
     * nom jasper du modele
     */
    private String comModeleImp;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer comEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer comGele;


    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    private Integer comEtat;


    /**
     * date de validite
     */
    private LocalDate comDateValidite;


    /**
     * date de validation
     */
    private LocalDate comDateValide;


    /**
     * date annulation
     */
    private LocalDate comDateAnnule;


    /**
     * motif annulation
     */
    private String comMotifAnnule;


    /**
     * date transfert en compta
     */
    private LocalDate comDateTransfert;

    private Long exevteId;

    private Long usrId;


    /**
     * nom du equipe
     */
    private String comNomEquipe;


    /**
     * id du equipe
     */
    private Long comIdEquipe;

}
