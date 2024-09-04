package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CaiCaissesMoisQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long caimenId;


    /**
     * date de cloture
     */
    private LocalDateTime caiDateCloture;


    /**
     * user utilisation de cloture
     */
    private Long caimenUserIdCloture;


    /**
     * date de transfert
     */
    private LocalDateTime caiDateTransfert;


    /**
     * user utilisation de transfert
     */
    private Long caimenUserIdTransfert;


    /**
     * code caisse
     */
    private String caimenCode;


    /**
     * periode MMAAAA
     */
    private String caimenPeriode;


    /**
     * date du jour
     */
    private LocalDate caimenDate;


    /**
     * user utilisation caisse
     */
    private Long caimenUserIdCaisse;


    /**
     * 0=journal ferme 1=journal ouvert
     */
    private Integer caimenOpenJournal;


    /**
     * nom utilisateur en cours
     */
    private String caimenOpenUserJournal;


    /**
     * = concatenation caimen_code : caimen_periode
     */
    private String caimenCle1;


    /**
     * 0=en cours 1=cloture mensuelle 2=transfert en compta
     */
    private Integer caimenEtat;


    /**
     * solde de la caisse anterieur
     */
    private Double caimenSoldeEspece;


    /**
     * solde de la caisse anterieur
     */
    private Double caimenSoldeCheque;


    /**
     * solde de la caisse anterieur
     */
    private Double caimenSoldeVirement;


    /**
     * solde de la caisse anterieur
     */
    private Double caimenSoldeTraite;


    /**
     * solde de la caisse anterieur
     */
    private Double caimenSoldeTpe;


    /**
     * solde de la caisse anterieur
     */
    private Double caimenSoldeEpaiement;


    /**
     * solde de la caisse anterieur
     */
    private Double caimenSoldeTransfert;


    /**
     * solde de la caisse anterieur
     */
    private Double caimenSoldeCredoc;


    /**
     * solde de la caisse anterieur
     */
    private Double caimenSoldeFactor;


    /**
     * solde de la caisse anterieur
     */
    private Double caimenSoldeCompense;


    /**
     * solde de la caisse anterieur
     */
    private Double caimenSoldeTerme;

    private Long execaiId;


    /**
     * date de cloture
     */
    private LocalDateTime caimenDateCloture;


    /**
     * date de transfert
     */
    private LocalDateTime caimenDateTransfert;


    /**
     * nombre billet
     */
    private Integer caimenB1;


    /**
     * nombre billet
     */
    private Integer caimenB2;


    /**
     * nombre billet
     */
    private Integer caimenB3;


    /**
     * nombre billet
     */
    private Integer caimenB4;


    /**
     * nombre billet
     */
    private Integer caimenB5;


    /**
     * nombre billet
     */
    private Integer caimenB6;


    /**
     * nombre billet
     */
    private Integer caimenB7;


    /**
     * nombre billet
     */
    private Integer caimenB8;


    /**
     * nombre billet
     */
    private Integer caimenB9;


    /**
     * nombre billet
     */
    private Integer caimenB10;


    /**
     * nombre billet
     */
    private Integer caimenP1;


    /**
     * nombre billet
     */
    private Integer caimenP2;


    /**
     * nombre billet
     */
    private Integer caimenP3;


    /**
     * nombre billet
     */
    private Integer caimenP4;


    /**
     * nombre billet
     */
    private Integer caimenP5;


    /**
     * nombre billet
     */
    private Integer caimenP6;


    /**
     * nombre billet
     */
    private Integer caimenP7;


    /**
     * nombre billet
     */
    private Integer caimenP8;


    /**
     * nombre billet
     */
    private Integer caimenP9;


    /**
     * nombre billet
     */
    private Integer caimenP10;


    /**
     * total des bons
     */
    private Double caimenBon;


    /**
     * total des espece
     */
    private Double caimenEspece;


    /**
     * total des timbres
     */
    private Double caimenTimbre;


    /**
     * total des hors especes
     */
    private Double caimenAutre;


    /**
     * total devise 1
     */
    private Double caimenDevise1;


    /**
     * total devise 2
     */
    private Double caimenDevise2;


    /**
     * total devise 3
     */
    private Double caimenDevise3;


    /**
     * total devise 4
     */
    private Double caimenDevise4;


    /**
     * total devise 5
     */
    private Double caimenDevise5;


    /**
     * ecart
     */
    private Double caimenEcart;


    /**
     * observation sur la mois
     */
    private String caimenObservation;


    /**
     * solde de la caisse anterieur
     */
    private Double caimenSoldeBonCaisse;


    /**
     * total des espece
     */
    private Double caimenEspeceTheorique;


    /**
     * total des espece apres comptage
     */
    private Double caimenEspeceReel;


    /**
     * date de contrle
     */
    private LocalDate caimenControle;

}
