package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class CmmProduitsFournisseurDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long profouId;


    /**
     * reference fournisseur
     */
    private String profouRef;


    /**
     * libelle fournisseur
     */
    private String profouLib;


    /**
     * prix achat
     */
    private Double profouPa;


    /**
     * code devise
     */
    private String profouDevise;


    /**
     * format devise 0=us 1=fr 2=afr
     */
    private Integer profouFormat;


    /**
     * coefficient de conversion en euro
     */
    private Float profouCoefEuro;


    /**
     * coefficient de conversion en devise locale
     */
    private Float profouCoefLocal;


    /**
     * prix achat local
     */
    private Double profouPaLocal;


    /**
     * prix achat euro
     */
    private Double profouPaEuro;


    /**
     * date dernier achat
     */
    private LocalDate profouDate;


    /**
     * conditionnement 1
     */
    private String profouCondition1;


    /**
     * conditionnement 2
     */
    private String profouCondition2;


    /**
     * conditionnement 3
     */
    private String profouCondition3;


    /**
     * conditionnement 4
     */
    private String profouCondition4;


    /**
     * conditionnement 5
     */
    private String profouCondition5;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer profouInactif;

    private Long proId;

    private Long tieId;


    /**
     * taux devise
     */
    private Float profouTauxDevise;

}
