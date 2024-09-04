package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class CmmProduitsFraisDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long profrsId;


    /**
     * ordre des reponses
     */
    private Integer profrsOrdre;


    /**
     * nom feuille
     */
    private String profrsFeuille;


    /**
     * numero de calcul
     */
    private String profrsNum;


    /**
     * type de la feuille
     */
    private Integer profrsType;


    /**
     * date de creation
     */
    private LocalDate profrsDate;


    /**
     * code
     */
    private String profrsCode;


    /**
     * nom item en FR
     */
    private String profrsLibelle;


    /**
     * taux
     */
    private Float profrsTaux;


    /**
     * formule
     */
    private String profrsFormule;


    /**
     * valeur HT
     */
    private Double profrsHt;


    /**
     * valeur exoneration partielle
     */
    private Double profrsExoPartielle;


    /**
     * valeur exoneration complete
     */
    private Double profrsExoComplete;


    /**
     * autorise dans la colonne ht
     */
    private Boolean profrsColHt;


    /**
     * autorise dans la colonne exo partielle
     */
    private Boolean profrsColExop;


    /**
     * autorise dans la colonne exo totale
     */
    private Boolean profrsColExot;


    /**
     * 0=standard 1=prc 2=prg
     */
    private Integer profrsColType;


    /**
     * prix achat en devise
     */
    private Double profrsPa;


    /**
     * fret en devise
     */
    private Double profrsFret;


    /**
     * assurance locale
     */
    private Double profrsAssurance;


    /**
     * devise
     */
    private String profrsDevise;


    /**
     * coefficient devise
     */
    private Float profrsCoefDevise;


    /**
     * total caf
     */
    private Double profrsCaf;

    private Long proId;

}
