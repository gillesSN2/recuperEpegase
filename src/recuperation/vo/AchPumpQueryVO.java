package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AchPumpQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long pumId;


    /**
     * date de creation
     */
    private LocalDateTime pumDateCreat;


    /**
     * id user createur
     */
    private Long pumIdCreateur;


    /**
     * id du document origine
     */
    private Long pumIdDocOrigine;


    /**
     * numero du document origine
     */
    private String pumNumDocOrigine;


    /**
     * nature du document origine
     */
    private Integer pumNatureOrigine;


    /**
     * id ligne origine
     */
    private Long pumIdLigneOrigine;


    /**
     * date
     */
    private LocalDateTime pumDate;


    /**
     * code depot
     */
    private String pumDepot;


    /**
     * code produit
     */
    private String pumProduit;


    /**
     * prix achat
     */
    private Double pumPa;


    /**
     * prix revient
     */
    private Double pumPr;


    /**
     * pump
     */
    private Double pumPump;


    /**
     * qte operation
     */
    private Float pumQteOperation;


    /**
     * qte stock avant operation
     */
    private Float pumQteStock;

    private Long exeachId;


    /**
     * prix revient au kilo
     */
    private Double pumPrKg;


    /**
     * code dossier
     */
    private String pumDossier;

}
