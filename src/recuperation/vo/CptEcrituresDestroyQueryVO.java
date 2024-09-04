package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CptEcrituresDestroyQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long ecrId;


    /**
     * id origine de la table origine (pour les transferts)
     */
    private Long ecrIdOrigine;


    /**
     * AM = amortissement LO=loyer FV=facture vente FA=facture fournisseur (pour les transferts)
     */
    private String ecrTypeOrigine;


    /**
     * concatenation ecr_code:ecr_periode
     */
    private String ecrCle1;


    /**
     * concatenation ecr_code:ecr_date
     */
    private String ecrCle2;


    /**
     * date de creation ecriture
     */
    private LocalDateTime ecrDateCreat;


    /**
     * date de modification ecriture
     */
    private LocalDateTime ecrDateModif;


    /**
     * utilisateur de creation ecriture
     */
    private Long ecrUserCreat;


    /**
     * utilisateur de modification ecriture
     */
    private Long ecrUserModif;


    /**
     * code journal table planJournauxComptables
     */
    private String ecrCode;


    /**
     * date de saisie
     */
    private LocalDate ecrDateSaisie;


    /**
     * MM:AAAA par rapport a la date de saisie
     */
    private String ecrPeriode;


    /**
     * partie jour de la date de saisie
     */
    private Integer ecrJour;


    /**
     * partie annee de la date de saisie
     */
    private String ecrAnnee;


    /**
     * code nature par rapport a la nature du compte
     */
    private Integer ecrNature;


    /**
     * numero de compte
     */
    private String ecrCompte;


    /**
     * libelle du numero de compte
     */
    private String ecrLibcompte;


    /**
     * premier caractere du numero de compte
     */
    private String ecrClasse;


    /**
     * numero de contre partie
     */
    private String ecrContrePartie;


    /**
     * devise de saisie
     */
    private String ecrDeviseSaisie;


    /**
     * montant credit dans la devise de saisie
     */
    private Double ecrDebitSaisie;


    /**
     * montant credit dans la devise de saisie
     */
    private Double ecrCreditSaisie;


    /**
     * coef de conversion en euro
     */
    private Float ecrCoefEuro;


    /**
     * montant credit en euro
     */
    private Double ecrDebitEuro;


    /**
     * montant credit en euro
     */
    private Double ecrCreditEuro;


    /**
     * devise du pays
     */
    private String ecrDevisePays;


    /**
     * coef de conversion dans la devise du pays
     */
    private Float ecrCoefPays;


    /**
     * montant credit dans la devise du pays
     */
    private Double ecrDebitPays;


    /**
     * montant credit dans la devise du pays
     */
    private Double ecrCreditPays;


    /**
     * devise du groupe
     */
    private String ecrDeviseGrp;


    /**
     * coef de conversion dans la devise du groupe
     */
    private Float ecrCoefGrp;


    /**
     * montant credit dans la devise du groupe
     */
    private Double ecrDebitGrp;


    /**
     * montant credit dans la devise du groupe
     */
    private Double ecrCreditGrp;


    /**
     * code lettrage ecriture
     */
    private String ecrLettrage;


    /**
     * code de pointage
     */
    private String ecrPointage;


    /**
     * code de rapprochement MM:AAAA
     */
    private String ecrRapprochement;


    /**
     * 0=en cours 1=cloture mensuelle 2=cloture annuelle
     */
    private Integer ecrCloture;


    /**
     * date echeance
     */
    private LocalDate ecrDateEcheance;


    /**
     * 0 meme bnq sur place 1 meme bnq hors place 2 autre bnq sur place 3 autre bnq hors place
     */
    private Integer ecrOrigineBanque;


    /**
     * date de valeur theorique
     */
    private LocalDate ecrDateValeurTheo;


    /**
     * date de valeur relle
     */
    private LocalDate ecrDateValeurReelle;


    /**
     * libelle ecriture
     */
    private String ecrLibelle;


    /**
     * numero de piece comptable
     */
    private String ecrPiece;


    /**
     * reference 1
     */
    private String ecrReference1;


    /**
     * reference 2
     */
    private String ecrReference2;


    /**
     * imputation tresorerie
     */
    private String ecrTreso;


    /**
     * date de paiement
     */
    private LocalDate ecrDatePaiement;


    /**
     * numero identification fiscale des fournisseurs
     */
    private String ecrNumIf;


    /**
     * nautre des journaux
     */
    private Integer ecrNatureJrx;


    /**
     * 0=public 1=prive
     */
    private Integer ecrReserve;


    /**
     * ordre ecriture
     */
    private Long ecrOrdre;


    /**
     * 0 analytique non actif 1 analytique actif
     */
    private Integer ecrAnaActif;


    /**
     * 0=en cours 1=valide
     */
    private Integer ecrEtat;


    /**
     * date de destruction ecriture
     */
    private LocalDateTime ecrDateDelete;


    /**
     * utilisateur de destruction ecriture
     */
    private Long ecrUserDelete;


    /**
     * id ecriture generale
     */
    private Long ecrIdGene;


    /**
     * code budget
     */
    private String ecrBudgetTreso;


    /**
     * code poste
     */
    private String ecrPosteTreso;

}
