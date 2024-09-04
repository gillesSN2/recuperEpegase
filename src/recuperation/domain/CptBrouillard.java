package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cpt_brouillard")
public class CptBrouillard implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "bro_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long broId;

    /**
     * id origine de la table origine (pour les transferts)
     */
    @Column(name = "bro_id_origine")
    private Long broIdOrigine = 0L;

    /**
     * AM = amortissement LO=loyer VE=facture vente AC=facture fournisseur (pour les transferts)
     */
    @Column(name = "bro_type_origine")
    private String broTypeOrigine;

    /**
     * date de creation de l ecriture
     */
    @Column(name = "bro_date_creat")
    private LocalDateTime broDateCreat;

    /**
     * date de modification de l ecriture
     */
    @Column(name = "bro_date_modif")
    private LocalDateTime broDateModif;

    /**
     * utilisateur de creation de l ecriture
     */
    @Column(name = "bro_user_creat")
    private Long broUserCreat = 0L;

    /**
     * utilisateur de modification de l ecriture
     */
    @Column(name = "bro_user_modif")
    private Long broUserModif = 0L;

    /**
     * code journal table planJournauxComptables
     */
    @Column(name = "bro_code")
    private String broCode;

    /**
     * date de saisie
     */
    @Column(name = "bro_date_saisie")
    private LocalDate broDateSaisie;

    /**
     * MM:AAAA par rapport aÃ‚Â  la date de saisie
     */
    @Column(name = "bro_periode")
    private String broPeriode;

    /**
     * partie jour de la date de saisie
     */
    @Column(name = "bro_jour")
    private Integer broJour = 1;

    /**
     * partie annee de la date de saisie
     */
    @Column(name = "bro_annee")
    private String broAnnee;

    /**
     * devise de saisie
     */
    @Column(name = "bro_devise_saisie")
    private String broDeviseSaisie;

    /**
     * montant credit dans la devise de saisie
     */
    @Column(name = "bro_debit_saisie")
    private Double broDebitSaisie = 0D;

    /**
     * montant credit dans la devise de saisie
     */
    @Column(name = "bro_credit_saisie")
    private Double broCreditSaisie = 0D;

    /**
     * coef de conversion en euro
     */
    @Column(name = "bro_coef_euro")
    private Float broCoefEuro = 0F;

    /**
     * montant credit en euro
     */
    @Column(name = "bro_debit_euro")
    private Double broDebitEuro = 0D;

    /**
     * montant credit en euro
     */
    @Column(name = "bro_credit_euro")
    private Double broCreditEuro = 0D;

    /**
     * devise du pays
     */
    @Column(name = "bro_devise_pays")
    private String broDevisePays;

    /**
     * coef de conversion dans la devise du pays
     */
    @Column(name = "bro_coef_pays")
    private Float broCoefPays = 0F;

    /**
     * montant credit dans la devise du pays
     */
    @Column(name = "bro_debit_pays")
    private Double broDebitPays = 0D;

    /**
     * montant credit dans la devise du pays
     */
    @Column(name = "bro_credit_pays")
    private Double broCreditPays = 0D;

    /**
     * devise du groupe
     */
    @Column(name = "bro_devise_grp")
    private String broDeviseGrp;

    /**
     * coef de conversion dans la devise du groupe
     */
    @Column(name = "bro_coef_grp")
    private Float broCoefGrp = 0F;

    /**
     * montant credit dans la devise du groupe
     */
    @Column(name = "bro_debit_grp")
    private Double broDebitGrp = 0D;

    /**
     * montant credit dans la devise du groupe
     */
    @Column(name = "bro_credit_grp")
    private Double broCreditGrp = 0D;

    /**
     * 0=en cours 1=cloture mensuelle 2=cloture annuelle
     */
    @Column(name = "bro_cloture")
    private Integer broCloture;

    /**
     * 0=en cours 1=valide 2=transfere
     */
    @Column(name = "bro_etat")
    private Integer broEtat;

    /**
     * libelle de l ecriture
     */
    @Column(name = "bro_libelle")
    private String broLibelle;

    /**
     * numero de piece comptable
     */
    @Column(name = "bro_piece")
    private String broPiece;

    /**
     * numero de brouillard
     */
    @Column(name = "bro_num")
    private Long broNum = 0L;

    /**
     * reference 1
     */
    @Column(name = "bro_reference1")
    private String broReference1;

    /**
     * reference 2
     */
    @Column(name = "bro_reference2")
    private String broReference2;

    /**
     * = nautre des journaux
     */
    @Column(name = "bro_nature_jrx")
    private Integer broNatureJrx = 0;

    @Column(name = "execpt_id", nullable = false)
    private Long execptId;

    /**
     * numero de transfert
     */
    @Column(name = "bro_num_trf")
    private String broNumTrf;

}
