package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cpt_ecritures_destroy")
public class CptEcrituresDestroy implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ecr_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ecrId;

    /**
     * id origine de la table origine (pour les transferts)
     */
    @Column(name = "ecr_id_origine")
    private Long ecrIdOrigine = 0L;

    /**
     * AM = amortissement LO=loyer FV=facture vente FA=facture fournisseur (pour les transferts)
     */
    @Column(name = "ecr_type_origine")
    private String ecrTypeOrigine;

    /**
     * concatenation ecr_code:ecr_periode
     */
    @Column(name = "ecr_cle1")
    private String ecrCle1;

    /**
     * concatenation ecr_code:ecr_date
     */
    @Column(name = "ecr_cle2")
    private String ecrCle2;

    /**
     * date de creation ecriture
     */
    @Column(name = "ecr_date_creat")
    private LocalDateTime ecrDateCreat;

    /**
     * date de modification ecriture
     */
    @Column(name = "ecr_date_modif")
    private LocalDateTime ecrDateModif;

    /**
     * utilisateur de creation ecriture
     */
    @Column(name = "ecr_user_creat")
    private Long ecrUserCreat = 0L;

    /**
     * utilisateur de modification ecriture
     */
    @Column(name = "ecr_user_modif")
    private Long ecrUserModif = 0L;

    /**
     * code journal table planJournauxComptables
     */
    @Column(name = "ecr_code")
    private String ecrCode;

    /**
     * date de saisie
     */
    @Column(name = "ecr_date_saisie")
    private LocalDate ecrDateSaisie;

    /**
     * MM:AAAA par rapport a la date de saisie
     */
    @Column(name = "ecr_periode")
    private String ecrPeriode;

    /**
     * partie jour de la date de saisie
     */
    @Column(name = "ecr_jour")
    private Integer ecrJour = 0;

    /**
     * partie annee de la date de saisie
     */
    @Column(name = "ecr_annee")
    private String ecrAnnee;

    /**
     * code nature par rapport a la nature du compte
     */
    @Column(name = "ecr_nature")
    private Integer ecrNature = 0;

    /**
     * numero de compte
     */
    @Column(name = "ecr_compte")
    private String ecrCompte;

    /**
     * libelle du numero de compte
     */
    @Column(name = "ecr_libcompte")
    private String ecrLibcompte;

    /**
     * premier caractere du numero de compte
     */
    @Column(name = "ecr_classe")
    private String ecrClasse;

    /**
     * numero de contre partie
     */
    @Column(name = "ecr_contre_partie")
    private String ecrContrePartie = "0";

    /**
     * devise de saisie
     */
    @Column(name = "ecr_devise_saisie")
    private String ecrDeviseSaisie;

    /**
     * montant credit dans la devise de saisie
     */
    @Column(name = "ecr_debit_saisie")
    private Double ecrDebitSaisie = 0D;

    /**
     * montant credit dans la devise de saisie
     */
    @Column(name = "ecr_credit_saisie")
    private Double ecrCreditSaisie = 0D;

    /**
     * coef de conversion en euro
     */
    @Column(name = "ecr_coef_euro")
    private Float ecrCoefEuro = 0F;

    /**
     * montant credit en euro
     */
    @Column(name = "ecr_debit_euro")
    private Double ecrDebitEuro = 0D;

    /**
     * montant credit en euro
     */
    @Column(name = "ecr_credit_euro")
    private Double ecrCreditEuro = 0D;

    /**
     * devise du pays
     */
    @Column(name = "ecr_devise_pays")
    private String ecrDevisePays;

    /**
     * coef de conversion dans la devise du pays
     */
    @Column(name = "ecr_coef_pays")
    private Float ecrCoefPays = 0F;

    /**
     * montant credit dans la devise du pays
     */
    @Column(name = "ecr_debit_pays")
    private Double ecrDebitPays = 0D;

    /**
     * montant credit dans la devise du pays
     */
    @Column(name = "ecr_credit_pays")
    private Double ecrCreditPays = 0D;

    /**
     * devise du groupe
     */
    @Column(name = "ecr_devise_grp")
    private String ecrDeviseGrp;

    /**
     * coef de conversion dans la devise du groupe
     */
    @Column(name = "ecr_coef_grp")
    private Float ecrCoefGrp = 0F;

    /**
     * montant credit dans la devise du groupe
     */
    @Column(name = "ecr_debit_grp")
    private Double ecrDebitGrp = 0D;

    /**
     * montant credit dans la devise du groupe
     */
    @Column(name = "ecr_credit_grp")
    private Double ecrCreditGrp = 0D;

    /**
     * code lettrage ecriture
     */
    @Column(name = "ecr_lettrage")
    private String ecrLettrage;

    /**
     * code de pointage
     */
    @Column(name = "ecr_pointage")
    private String ecrPointage = "0";

    /**
     * code de rapprochement MM:AAAA
     */
    @Column(name = "ecr_rapprochement")
    private String ecrRapprochement;

    /**
     * 0=en cours 1=cloture mensuelle 2=cloture annuelle
     */
    @Column(name = "ecr_cloture")
    private Integer ecrCloture = 0;

    /**
     * date echeance
     */
    @Column(name = "ecr_date_echeance")
    private LocalDate ecrDateEcheance;

    /**
     * 0 meme bnq sur place 1 meme bnq hors place 2 autre bnq sur place 3 autre bnq hors place
     */
    @Column(name = "ecr_origine_banque")
    private Integer ecrOrigineBanque = 0;

    /**
     * date de valeur theorique
     */
    @Column(name = "ecr_date_valeur_theo")
    private LocalDate ecrDateValeurTheo;

    /**
     * date de valeur relle
     */
    @Column(name = "ecr_date_valeur_reelle")
    private LocalDate ecrDateValeurReelle;

    /**
     * libelle ecriture
     */
    @Column(name = "ecr_libelle")
    private String ecrLibelle;

    /**
     * numero de piece comptable
     */
    @Column(name = "ecr_piece")
    private String ecrPiece;

    /**
     * reference 1
     */
    @Column(name = "ecr_reference1")
    private String ecrReference1;

    /**
     * reference 2
     */
    @Column(name = "ecr_reference2")
    private String ecrReference2;

    /**
     * imputation tresorerie
     */
    @Column(name = "ecr_treso")
    private String ecrTreso;

    /**
     * date de paiement
     */
    @Column(name = "ecr_date_paiement")
    private LocalDate ecrDatePaiement;

    /**
     * numero identification fiscale des fournisseurs
     */
    @Column(name = "ecr_num_if")
    private String ecrNumIf;

    /**
     * nautre des journaux
     */
    @Column(name = "ecr_nature_jrx")
    private Integer ecrNatureJrx = 0;

    /**
     * 0=public 1=prive
     */
    @Column(name = "ecr_reserve")
    private Integer ecrReserve = 0;

    /**
     * ordre ecriture
     */
    @Column(name = "ecr_ordre")
    private Long ecrOrdre = 0L;

    /**
     * 0 analytique non actif 1 analytique actif
     */
    @Column(name = "ecr_ana_Actif")
    private Integer ecrAnaActif = 0;

    /**
     * 0=en cours 1=valide
     */
    @Column(name = "ecr_etat")
    private Integer ecrEtat = 0;

    /**
     * date de destruction ecriture
     */
    @Column(name = "ecr_date_delete")
    private LocalDateTime ecrDateDelete;

    /**
     * utilisateur de destruction ecriture
     */
    @Column(name = "ecr_user_delete")
    private Long ecrUserDelete;

    /**
     * id ecriture generale
     */
    @Column(name = "ecr_id_gene")
    private Long ecrIdGene;

    /**
     * code budget
     */
    @Column(name = "ecr_budget_treso")
    private String ecrBudgetTreso;

    /**
     * code poste
     */
    @Column(name = "ecr_poste_treso")
    private String ecrPosteTreso;

}
