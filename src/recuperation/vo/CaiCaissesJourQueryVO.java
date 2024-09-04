package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CaiCaissesJourQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long caijouId;


    /**
     * date de cloture
     */
    private LocalDateTime caijouDateCloture;


    /**
     * user utilisation de cloture
     */
    private Long caijouUserIdCloture;


    /**
     * date de transfert
     */
    private LocalDateTime caijouDateTransfert;


    /**
     * user utilisation de transfert
     */
    private Long caijouUserIdTransfert;


    /**
     * code caisse
     */
    private String caijouCode;


    /**
     * periode MMAAAA
     */
    private String caijouPeriode;


    /**
     * date du jour
     */
    private LocalDate caijouDate;


    /**
     * user utilisation caisse
     */
    private Long caijouUserIdCaisse;


    /**
     * 0=journal ferme 1=journal ouvert
     */
    private Integer caijouOpenJournal;


    /**
     * nom utilisateur en cours
     */
    private String caijouOpenUserJournal;


    /**
     * = concatenation caijou_code : caijou_periode
     */
    private String caijouCle1;


    /**
     * 0=en cours 1=cloture mensuelle 2=transfert en compta
     */
    private Integer caijouEtat;


    /**
     * solde de la caisse anterieur
     */
    private Double caijouSoldeEspece;


    /**
     * solde de la caisse anterieur
     */
    private Double caijouSoldeCheque;


    /**
     * solde de la caisse anterieur
     */
    private Double caijouSoldeVirement;


    /**
     * solde de la caisse anterieur
     */
    private Double caijouSoldeTraite;


    /**
     * solde de la caisse anterieur
     */
    private Double caijouSoldeTpe;


    /**
     * solde de la caisse anterieur
     */
    private Double caijouSoldeEpaiement;


    /**
     * solde de la caisse anterieur
     */
    private Double caijouSoldeTransfert;


    /**
     * solde de la caisse anterieur
     */
    private Double caijouSoldeCredoc;


    /**
     * solde de la caisse anterieur
     */
    private Double caijouSoldeFactor;


    /**
     * solde de la caisse anterieur
     */
    private Double caijouSoldeCompense;


    /**
     * solde de la caisse anterieur
     */
    private Double caijouSoldeTerme;

    private Long execaiId;


    /**
     * nombre billet
     */
    private Integer caijouB1;


    /**
     * nombre billet
     */
    private Integer caijouB2;


    /**
     * nombre billet
     */
    private Integer caijouB3;


    /**
     * nombre billet
     */
    private Integer caijouB4;


    /**
     * nombre billet
     */
    private Integer caijouB5;


    /**
     * nombre billet
     */
    private Integer caijouB6;


    /**
     * nombre billet
     */
    private Integer caijouB7;


    /**
     * nombre billet
     */
    private Integer caijouB8;


    /**
     * nombre billet
     */
    private Integer caijouB9;


    /**
     * nombre billet
     */
    private Integer caijouB10;


    /**
     * nombre billet
     */
    private Integer caijouP1;


    /**
     * nombre billet
     */
    private Integer caijouP2;


    /**
     * nombre billet
     */
    private Integer caijouP3;


    /**
     * nombre billet
     */
    private Integer caijouP4;


    /**
     * nombre billet
     */
    private Integer caijouP5;


    /**
     * nombre billet
     */
    private Integer caijouP6;


    /**
     * nombre billet
     */
    private Integer caijouP7;


    /**
     * nombre billet
     */
    private Integer caijouP8;


    /**
     * nombre billet
     */
    private Integer caijouP9;


    /**
     * nombre billet
     */
    private Integer caijouP10;


    /**
     * total des bons
     */
    private Double caijouBon;


    /**
     * total des espece
     */
    private Double caijouEspece;


    /**
     * total des timbres
     */
    private Double caijouTimbre;


    /**
     * total des hors especes
     */
    private Double caijouAutre;


    /**
     * total devise 1
     */
    private Double caijouDevise1;


    /**
     * total devise 2
     */
    private Double caijouDevise2;


    /**
     * total devise 3
     */
    private Double caijouDevise3;


    /**
     * total devise 4
     */
    private Double caijouDevise4;


    /**
     * total devise 5
     */
    private Double caijouDevise5;


    /**
     * ecart
     */
    private Double caijouEcart;


    /**
     * observation sur la journee
     */
    private String caijouObservation;


    /**
     * solde de la caisse anterieur
     */
    private Double caijouSoldeBonCaisse;


    /**
     * total des espece theorique
     */
    private Double caijouEspeceTheorique;


    /**
     * total des espece apres comptage
     */
    private Double caijouEspeceReel;


    /**
     * date de contrle
     */
    private LocalDate caijouControle;

}
