package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CptBrouillardQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long broId;


    /**
     * id origine de la table origine (pour les transferts)
     */
    private Long broIdOrigine;


    /**
     * AM = amortissement LO=loyer VE=facture vente AC=facture fournisseur (pour les transferts)
     */
    private String broTypeOrigine;


    /**
     * date de creation de l ecriture
     */
    private LocalDateTime broDateCreat;


    /**
     * date de modification de l ecriture
     */
    private LocalDateTime broDateModif;


    /**
     * utilisateur de creation de l ecriture
     */
    private Long broUserCreat;


    /**
     * utilisateur de modification de l ecriture
     */
    private Long broUserModif;


    /**
     * code journal table planJournauxComptables
     */
    private String broCode;


    /**
     * date de saisie
     */
    private LocalDate broDateSaisie;


    /**
     * MM:AAAA par rapport aÃ‚Â  la date de saisie
     */
    private String broPeriode;


    /**
     * partie jour de la date de saisie
     */
    private Integer broJour;


    /**
     * partie annee de la date de saisie
     */
    private String broAnnee;


    /**
     * devise de saisie
     */
    private String broDeviseSaisie;


    /**
     * montant credit dans la devise de saisie
     */
    private Double broDebitSaisie;


    /**
     * montant credit dans la devise de saisie
     */
    private Double broCreditSaisie;


    /**
     * coef de conversion en euro
     */
    private Float broCoefEuro;


    /**
     * montant credit en euro
     */
    private Double broDebitEuro;


    /**
     * montant credit en euro
     */
    private Double broCreditEuro;


    /**
     * devise du pays
     */
    private String broDevisePays;


    /**
     * coef de conversion dans la devise du pays
     */
    private Float broCoefPays;


    /**
     * montant credit dans la devise du pays
     */
    private Double broDebitPays;


    /**
     * montant credit dans la devise du pays
     */
    private Double broCreditPays;


    /**
     * devise du groupe
     */
    private String broDeviseGrp;


    /**
     * coef de conversion dans la devise du groupe
     */
    private Float broCoefGrp;


    /**
     * montant credit dans la devise du groupe
     */
    private Double broDebitGrp;


    /**
     * montant credit dans la devise du groupe
     */
    private Double broCreditGrp;


    /**
     * 0=en cours 1=cloture mensuelle 2=cloture annuelle
     */
    private Integer broCloture;


    /**
     * 0=en cours 1=valide 2=transfere
     */
    private Integer broEtat;


    /**
     * libelle de l ecriture
     */
    private String broLibelle;


    /**
     * numero de piece comptable
     */
    private String broPiece;


    /**
     * numero de brouillard
     */
    private Long broNum;


    /**
     * reference 1
     */
    private String broReference1;


    /**
     * reference 2
     */
    private String broReference2;


    /**
     * = nautre des journaux
     */
    private Integer broNatureJrx;

    private Long execptId;


    /**
     * numero de transfert
     */
    private String broNumTrf;

}
