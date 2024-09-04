package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CaiCaissesInventaireDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long caiinvId;


    /**
     * date creation
     */
    private LocalDateTime caiinvDateCreation;


    /**
     * user utilisation creation
     */
    private Long caiinvUserIdCreation;


    /**
     * date modification
     */
    private LocalDateTime caiinvDateModif;


    /**
     * user utilisation modification
     */
    private Long caiinvUserIdModif;


    /**
     * code caisse
     */
    private String caiinvCodeCaisse;


    /**
     * libelle caisse
     */
    private String caiinvLibCaisse;


    /**
     * serie
     */
    private String caiinvSerie;


    /**
     * periode MMAAAA
     */
    private String caiinvPeriode;


    /**
     * date du jour
     */
    private LocalDate caiinvDate;


    /**
     * numero inventaire
     */
    private String caiinvNum;


    /**
     * date du controle
     */
    private LocalDate caiinvDateCtrl;


    /**
     * id caisse jour controle
     */
    private Long caiinvCaisseIdCtrl;


    /**
     * user utilisation caisse
     */
    private Long caiinvUserIdCaisse;


    /**
     * user utilisation caisse
     */
    private Long caiinvUserNomCaisse;


    /**
     * 0=en cours 1=cloture
     */
    private Integer caiinvEtat;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeEspece;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeCheque;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeVirement;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeTraite;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeTpe;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeEpaiement;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeTransfert;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeCredoc;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeFactor;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeCompense;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeTerme;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeBonCaisse;


    /**
     * nombre billet
     */
    private Integer caiinvB1;


    /**
     * nombre billet
     */
    private Integer caiinvB2;


    /**
     * nombre billet
     */
    private Integer caiinvB3;


    /**
     * nombre billet
     */
    private Integer caiinvB4;


    /**
     * nombre billet
     */
    private Integer caiinvB5;


    /**
     * nombre billet
     */
    private Integer caiinvB6;


    /**
     * nombre billet
     */
    private Integer caiinvB7;


    /**
     * nombre billet
     */
    private Integer caiinvB8;


    /**
     * nombre billet
     */
    private Integer caiinvB9;


    /**
     * nombre billet
     */
    private Integer caiinvB10;


    /**
     * nombre billet
     */
    private Integer caiinvP1;


    /**
     * nombre billet
     */
    private Integer caiinvP2;


    /**
     * nombre billet
     */
    private Integer caiinvP3;


    /**
     * nombre billet
     */
    private Integer caiinvP4;


    /**
     * nombre billet
     */
    private Integer caiinvP5;


    /**
     * nombre billet
     */
    private Integer caiinvP6;


    /**
     * nombre billet
     */
    private Integer caiinvP7;


    /**
     * nombre billet
     */
    private Integer caiinvP8;


    /**
     * nombre billet
     */
    private Integer caiinvP9;


    /**
     * nombre billet
     */
    private Integer caiinvP10;


    /**
     * total des bons
     */
    private Double caiinvBon;


    /**
     * total des espece
     */
    private Double caiinvEspece;


    /**
     * total des timbres
     */
    private Double caiinvTimbre;


    /**
     * total des hors especes
     */
    private Double caiinvAutre;


    /**
     * total devise 1
     */
    private Double caiinvDevise1;


    /**
     * total devise 2
     */
    private Double caiinvDevise2;


    /**
     * total devise 3
     */
    private Double caiinvDevise3;


    /**
     * total devise 4
     */
    private Double caiinvDevise4;


    /**
     * total devise 5
     */
    private Double caiinvDevise5;


    /**
     * ecart
     */
    private Double caiinvEcart;


    /**
     * observation sur inventaire
     */
    private String caiinvObservation;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeEspeceReel;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeChequeReel;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeVirementReel;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeTraiteReel;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeTpeReel;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeEpaiementReel;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeTransfertReel;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeCredocReel;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeFactorReel;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeCompenseReel;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeTermeReel;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeBonCaisseReel;


    /**
     * nombre billet
     */
    private Integer caiinvB1Reel;


    /**
     * nombre billet
     */
    private Integer caiinvB2Reel;


    /**
     * nombre billet
     */
    private Integer caiinvB3Reel;


    /**
     * nombre billet
     */
    private Integer caiinvB4Reel;


    /**
     * nombre billet
     */
    private Integer caiinvB5Reel;


    /**
     * nombre billet
     */
    private Integer caiinvB6Reel;


    /**
     * nombre billet
     */
    private Integer caiinvB7Reel;


    /**
     * nombre billet
     */
    private Integer caiinvB8Reel;


    /**
     * nombre billet
     */
    private Integer caiinvB9Reel;


    /**
     * nombre billet
     */
    private Integer caiinvB10Reel;


    /**
     * nombre billet
     */
    private Integer caiinvP1Reel;


    /**
     * nombre billet
     */
    private Integer caiinvP2Reel;


    /**
     * nombre billet
     */
    private Integer caiinvP3Reel;


    /**
     * nombre billet
     */
    private Integer caiinvP4Reel;


    /**
     * nombre billet
     */
    private Integer caiinvP5Reel;


    /**
     * nombre billet
     */
    private Integer caiinvP6Reel;


    /**
     * nombre billet
     */
    private Integer caiinvP7Reel;


    /**
     * nombre billet
     */
    private Integer caiinvP8Reel;


    /**
     * nombre billet
     */
    private Integer caiinvP9Reel;


    /**
     * nombre billet
     */
    private Integer caiinvP10Reel;


    /**
     * total des bons
     */
    private Double caiinvBonReel;


    /**
     * total des espece
     */
    private Double caiinvEspeceReel;


    /**
     * total des timbres
     */
    private Double caiinvTimbreReel;


    /**
     * total des hors especes
     */
    private Double caiinvAutreReel;


    /**
     * total devise 1
     */
    private Double caiinvDevise1Reel;


    /**
     * total devise 2
     */
    private Double caiinvDevise2Reel;


    /**
     * total devise 3
     */
    private Double caiinvDevise3Reel;


    /**
     * total devise 4
     */
    private Double caiinvDevise4Reel;


    /**
     * total devise 5
     */
    private Double caiinvDevise5Reel;


    /**
     * ecart
     */
    private Double caiinvEcartReel;


    /**
     * date impression
     */
    private LocalDate caiinvDateImpression;


    /**
     * modele impression
     */
    private String caiinvModeleImp;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeEspeceEcart;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeChequeEcart;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeVirementEcart;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeTraiteEcart;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeTpeEcart;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeEpaiementEcart;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeTransfertEcart;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeCredocEcart;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeFactorEcart;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeCompenseEcart;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeTermeEcart;


    /**
     * solde de la caisse anterieur
     */
    private Double caiinvSoldeBonCaisseEcart;


    /**
     * nombre billet
     */
    private Integer caiinvB1Ecart;


    /**
     * nombre billet
     */
    private Integer caiinvB2Ecart;


    /**
     * nombre billet
     */
    private Integer caiinvB3Ecart;


    /**
     * nombre billet
     */
    private Integer caiinvB4Ecart;


    /**
     * nombre billet
     */
    private Integer caiinvB5Ecart;


    /**
     * nombre billet
     */
    private Integer caiinvB6Ecart;


    /**
     * nombre billet
     */
    private Integer caiinvB7Ecart;


    /**
     * nombre billet
     */
    private Integer caiinvB8Ecart;


    /**
     * nombre billet
     */
    private Integer caiinvB9Ecart;


    /**
     * nombre billet
     */
    private Integer caiinvB10Ecart;


    /**
     * nombre billet
     */
    private Integer caiinvP1Ecart;


    /**
     * nombre billet
     */
    private Integer caiinvP2Ecart;


    /**
     * nombre billet
     */
    private Integer caiinvP3Ecart;


    /**
     * nombre billet
     */
    private Integer caiinvP4Ecart;


    /**
     * nombre billet
     */
    private Integer caiinvP5Ecart;


    /**
     * nombre billet
     */
    private Integer caiinvP6Ecart;


    /**
     * nombre billet
     */
    private Integer caiinvP7Ecart;


    /**
     * nombre billet
     */
    private Integer caiinvP8Ecart;


    /**
     * nombre billet
     */
    private Integer caiinvP9Ecart;


    /**
     * nombre billet
     */
    private Integer caiinvP10Ecart;


    /**
     * total des bons
     */
    private Double caiinvBonEcart;


    /**
     * total des espece
     */
    private Double caiinvEspeceEcart;


    /**
     * total des timbres
     */
    private Double caiinvTimbreEcart;


    /**
     * total des hors especes
     */
    private Double caiinvAutreEcart;


    /**
     * total devise 1
     */
    private Double caiinvDevise1Ecart;


    /**
     * total devise 2
     */
    private Double caiinvDevise2Ecart;


    /**
     * total devise 3
     */
    private Double caiinvDevise3Ecart;


    /**
     * total devise 4
     */
    private Double caiinvDevise4Ecart;


    /**
     * total devise 5
     */
    private Double caiinvDevise5Ecart;


    /**
     * ecart
     */
    private Double caiinvEcartEcart;

    private Long execaiId;

}
